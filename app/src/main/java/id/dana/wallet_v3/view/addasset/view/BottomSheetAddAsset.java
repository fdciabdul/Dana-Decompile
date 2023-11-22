package id.dana.wallet_v3.view.addasset.view;

import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.databinding.BottomSheetAddAssetBinding;
import id.dana.databinding.BottomSheetAddAssetContainerBinding;
import id.dana.di.ComponentHolder;
import id.dana.di.modules.OauthModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.spm.ServicesTracker;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.wallet_v3.WalletH5ServicesImplementation;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.di.component.DaggerBottomSheetAddAssetComponent;
import id.dana.wallet_v3.di.module.BottomSheetAddAssetModule;
import id.dana.wallet_v3.util.WalletSectionPositionUtilKt;
import id.dana.wallet_v3.view.NewWalletFragment;
import id.dana.wallet_v3.view.addasset.adapter.AddAssetAdapter;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 ®\u00012\u00020\u0001:\u0002®\u0001Bw\u0012\u0012\b\u0002\u0010\u0091\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0090\u0001\u0012\u0007\u0010\u009e\u0001\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010«\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0ª\u0001\u0012\b\b\u0002\u0010^\u001a\u00020\u0014\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u000e\u0012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010~\u001a\u00020}\u0012\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u000106¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001bH\u0014¢\u0006\u0004\b!\u0010\u001dJ\u000f\u0010\"\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\"\u0010\u001dJ\u000f\u0010#\u001a\u00020\u001bH\u0002¢\u0006\u0004\b#\u0010\u001dJ\u000f\u0010$\u001a\u00020\u001bH\u0002¢\u0006\u0004\b$\u0010\u001dJ+\u0010)\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u00182\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u001bH\u0014¢\u0006\u0004\b/\u0010\u001dJ\u000f\u00100\u001a\u00020\u001bH\u0016¢\u0006\u0004\b0\u0010\u001dJ\u0017\u00102\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u0014H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u001bH\u0002¢\u0006\u0004\b4\u0010\u001dJ\u000f\u00105\u001a\u00020\u001bH\u0002¢\u0006\u0004\b5\u0010\u001dJ\u001d\u00108\u001a\u00020\u001b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001006H\u0002¢\u0006\u0004\b8\u00109J\u001d\u0010;\u001a\u00020\u001b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001006H\u0002¢\u0006\u0004\b;\u00109J\u001d\u0010=\u001a\u00020\u001b2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001006H\u0002¢\u0006\u0004\b=\u00109J\u001f\u0010?\u001a\u00020\u001b2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u000106H\u0002¢\u0006\u0004\b?\u00109J\u001d\u0010A\u001a\u00020\u001b2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001006H\u0002¢\u0006\u0004\bA\u00109J\u0017\u0010C\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0010H\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010\u000e8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010Q\u001a\u0004\u0018\u00010N8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR \u0010V\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020N0R8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\"\u0010X\u001a\u00020W8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020`8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR*\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u00109R\"\u0010l\u001a\u00020k8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010s\u001a\u00020r8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001b\u0010|\u001a\u00020&8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\by\u0010b\u001a\u0004\bz\u0010{R&\u0010~\u001a\u00020}8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0084\u0001\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010_R\u001e\u0010\u0087\u0001\u001a\u00020&8CX\u0083\u0084\u0002¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010b\u001a\u0005\b\u0086\u0001\u0010{R\u0016\u0010\u0088\u0001\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010_R(\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010I\u001a\u0005\b\u008a\u0001\u0010K\"\u0005\b\u008b\u0001\u0010MR\u0016\u0010\u008c\u0001\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010_R\u001e\u0010\u008f\u0001\u001a\u00020&8CX\u0083\u0084\u0002¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010b\u001a\u0005\b\u008e\u0001\u0010{R \u0010\u0091\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0090\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0016\u0010\u0093\u0001\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010_R\u001e\u0010\u0096\u0001\u001a\u00020&8CX\u0083\u0084\u0002¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010b\u001a\u0005\b\u0095\u0001\u0010{R*\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0016\u0010\u009e\u0001\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010_R\u0016\u0010\u009f\u0001\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010_R\u001e\u0010¢\u0001\u001a\u00020&8CX\u0083\u0084\u0002¢\u0006\u000e\n\u0005\b \u0001\u0010b\u001a\u0005\b¡\u0001\u0010{R*\u0010¤\u0001\u001a\u00030£\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R\u001d\u0010«\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0ª\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b«\u0001\u0010g"}, d2 = {"Lid/dana/wallet_v3/view/addasset/view/BottomSheetAddAsset;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "Lid/dana/utils/danah5/DanaH5Listener;", "createH5AppListener", "()Lid/dana/utils/danah5/DanaH5Listener;", "Landroid/widget/FrameLayout;", "getBottomSheet", "()Landroid/widget/FrameLayout;", "Lid/dana/wallet_v3/di/module/BottomSheetAddAssetModule;", "getBottomSheetAddAssetModule", "()Lid/dana/wallet_v3/di/module/BottomSheetAddAssetModule;", "", "getDimAmount", "()F", "", "url", "Lid/dana/model/ThirdPartyService;", "thirdPartyService", "getFormattedUrl", "(Ljava/lang/String;Lid/dana/model/ThirdPartyService;)Ljava/lang/String;", "", "getLayout", "()I", "index", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "(I)Landroidx/recyclerview/widget/RecyclerView;", "", "getServices", "()V", "Landroidx/appcompat/widget/AppCompatTextView;", "getTextView", "(I)Landroidx/appcompat/widget/AppCompatTextView;", IAPSyncCommand.COMMAND_INIT, "initAllList", "initInjector", "initList", "rv", "Lid/dana/wallet_v3/view/addasset/adapter/AddAssetAdapter;", "adapter", "title", "initRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;Lid/dana/wallet_v3/view/addasset/adapter/AddAssetAdapter;Landroidx/appcompat/widget/AppCompatTextView;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onShow", "onStart", "lastAddedAssetType", "setLastAddedAssetType", "(I)V", "setSectionTitle", "setupBottomSheet", "", "financialServices", "showFinancialSection", "(Ljava/util/List;)V", "identityServices", "showIdentitySection", "loyaltyServices", "showLoyaltySection", "paymentServices", "showPaymentSection", "voucherServices", "showVoucherSection", "it", "trackServiceOpen", "(Lid/dana/model/ThirdPartyService;)V", "Lid/dana/wallet_v3/view/addasset/view/BottomSheetAddAsset$walletH5Listener$1;", "walletH5Listener", "()Lid/dana/wallet_v3/view/addasset/view/BottomSheetAddAsset$walletH5Listener$1;", "accessToken", "Ljava/lang/String;", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "Lid/dana/databinding/BottomSheetAddAssetContainerBinding;", "getBinding", "()Lid/dana/databinding/BottomSheetAddAssetContainerBinding;", "binding", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "getBindingInflater", "()Lkotlin/jvm/functions/Function1;", "bindingInflater", "Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetPresenter;", "bottomSheetAddAssetPresenter", "Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetPresenter;", "getBottomSheetAddAssetPresenter", "()Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetPresenter;", "setBottomSheetAddAssetPresenter", "(Lid/dana/wallet_v3/view/addasset/presenter/BottomSheetAddAssetPresenter;)V", "danaDealsVersion", "I", "Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog$delegate", "Lkotlin/Lazy;", "getDanaLoadingDialog", "()Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog", "data", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "getDeviceInformationProvider", "()Lid/dana/data/config/DeviceInformationProvider;", "setDeviceInformationProvider", "(Lid/dana/data/config/DeviceInformationProvider;)V", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "setFeaturePresenter", "(Lid/dana/contract/deeplink/path/FeatureContract$Presenter;)V", "financialServiceAdapter$delegate", "getFinancialServiceAdapter", "()Lid/dana/wallet_v3/view/addasset/adapter/AddAssetAdapter;", "financialServiceAdapter", "", "identityAssetSaved", "Z", "getIdentityAssetSaved", "()Z", "setIdentityAssetSaved", "(Z)V", "identitySectionIndex", "identityServiceAdapter$delegate", "getIdentityServiceAdapter", "identityServiceAdapter", "investmentSectionIndex", WalletConstant.KYC_LEVEL, "getKycLevel", "setKycLevel", "loyaltySectionIndex", "loyaltyServiceAdapter$delegate", "getLoyaltyServiceAdapter", "loyaltyServiceAdapter", "Lkotlin/Function0;", "onDismissBottomSheet", "Lkotlin/jvm/functions/Function0;", "paymentSectionIndex", "paymentServiceAdapter$delegate", "getPaymentServiceAdapter", "paymentServiceAdapter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", HomeTabActivity.WALLET_SECTION, "voucherSectionIndex", "voucherServiceAdapter$delegate", "getVoucherServiceAdapter", "voucherServiceAdapter", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "walletH5ServicesImplementation", "Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "getWalletH5ServicesImplementation", "()Lid/dana/wallet_v3/WalletH5ServicesImplementation;", "setWalletH5ServicesImplementation", "(Lid/dana/wallet_v3/WalletH5ServicesImplementation;)V", "", "walletSectionOrderingList", "<init>", "(Lkotlin/jvm/functions/Function0;ILjava/util/List;ILjava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BottomSheetAddAsset extends BaseBottomSheetDialogFragment {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String DEALS_VERSION_PARAM_KEY = "version";
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static char getErrorConfigVersion;
    private static char lookAheadTest;
    private static char moveToNextValue;
    public static final int scheduleImpl;
    public Map<Integer, View> _$_findViewCache;
    private String accessToken;
    @Inject
    public BottomSheetAddAssetPresenter bottomSheetAddAssetPresenter;
    private final int danaDealsVersion;

    /* renamed from: danaLoadingDialog$delegate  reason: from kotlin metadata */
    private final Lazy danaLoadingDialog;
    private List<ThirdPartyService> data;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public FeatureContract.Presenter featurePresenter;

    /* renamed from: financialServiceAdapter$delegate  reason: from kotlin metadata */
    private final Lazy financialServiceAdapter;
    private boolean identityAssetSaved;
    private final int identitySectionIndex;

    /* renamed from: identityServiceAdapter$delegate  reason: from kotlin metadata */
    private final Lazy identityServiceAdapter;
    private final int investmentSectionIndex;
    private String kycLevel;
    private final int loyaltySectionIndex;

    /* renamed from: loyaltyServiceAdapter$delegate  reason: from kotlin metadata */
    private final Lazy loyaltyServiceAdapter;
    private final Function0<Unit> onDismissBottomSheet;
    private final int paymentSectionIndex;

    /* renamed from: paymentServiceAdapter$delegate  reason: from kotlin metadata */
    private final Lazy paymentServiceAdapter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    private final int section;
    private final int voucherSectionIndex;

    /* renamed from: voucherServiceAdapter$delegate  reason: from kotlin metadata */
    private final Lazy voucherServiceAdapter;
    @Inject
    public WalletH5ServicesImplementation walletH5ServicesImplementation;
    private final List<String> walletSectionOrderingList;
    public static final byte[] $$d = {TarHeader.LF_DIR, 93, -14, -126, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 7;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;

    public static /* synthetic */ void $r8$lambda$T2mvzcO6TQB_z4mD2kMLqD9owTM(BottomSheetAddAsset bottomSheetAddAsset) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        m3100onStart$lambda0(bottomSheetAddAsset);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    static {
        NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        PlaceComponentResult();
        KClassImpl$Data$declaredNonStaticMembers$2 = new byte[]{2, -87, 98, TarHeader.LF_FIFO, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        scheduleImpl = 196;
        INSTANCE = new Companion(null);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 63;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? 'b' : (char) 31) != 'b') {
            return;
        }
        int i2 = 70 / 0;
    }

    static void PlaceComponentResult() {
        moveToNextValue = (char) 56836;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = (char) 18631;
        getErrorConfigVersion = (char) 59585;
        lookAheadTest = (char) 45623;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0043 -> B:15:0x0045). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r5, byte r6, short r7, java.lang.Object[] r8) {
        /*
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 55
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            byte[] r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 * 2
            int r5 = 16 - r5
            int r7 = r7 * 15
            int r7 = 19 - r7
            int r6 = 106 - r6
            byte[] r1 = new byte[r5]
            int r5 = r5 + (-1)
            r2 = 45
            if (r0 != 0) goto L21
            r3 = 43
            goto L23
        L21:
            r3 = 45
        L23:
            r4 = 0
            if (r3 == r2) goto L33
            int r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r2 = r2 + 107
            int r3 = r2 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3
            int r2 = r2 % 2
            r2 = r7
            r3 = 0
            goto L45
        L33:
            r2 = 0
        L34:
            byte r3 = (byte) r6
            r1[r2] = r3
            int r3 = r2 + 1
            if (r2 != r5) goto L43
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r4)
            r8[r4] = r5
            return
        L43:
            r2 = r0[r7]
        L45:
            int r7 = r7 + 1
            int r2 = -r2
            int r6 = r6 + r2
            int r6 = r6 + 2
            r2 = r3
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.d(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = 75 - r7
            int r9 = r9 * 4
            int r9 = r9 + 42
            byte[] r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.$$d
            int r8 = r8 * 4
            int r8 = 4 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r8 = -r8
            int r7 = r7 + 1
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.e(byte, byte, short, java.lang.Object[]):void");
    }

    public final void _$_clearFindViewByIdCache() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        try {
            try {
                if (!(i % 2 != 0)) {
                    this._$_findViewCache.clear();
                    return;
                }
                this._$_findViewCache.clear();
                int i2 = 50 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (r2 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if ((r2 == null ? 'U' : '=') != '=') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r2 = getView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r2 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        r2 = r2.findViewById(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        if (r2 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        r4 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        r4 = 'J';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
    
        if (r4 == 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        r3 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 77;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        r0.put(java.lang.Integer.valueOf(r7), r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r7) {
        /*
            r6 = this;
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 52
            if (r0 != 0) goto L11
            r0 = 41
            goto L13
        L11:
            r0 = 52
        L13:
            r3 = 0
            if (r0 == r2) goto L2c
            java.util.Map<java.lang.Integer, android.view.View> r0 = r6._$_findViewCache
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            java.lang.Object r2 = r0.get(r2)
            android.view.View r2 = (android.view.View) r2
            r3.hashCode()     // Catch: java.lang.Throwable -> L2a
            if (r2 != 0) goto L28
            goto L43
        L28:
            r3 = r2
            goto L69
        L2a:
            r7 = move-exception
            throw r7
        L2c:
            java.util.Map<java.lang.Integer, android.view.View> r0 = r6._$_findViewCache
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            java.lang.Object r2 = r0.get(r2)
            android.view.View r2 = (android.view.View) r2
            r4 = 61
            if (r2 != 0) goto L3f
            r5 = 85
            goto L41
        L3f:
            r5 = 61
        L41:
            if (r5 == r4) goto L28
        L43:
            android.view.View r2 = r6.getView()
            if (r2 == 0) goto L69
            android.view.View r2 = r2.findViewById(r7)
            if (r2 == 0) goto L51
            r4 = 2
            goto L53
        L51:
            r4 = 74
        L53:
            if (r4 == r1) goto L56
            goto L69
        L56:
            int r3 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L67
            int r3 = r3 + 77
            int r4 = r3 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4     // Catch: java.lang.Exception -> L67
            int r3 = r3 % r1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.put(r7, r2)
            goto L28
        L67:
            r7 = move-exception
            throw r7
        L69:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset._$_findCachedViewById(int):android.view.View");
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 69;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                if (i % 2 != 0) {
                    int i2 = 19 / 0;
                    return 0.5f;
                }
                return 0.5f;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 55;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
        return R.layout.bottom_sheet_add_asset_container;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 77;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                boolean z = i % 2 != 0;
                super.onDestroyView();
                if (z) {
                    _$_clearFindViewByIdCache();
                    return;
                }
                _$_clearFindViewByIdCache();
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0090
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public BottomSheetAddAsset(kotlin.jvm.functions.Function0<kotlin.Unit> r2, int r3, java.util.List<java.lang.String> r4, int r5, java.lang.String r6, java.lang.String r7, boolean r8, java.util.List<id.dana.model.ThirdPartyService> r9) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch: java.lang.Exception -> L8e
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch: java.lang.Exception -> L8e
            r0.<init>()     // Catch: java.lang.Exception -> L8e
            java.util.Map r0 = (java.util.Map) r0     // Catch: java.lang.Exception -> L8e
            r1._$_findViewCache = r0     // Catch: java.lang.Exception -> L8e
            r1.<init>()     // Catch: java.lang.Exception -> L8e
            r1.onDismissBottomSheet = r2     // Catch: java.lang.Exception -> L8e
            r1.section = r3     // Catch: java.lang.Exception -> L8e
            r1.walletSectionOrderingList = r4     // Catch: java.lang.Exception -> L8e
            r1.danaDealsVersion = r5     // Catch: java.lang.Exception -> L8e
            r1.accessToken = r6     // Catch: java.lang.Exception -> L8e
            r1.kycLevel = r7     // Catch: java.lang.Exception -> L8e
            r1.identityAssetSaved = r8     // Catch: java.lang.Exception -> L8e
            r1.data = r9     // Catch: java.lang.Exception -> L8e
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$paymentServiceAdapter$2 r2 = new id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$paymentServiceAdapter$2     // Catch: java.lang.Exception -> L8e
            r2.<init>()     // Catch: java.lang.Exception -> L8e
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch: java.lang.Exception -> L8e
            kotlin.Lazy r2 = kotlin.LazyKt.lazy(r2)     // Catch: java.lang.Exception -> L8e
            r1.paymentServiceAdapter = r2     // Catch: java.lang.Exception -> L8e
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$loyaltyServiceAdapter$2 r2 = new id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$loyaltyServiceAdapter$2     // Catch: java.lang.Exception -> L8e
            r2.<init>()     // Catch: java.lang.Exception -> L8e
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch: java.lang.Exception -> L8e
            kotlin.Lazy r2 = kotlin.LazyKt.lazy(r2)     // Catch: java.lang.Exception -> L8e
            r1.loyaltyServiceAdapter = r2     // Catch: java.lang.Exception -> L8e
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$financialServiceAdapter$2 r2 = new id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$financialServiceAdapter$2     // Catch: java.lang.Exception -> L8e
            r2.<init>()     // Catch: java.lang.Exception -> L8e
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch: java.lang.Exception -> L8e
            kotlin.Lazy r2 = kotlin.LazyKt.lazy(r2)     // Catch: java.lang.Exception -> L8e
            r1.financialServiceAdapter = r2     // Catch: java.lang.Exception -> L8e
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$voucherServiceAdapter$2 r2 = new id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$voucherServiceAdapter$2     // Catch: java.lang.Exception -> L8e
            r2.<init>()     // Catch: java.lang.Exception -> L8e
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch: java.lang.Exception -> L8e
            kotlin.Lazy r2 = kotlin.LazyKt.lazy(r2)     // Catch: java.lang.Exception -> L8e
            r1.voucherServiceAdapter = r2     // Catch: java.lang.Exception -> L8e
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$danaLoadingDialog$2 r2 = new id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$danaLoadingDialog$2     // Catch: java.lang.Exception -> L8e
            r2.<init>()     // Catch: java.lang.Exception -> L8e
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch: java.lang.Exception -> L8e
            kotlin.Lazy r2 = kotlin.LazyKt.lazy(r2)     // Catch: java.lang.Exception -> L8e
            r1.danaLoadingDialog = r2     // Catch: java.lang.Exception -> L8e
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$identityServiceAdapter$2 r2 = new id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$identityServiceAdapter$2     // Catch: java.lang.Exception -> L8e
            r2.<init>()     // Catch: java.lang.Exception -> L8e
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch: java.lang.Exception -> L8e
            kotlin.Lazy r2 = kotlin.LazyKt.lazy(r2)     // Catch: java.lang.Exception -> L8e
            r1.identityServiceAdapter = r2     // Catch: java.lang.Exception -> L8e
            int r2 = id.dana.wallet_v3.util.WalletSectionPositionUtilKt.indexOfPaymentSection(r4)     // Catch: java.lang.Exception -> L8e
            r1.paymentSectionIndex = r2     // Catch: java.lang.Exception -> L8e
            int r2 = id.dana.wallet_v3.util.WalletSectionPositionUtilKt.indexOfInvestmentSection(r4)     // Catch: java.lang.Exception -> L8e
            r1.investmentSectionIndex = r2     // Catch: java.lang.Exception -> L8e
            int r2 = id.dana.wallet_v3.util.WalletSectionPositionUtilKt.indexOfVoucherAndTicketSection(r4)     // Catch: java.lang.Exception -> L8e
            r1.voucherSectionIndex = r2     // Catch: java.lang.Exception -> L8e
            int r2 = id.dana.wallet_v3.util.WalletSectionPositionUtilKt.indexOfLoyaltySection(r4)     // Catch: java.lang.Exception -> L8e
            r1.loyaltySectionIndex = r2     // Catch: java.lang.Exception -> L8e
            int r2 = id.dana.wallet_v3.util.WalletSectionPositionUtilKt.indexOfIdentitySection(r4)     // Catch: java.lang.Exception -> L8e
            r1.identitySectionIndex = r2     // Catch: java.lang.Exception -> L8e
            return
        L8e:
            r2 = move-exception
            throw r2
        L90:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.<init>(kotlin.jvm.functions.Function0, int, java.util.List, int, java.lang.String, java.lang.String, boolean, java.util.List):void");
    }

    public static final /* synthetic */ DanaH5Listener access$createH5AppListener(BottomSheetAddAsset bottomSheetAddAsset) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? (char) 4 : 'M') != 'M') {
            DanaH5Listener createH5AppListener = bottomSheetAddAsset.createH5AppListener();
            Object obj = null;
            obj.hashCode();
            return createH5AppListener;
        }
        return bottomSheetAddAsset.createH5AppListener();
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(BottomSheetAddAsset bottomSheetAddAsset) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 21;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            boolean z = i % 2 != 0;
            DanaLoadingDialog danaLoadingDialog = bottomSheetAddAsset.getDanaLoadingDialog();
            if (!z) {
                int i2 = 51 / 0;
            }
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 15;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                if ((i3 % 2 != 0 ? '8' : 'O') != 'O') {
                    int i4 = 1 / 0;
                    return danaLoadingDialog;
                }
                return danaLoadingDialog;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ String access$getFormattedUrl(BottomSheetAddAsset bottomSheetAddAsset, String str, ThirdPartyService thirdPartyService) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if (!(i % 2 != 0)) {
            String formattedUrl = bottomSheetAddAsset.getFormattedUrl(str, thirdPartyService);
            Object[] objArr = null;
            int length = objArr.length;
            return formattedUrl;
        }
        return bottomSheetAddAsset.getFormattedUrl(str, thirdPartyService);
    }

    public static final /* synthetic */ Function0 access$getOnDismissBottomSheet$p(BottomSheetAddAsset bottomSheetAddAsset) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 57;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Function0<Unit> function0 = bottomSheetAddAsset.onDismissBottomSheet;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return function0;
        }
        Object obj = null;
        obj.hashCode();
        return function0;
    }

    public static final /* synthetic */ int access$getSection$p(BottomSheetAddAsset bottomSheetAddAsset) {
        int i;
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 101;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
        if (!(i2 % 2 == 0)) {
            try {
                i = bottomSheetAddAsset.section;
            } catch (Exception e) {
                throw e;
            }
        } else {
            i = bottomSheetAddAsset.section;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        return i;
    }

    public static final /* synthetic */ void access$setLastAddedAssetType(BottomSheetAddAsset bottomSheetAddAsset, int i) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        int i3 = i2 % 2;
        bottomSheetAddAsset.setLastAddedAssetType(i);
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i4 % 128;
        int i5 = i4 % 2;
    }

    public static final /* synthetic */ void access$showFinancialSection(BottomSheetAddAsset bottomSheetAddAsset, List list) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        bottomSheetAddAsset.showFinancialSection(list);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void access$showIdentitySection(BottomSheetAddAsset bottomSheetAddAsset, List list) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 53;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                char c = i % 2 == 0 ? 'B' : (char) 18;
                bottomSheetAddAsset.showIdentitySection(list);
                if (c != 18) {
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

    public static final /* synthetic */ void access$showLoyaltySection(BottomSheetAddAsset bottomSheetAddAsset, List list) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 79;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
            bottomSheetAddAsset.showLoyaltySection(list);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 19;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$showPaymentSection(BottomSheetAddAsset bottomSheetAddAsset, List list) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 45;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if (!(i % 2 == 0)) {
                bottomSheetAddAsset.showPaymentSection(list);
                return;
            }
            bottomSheetAddAsset.showPaymentSection(list);
            int i2 = 24 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$showVoucherSection(BottomSheetAddAsset bottomSheetAddAsset, List list) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 25;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? 'O' : (char) 19) != 'O') {
            bottomSheetAddAsset.showVoucherSection(list);
            return;
        }
        bottomSheetAddAsset.showVoucherSection(list);
        Object obj = null;
        obj.hashCode();
    }

    public static final /* synthetic */ void access$trackServiceOpen(BottomSheetAddAsset bottomSheetAddAsset, ThirdPartyService thirdPartyService) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        bottomSheetAddAsset.trackServiceOpen(thirdPartyService);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final /* bridge */ /* synthetic */ ViewBinding getBinding() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            BottomSheetAddAssetContainerBinding binding = getBinding();
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 1;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                if (i3 % 2 == 0) {
                    return binding;
                }
                int i4 = 25 / 0;
                return binding;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* bridge */ /* synthetic */ View getPlaceComponentResult() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 55;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            FrameLayout placeComponentResult = getPlaceComponentResult();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 89;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return placeComponentResult;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return placeComponentResult;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ BottomSheetAddAsset(kotlin.jvm.functions.Function0 r13, int r14, java.util.List r15, int r16, java.lang.String r17, java.lang.String r18, boolean r19, java.util.List r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r4 = r2
            goto La
        L9:
            r4 = r13
        La:
            r1 = r0 & 4
            if (r1 == 0) goto L14
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r6 = r1
            goto L15
        L14:
            r6 = r15
        L15:
            r1 = r0 & 8
            if (r1 == 0) goto L26
            int r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r1 = r1 + 125
            int r3 = r1 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3
            int r1 = r1 % 2
            r1 = 1
            r7 = 1
            goto L28
        L26:
            r7 = r16
        L28:
            r1 = r0 & 16
            if (r1 == 0) goto L38
            int r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r1 = r1 + 7
            int r3 = r1 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r3
            int r1 = r1 % 2
            r8 = r2
            goto L3a
        L38:
            r8 = r17
        L3a:
            r1 = r0 & 32
            if (r1 == 0) goto L40
            r9 = r2
            goto L42
        L40:
            r9 = r18
        L42:
            r1 = r0 & 64
            r3 = 0
            if (r1 == 0) goto L5c
            int r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r1 = r1 + 119
            int r5 = r1 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r5
            int r1 = r1 % 2
            r5 = 55
            if (r1 == 0) goto L58
            r1 = 55
            goto L5a
        L58:
            r1 = 12
        L5a:
            r10 = 0
            goto L5e
        L5c:
            r10 = r19
        L5e:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L64
            r3 = 41
        L64:
            if (r3 == 0) goto L68
            r11 = r2
            goto L6a
        L68:
            r11 = r20
        L6a:
            r3 = r12
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.<init>(kotlin.jvm.functions.Function0, int, java.util.List, int, java.lang.String, java.lang.String, boolean, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getAccessToken")
    public final String getAccessToken() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 25;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? (char) 5 : (char) 0) != 5) {
            return this.accessToken;
        }
        int i2 = 82 / 0;
        return this.accessToken;
    }

    @JvmName(name = "setAccessToken")
    public final void setAccessToken(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        this.accessToken = str;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmName(name = "getKycLevel")
    public final String getKycLevel() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            String str = this.kycLevel;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 107;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 30 : 'L') != 30) {
                return str;
            }
            Object obj = null;
            obj.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setKycLevel")
    public final void setKycLevel(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        try {
            this.kycLevel = str;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 35;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getIdentityAssetSaved")
    public final boolean getIdentityAssetSaved() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 69;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        boolean z = this.identityAssetSaved;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    @JvmName(name = "setIdentityAssetSaved")
    public final void setIdentityAssetSaved(boolean z) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 9;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                char c = i % 2 != 0 ? (char) 24 : (char) 6;
                this.identityAssetSaved = z;
                if (c != 6) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getData")
    public final List<ThirdPartyService> getData() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 11;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                int i2 = i % 2;
                List<ThirdPartyService> list = this.data;
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 87;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
                return list;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setData")
    public final void setData(List<ThirdPartyService> list) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        this.data = list;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 7;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0016, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0020, code lost:
    
        r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 81;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        if ((r1 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r1 = '9';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r1 = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        if (r1 == 24) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        r1 = 94 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 103;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        if ((r1 % 2) != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        r1 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
    
        r1 = 'T';
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004e, code lost:
    
        if (r1 == 'T') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 51;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0066, code lost:
    
        if ((r0 % 2) == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0068, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0069, code lost:
    
        if (r1 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006c, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006d, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getBottomSheetAddAssetPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter getBottomSheetAddAssetPresenter() {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L74
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1     // Catch: java.lang.Exception -> L74
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L19
            id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter r0 = r5.bottomSheetAddAssetPresenter
            if (r0 == 0) goto L57
            goto L20
        L19:
            id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter r0 = r5.bottomSheetAddAssetPresenter     // Catch: java.lang.Exception -> L72
            r3.hashCode()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L57
        L20:
            int r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r1 = r1 + 81
            int r4 = r1 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4
            int r1 = r1 % 2
            r4 = 24
            if (r1 != 0) goto L31
            r1 = 57
            goto L33
        L31:
            r1 = 24
        L33:
            if (r1 == r4) goto L3b
            r1 = 94
            int r1 = r1 / r2
            goto L3b
        L39:
            r0 = move-exception
            throw r0
        L3b:
            int r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r1 = r1 + 103
            int r2 = r1 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r2
            int r1 = r1 % 2
            r2 = 84
            if (r1 != 0) goto L4c
            r1 = 11
            goto L4e
        L4c:
            r1 = 84
        L4e:
            if (r1 == r2) goto L56
            r3.hashCode()     // Catch: java.lang.Throwable -> L54
            return r0
        L54:
            r0 = move-exception
            throw r0
        L56:
            return r0
        L57:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 51
            int r4 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r4
            int r0 = r0 % 2
            if (r0 == 0) goto L69
            r1 = 0
        L69:
            if (r1 == 0) goto L6c
            return r3
        L6c:
            int r0 = r3.length     // Catch: java.lang.Throwable -> L6e
            return r3
        L6e:
            r0 = move-exception
            throw r0
        L70:
            r0 = move-exception
            throw r0
        L72:
            r0 = move-exception
            throw r0
        L74:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.getBottomSheetAddAssetPresenter():id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter");
    }

    @JvmName(name = "setBottomSheetAddAssetPresenter")
    public final void setBottomSheetAddAssetPresenter(BottomSheetAddAssetPresenter bottomSheetAddAssetPresenter) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 21;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if ((i % 2 == 0 ? 'R' : (char) 0) != 'R') {
                Intrinsics.checkNotNullParameter(bottomSheetAddAssetPresenter, "");
                this.bottomSheetAddAssetPresenter = bottomSheetAddAssetPresenter;
            } else {
                Intrinsics.checkNotNullParameter(bottomSheetAddAssetPresenter, "");
                this.bottomSheetAddAssetPresenter = bottomSheetAddAssetPresenter;
                Object obj = null;
                obj.hashCode();
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 59;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getReadLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        try {
            ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
            Object[] objArr = null;
            if ((presenter != null ? (char) 11 : '0') == '0') {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 57;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 31;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
            if ((i5 % 2 != 0 ? '\b' : '@') != '@') {
                int length = objArr.length;
                return presenter;
            }
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 105;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.readLinkPropertiesPresenter = presenter;
            return;
        }
        Intrinsics.checkNotNullParameter(presenter, "");
        this.readLinkPropertiesPresenter = presenter;
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r0 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0027, code lost:
    
        if ((r0 != null ? '3' : '-') != '-') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
    
        r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 69;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if ((r2 % 2) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
    
        r2 = 77 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003d, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003e, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0044, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getDeviceInformationProvider")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.config.DeviceInformationProvider getDeviceInformationProvider() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L45
            int r0 = r0 + 65
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1     // Catch: java.lang.Exception -> L45
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            if (r0 == 0) goto L1c
            id.dana.data.config.DeviceInformationProvider r0 = r4.deviceInformationProvider
            r2 = 66
            int r2 = r2 / r1
            if (r0 == 0) goto L3e
            goto L29
        L1a:
            r0 = move-exception
            throw r0
        L1c:
            id.dana.data.config.DeviceInformationProvider r0 = r4.deviceInformationProvider
            r2 = 45
            if (r0 == 0) goto L25
            r3 = 51
            goto L27
        L25:
            r3 = 45
        L27:
            if (r3 == r2) goto L3e
        L29:
            int r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L3c
            int r2 = r2 + 69
            int r3 = r2 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3     // Catch: java.lang.Exception -> L3c
            int r2 = r2 % 2
            if (r2 != 0) goto L3b
            r2 = 77
            int r2 = r2 / r1
            goto L3b
        L39:
            r0 = move-exception
            throw r0
        L3b:
            return r0
        L3c:
            r0 = move-exception
            throw r0
        L3e:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
            return r0
        L45:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.getDeviceInformationProvider():id.dana.data.config.DeviceInformationProvider");
    }

    @JvmName(name = "setDeviceInformationProvider")
    public final void setDeviceInformationProvider(DeviceInformationProvider deviceInformationProvider) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.deviceInformationProvider = deviceInformationProvider;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
    
        if ((r0 == null) != true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
    
        if ((r0 != null ? '2' : 4) != '2') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
    
        r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 123;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getWalletH5ServicesImplementation")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.wallet_v3.WalletH5ServicesImplementation getWalletH5ServicesImplementation() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 71
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1b
            id.dana.wallet_v3.WalletH5ServicesImplementation r0 = r4.walletH5ServicesImplementation
            int r2 = r1.length     // Catch: java.lang.Throwable -> L19
            r2 = 1
            if (r0 == 0) goto L15
            r3 = 0
            goto L16
        L15:
            r3 = 1
        L16:
            if (r3 == r2) goto L27
            goto L2d
        L19:
            r0 = move-exception
            throw r0
        L1b:
            id.dana.wallet_v3.WalletH5ServicesImplementation r0 = r4.walletH5ServicesImplementation
            r2 = 50
            if (r0 == 0) goto L24
            r3 = 50
            goto L25
        L24:
            r3 = 4
        L25:
            if (r3 == r2) goto L2d
        L27:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r1
        L2d:
            int r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r1 = r1 + 123
            int r2 = r1 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % 2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.getWalletH5ServicesImplementation():id.dana.wallet_v3.WalletH5ServicesImplementation");
    }

    @JvmName(name = "setWalletH5ServicesImplementation")
    public final void setWalletH5ServicesImplementation(WalletH5ServicesImplementation walletH5ServicesImplementation) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? '3' : (char) 2) != 2) {
            Intrinsics.checkNotNullParameter(walletH5ServicesImplementation, "");
            this.walletH5ServicesImplementation = walletH5ServicesImplementation;
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        Intrinsics.checkNotNullParameter(walletH5ServicesImplementation, "");
        this.walletH5ServicesImplementation = walletH5ServicesImplementation;
    }

    @JvmName(name = "getFeaturePresenter")
    public final FeatureContract.Presenter getFeaturePresenter() {
        try {
            FeatureContract.Presenter presenter = this.featurePresenter;
            Object obj = null;
            if (presenter != null) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 71;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                if (!(i % 2 == 0)) {
                    return presenter;
                }
                obj.hashCode();
                return presenter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 53;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
            if ((i2 % 2 != 0 ? '[' : '@') != '[') {
                return null;
            }
            obj.hashCode();
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(FeatureContract.Presenter presenter) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 119;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            if (!(i % 2 == 0)) {
                Intrinsics.checkNotNullParameter(presenter, "");
                this.featurePresenter = presenter;
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                Intrinsics.checkNotNullParameter(presenter, "");
                this.featurePresenter = presenter;
            }
            try {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 89;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getPaymentServiceAdapter")
    private final AddAssetAdapter getPaymentServiceAdapter() {
        AddAssetAdapter addAssetAdapter;
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 51;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            if (!(i % 2 == 0)) {
                addAssetAdapter = (AddAssetAdapter) this.paymentServiceAdapter.getValue();
                Object obj = null;
                obj.hashCode();
            } else {
                addAssetAdapter = (AddAssetAdapter) this.paymentServiceAdapter.getValue();
            }
            try {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 97;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                int i3 = i2 % 2;
                return addAssetAdapter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getLoyaltyServiceAdapter")
    private final AddAssetAdapter getLoyaltyServiceAdapter() {
        AddAssetAdapter addAssetAdapter;
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 91;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if (!(i % 2 != 0)) {
                addAssetAdapter = (AddAssetAdapter) this.loyaltyServiceAdapter.getValue();
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                addAssetAdapter = (AddAssetAdapter) this.loyaltyServiceAdapter.getValue();
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 77;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
            return addAssetAdapter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getFinancialServiceAdapter")
    private final AddAssetAdapter getFinancialServiceAdapter() {
        AddAssetAdapter addAssetAdapter;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 39;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? Typography.less : ':') != ':') {
            addAssetAdapter = (AddAssetAdapter) this.financialServiceAdapter.getValue();
            int length = objArr.length;
        } else {
            addAssetAdapter = (AddAssetAdapter) this.financialServiceAdapter.getValue();
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 27;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
                if ((i2 % 2 != 0 ? Typography.greater : '5') != '5') {
                    int length2 = objArr.length;
                    return addAssetAdapter;
                }
                return addAssetAdapter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getVoucherServiceAdapter")
    private final AddAssetAdapter getVoucherServiceAdapter() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 1;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? ']' : 'W') != ']') {
            return (AddAssetAdapter) this.voucherServiceAdapter.getValue();
        }
        int i2 = 16 / 0;
        return (AddAssetAdapter) this.voucherServiceAdapter.getValue();
    }

    @JvmName(name = "getDanaLoadingDialog")
    private final DanaLoadingDialog getDanaLoadingDialog() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.danaLoadingDialog.getValue();
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 11;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
                return danaLoadingDialog;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getIdentityServiceAdapter")
    private final AddAssetAdapter getIdentityServiceAdapter() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? '@' : 'O') != 'O') {
            AddAssetAdapter addAssetAdapter = (AddAssetAdapter) this.identityServiceAdapter.getValue();
            Object obj = null;
            obj.hashCode();
            return addAssetAdapter;
        }
        return (AddAssetAdapter) this.identityServiceAdapter.getValue();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    @JvmName(name = "getBindingInflater")
    public final Function1<LayoutInflater, BottomSheetAddAssetContainerBinding> getBindingInflater() {
        Function1<LayoutInflater, BottomSheetAddAssetContainerBinding> function1 = new Function1<LayoutInflater, BottomSheetAddAssetContainerBinding>() { // from class: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$bindingInflater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BottomSheetAddAssetContainerBinding invoke(LayoutInflater layoutInflater) {
                Intrinsics.checkNotNullParameter(layoutInflater, "");
                BottomSheetAddAssetContainerBinding MyBillsEntityDataFactory = BottomSheetAddAssetContainerBinding.MyBillsEntityDataFactory(BottomSheetAddAsset.this.getLayoutInflater());
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                return MyBillsEntityDataFactory;
            }
        };
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? (char) 15 : '3') != '3') {
            int i2 = 65 / 0;
            return function1;
        }
        return function1;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    @JvmName(name = "getBinding")
    public final BottomSheetAddAssetContainerBinding getBinding() {
        BottomSheetAddAssetContainerBinding bottomSheetAddAssetContainerBinding;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        try {
            ViewBinding viewBinding = getViewBinding();
            Object obj = null;
            if (viewBinding instanceof BottomSheetAddAssetContainerBinding) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 3;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                if ((i3 % 2 != 0 ? Typography.greater : 'V') != 'V') {
                    bottomSheetAddAssetContainerBinding = (BottomSheetAddAssetContainerBinding) viewBinding;
                    obj.hashCode();
                } else {
                    try {
                        bottomSheetAddAssetContainerBinding = (BottomSheetAddAssetContainerBinding) viewBinding;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                return bottomSheetAddAssetContainerBinding;
            }
            return null;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    protected final FrameLayout getPlaceComponentResult() {
        BottomSheetAddAssetContainerBinding binding;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            try {
                binding = getBinding();
                obj.hashCode();
                if (binding == null) {
                    return null;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            binding = getBinding();
            if (!(binding != null)) {
                return null;
            }
        }
        BottomSheetAddAssetBinding bottomSheetAddAssetBinding = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(bottomSheetAddAssetBinding == null)) {
            FrameLayout frameLayout = bottomSheetAddAssetBinding.PlaceComponentResult;
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
            int i3 = i2 % 2;
            return frameLayout;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        if ((r0 != null) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        if (r0.length() == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        if (r0 == true) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 89;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r0 % 128;
        r0 = r0 % 2;
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r0 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 121;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r0 % 128;
        r0 = r0 % 2;
        r0 = r4.kycLevel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        if (r0 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
    
        if (r0.length() != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        if (r2 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
    
        getBottomSheetAddAssetPresenter().fetchLoyaltyAccessTokenAndKycLevel();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
    
        getWalletH5ServicesImplementation().setWalletH5Listener(walletH5Listener());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008c, code lost:
    
        return;
     */
    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void init() {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 83
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 86
            if (r0 == 0) goto L11
            r0 = 86
            goto L13
        L11:
            r0 = 75
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L2f
            super.init()
            r4.initInjector()
            r4.getServices()
            r4.initList()
            java.lang.String r0 = r4.accessToken
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L2b
            r1 = 1
            goto L2c
        L2b:
            r1 = 0
        L2c:
            if (r1 == 0) goto L5b
            goto L44
        L2f:
            super.init()
            r4.initInjector()
            r4.getServices()
            r4.initList()
            java.lang.String r0 = r4.accessToken     // Catch: java.lang.Exception -> L91
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L8f
            r1 = 56
            int r1 = r1 / r3
            if (r0 == 0) goto L5b
        L44:
            int r0 = r0.length()
            if (r0 == 0) goto L4c
            r0 = 0
            goto L4d
        L4c:
            r0 = 1
        L4d:
            if (r0 == r2) goto L5b
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            r0 = 0
            goto L5c
        L5b:
            r0 = 1
        L5c:
            if (r0 != 0) goto L78
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 121
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            java.lang.String r0 = r4.kycLevel
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L76
            int r0 = r0.length()
            if (r0 != 0) goto L75
            goto L76
        L75:
            r2 = 0
        L76:
            if (r2 == 0) goto L7f
        L78:
            id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter r0 = r4.getBottomSheetAddAssetPresenter()     // Catch: java.lang.Exception -> L8f
            r0.fetchLoyaltyAccessTokenAndKycLevel()     // Catch: java.lang.Exception -> L8f
        L7f:
            id.dana.wallet_v3.WalletH5ServicesImplementation r0 = r4.getWalletH5ServicesImplementation()
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$walletH5Listener$1 r1 = r4.walletH5Listener()
            id.dana.utils.danah5.DanaH5Listener r1 = (id.dana.utils.danah5.DanaH5Listener) r1
            r0.setWalletH5Listener(r1)
            return
        L8d:
            r0 = move-exception
            throw r0
        L8f:
            r0 = move-exception
            throw r0
        L91:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.init():void");
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            d(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr2 = new Object[1];
            d(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (Process.myPid() >> 22), TextUtils.indexOf((CharSequence) "", '0') + 5, (char) TextUtils.indexOf("", ""));
                    byte b5 = (byte) ($$d[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    e(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i3 = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i3) {
                    long j = ((r3 ^ i3) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.keyCodeFromString("") + 35, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-114319865, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
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
                super.onCreate(savedInstanceState);
                setStyle(0, R.style.f50122132017477);
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 33;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i4 % 128;
                if ((i4 % 2 != 0 ? '7' : '\\') != '7') {
                    return;
                }
                int i5 = 62 / 0;
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        BottomSheetAddAssetContainerBinding binding;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? (char) 14 : 'E') != 14) {
            super.onStart();
            initMatchParentDialog(getDialog());
            initTransparentDialogDim(getDialog());
            binding = getBinding();
            if (binding == null) {
                return;
            }
        } else {
            super.onStart();
            try {
                initMatchParentDialog(getDialog());
                initTransparentDialogDim(getDialog());
                binding = getBinding();
                int i2 = 86 / 0;
                if ((binding != null ? (char) 6 : (char) 28) != 6) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        CoordinatorLayout coordinatorLayout = binding.getAuthRequestContext;
        if (coordinatorLayout != null) {
            try {
                coordinatorLayout.post(new Runnable() { // from class: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BottomSheetAddAsset.$r8$lambda$T2mvzcO6TQB_z4mD2kMLqD9owTM(BottomSheetAddAsset.this);
                    }
                });
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 63;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* renamed from: onStart$lambda-0  reason: not valid java name */
    private static final void m3100onStart$lambda0(BottomSheetAddAsset bottomSheetAddAsset) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(bottomSheetAddAsset, "");
        bottomSheetAddAsset.bottomSheetBehavior.setPeekHeight(ViewExtKt.PlaceComponentResult(666.0f));
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 != 0 ? ']' : Typography.less) != ']') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? 'H' : '-') != '-') {
            super.onShow();
            setupBottomSheet();
            int i2 = 67 / 0;
        } else {
            super.onShow();
            setupBottomSheet();
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 14 : (char) 4) != 14) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if ((r0 == null) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if ((r0 != null ? 23 : 'H') != 'H') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        r0 = ((com.google.android.material.bottomsheet.BottomSheetDialog) r0).getBehavior();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r0.setState(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 67;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        if ((r0 % 2) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        r0 = r0.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setupBottomSheet() {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L6f
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1     // Catch: java.lang.Exception -> L6f
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 3
            if (r0 == r2) goto L2b
            android.app.Dialog r0 = r5.getDialog()
            int r0 = r5.getScreenHeight(r0)
            r4 = 5
            r5.initBottomSheet(r0, r4)
            android.app.Dialog r0 = r5.getDialog()
            if (r0 == 0) goto L27
            goto L28
        L27:
            r1 = 1
        L28:
            if (r1 != 0) goto L67
            goto L45
        L2b:
            android.app.Dialog r0 = r5.getDialog()
            int r0 = r5.getScreenHeight(r0)
            r5.initBottomSheet(r0, r3)
            android.app.Dialog r0 = r5.getDialog()
            r1 = 72
            if (r0 == 0) goto L41
            r2 = 23
            goto L43
        L41:
            r2 = 72
        L43:
            if (r2 == r1) goto L67
        L45:
            com.google.android.material.bottomsheet.BottomSheetDialog r0 = (com.google.android.material.bottomsheet.BottomSheetDialog) r0
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r0.getBehavior()
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0.setState(r3)
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L65
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1     // Catch: java.lang.Exception -> L65
            int r0 = r0 % 2
            if (r0 == 0) goto L64
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L62
            return
        L62:
            r0 = move-exception
            throw r0
        L64:
            return
        L65:
            r0 = move-exception
            throw r0
        L67:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
            r0.<init>(r1)
            throw r0
        L6f:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.setupBottomSheet():void");
    }

    private final void initInjector() {
        DaggerBottomSheetAddAssetComponent.Builder bottomSheetAddAssetModule = DaggerBottomSheetAddAssetComponent.builder().applicationComponent(ComponentHolder.getAuthRequestContext()).bottomSheetAddAssetModule(getBottomSheetAddAssetModule());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = getActivity();
        Object[] objArr = new Object[1];
        c((ViewConfiguration.getWindowTouchSlop() >> 8) + 8, new char[]{45899, 44873, 34779, 10270, 37071, 7351, 12751, 44239}, objArr);
        byte b = 0;
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = ((String) objArr[0]).intern();
        DaggerBottomSheetAddAssetComponent.Builder deepLinkModule = bottomSheetAddAssetModule.deepLinkModule(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        DaggerBottomSheetAddAssetComponent.Builder scanQrModule = deepLinkModule.scanQrModule(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = getActivity();
        DaggerBottomSheetAddAssetComponent.Builder restoreUrlModule = scanQrModule.restoreUrlModule(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        MyBillsEntityDataFactory.PlaceComponentResult = TrackerKey.SourceType.WALLET_ADD_ASSET;
        DaggerBottomSheetAddAssetComponent.Builder featureModule = restoreUrlModule.featureModule(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        featureModule.oauthModule(new OauthModule(BuiltInFictitiousFunctionClassFactory, b)).build().inject(this);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
    }

    private final BottomSheetAddAssetModule getBottomSheetAddAssetModule() {
        BottomSheetAddAssetModule bottomSheetAddAssetModule = new BottomSheetAddAssetModule(new BottomSheetAddAssetContract.View() { // from class: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$getBottomSheetAddAssetModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.View
            public final void onErrorGetServicesList() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.View
            public final void onGetAllThirdPartyServices(List<ThirdPartyService> paymentServices, List<ThirdPartyService> financialServices, List<ThirdPartyService> voucherServices, List<ThirdPartyService> loyaltyServices, List<ThirdPartyService> identityServices) {
                Intrinsics.checkNotNullParameter(paymentServices, "");
                Intrinsics.checkNotNullParameter(financialServices, "");
                Intrinsics.checkNotNullParameter(voucherServices, "");
                Intrinsics.checkNotNullParameter(loyaltyServices, "");
                Intrinsics.checkNotNullParameter(identityServices, "");
                BottomSheetAddAsset.access$showPaymentSection(BottomSheetAddAsset.this, paymentServices);
                BottomSheetAddAsset.access$showFinancialSection(BottomSheetAddAsset.this, financialServices);
                BottomSheetAddAsset.access$showVoucherSection(BottomSheetAddAsset.this, voucherServices);
                BottomSheetAddAsset.access$showLoyaltySection(BottomSheetAddAsset.this, loyaltyServices);
                BottomSheetAddAsset.access$showIdentitySection(BottomSheetAddAsset.this, identityServices);
            }

            @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.View
            public final void onGetThirdPartyServices(int section, List<ThirdPartyService> thirdPartyServices) {
                Intrinsics.checkNotNullParameter(thirdPartyServices, "");
                if (section == 1) {
                    BottomSheetAddAsset.access$showPaymentSection(BottomSheetAddAsset.this, thirdPartyServices);
                } else if (section == 2) {
                    BottomSheetAddAsset.access$showFinancialSection(BottomSheetAddAsset.this, thirdPartyServices);
                } else if (section == 3) {
                    BottomSheetAddAsset.access$showVoucherSection(BottomSheetAddAsset.this, thirdPartyServices);
                } else if (section == 4) {
                    BottomSheetAddAsset.access$showLoyaltySection(BottomSheetAddAsset.this, thirdPartyServices);
                } else if (section == 5) {
                    BottomSheetAddAsset.access$showIdentitySection(BottomSheetAddAsset.this, thirdPartyServices);
                }
            }

            @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.View
            public final void onActionPost(ThirdPartyService thirdPartyService, String authCode) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                WalletH5ServicesImplementation walletH5ServicesImplementation = BottomSheetAddAsset.this.getWalletH5ServicesImplementation();
                String authRequestContext = UrlUtil.getAuthRequestContext(thirdPartyService.getCallingPid);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                walletH5ServicesImplementation.openH5(thirdPartyService, authRequestContext, authCode, BottomSheetAddAsset.this.getDeviceInformationProvider().getDeviceUUID());
            }

            @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.View
            public final void onActionFailed(String message) {
                BottomSheetAddAsset.access$getDanaLoadingDialog(BottomSheetAddAsset.this).PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.View
            public final void onGetLoyaltyAccessToken(String token) {
                Intrinsics.checkNotNullParameter(token, "");
                BottomSheetAddAsset.this.setAccessToken(token);
            }

            @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.View
            public final void onGetKycLevel(String kycLevel) {
                BottomSheetAddAsset.this.setKycLevel(kycLevel);
            }

            @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.View
            public final void onDirectOpen(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                BottomSheetAddAsset.access$getDanaLoadingDialog(BottomSheetAddAsset.this).PlaceComponentResult();
                String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str != null) {
                    BottomSheetAddAsset.this.getFeaturePresenter().getAuthRequestContext(str, null);
                }
            }

            @Override // id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract.View
            public final void onActionGet(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
                String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6;
                if (str != null) {
                    BottomSheetAddAsset bottomSheetAddAsset = BottomSheetAddAsset.this;
                    BottomSheetAddAsset.access$getDanaLoadingDialog(bottomSheetAddAsset).PlaceComponentResult();
                    if (UrlUtil.getErrorConfigVersion(str)) {
                        bottomSheetAddAsset.getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(str);
                        return;
                    }
                    String access$getFormattedUrl = BottomSheetAddAsset.access$getFormattedUrl(bottomSheetAddAsset, str, thirdPartyService);
                    WalletH5ServicesImplementation walletH5ServicesImplementation = bottomSheetAddAsset.getWalletH5ServicesImplementation();
                    String authRequestContext = UrlUtil.getAuthRequestContext(access$getFormattedUrl);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    walletH5ServicesImplementation.openH5(thirdPartyService, authRequestContext, null, null);
                }
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? 'L' : '+') != 'L') {
            return bottomSheetAddAssetModule;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return bottomSheetAddAssetModule;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x001d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getServices() {
        /*
            r3 = this;
            java.util.List<id.dana.model.ThirdPartyService> r0 = r3.data     // Catch: java.lang.Exception -> L47
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Exception -> L47
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L16
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r2) goto L14
            goto L16
        L14:
            r0 = 0
            goto L17
        L16:
            r0 = 1
        L17:
            if (r0 == 0) goto L1a
            goto L1b
        L1a:
            r1 = 1
        L1b:
            if (r1 == r2) goto L33
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L31
            int r0 = r0 + 117
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1     // Catch: java.lang.Exception -> L47
            int r0 = r0 % 2
            id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter r0 = r3.getBottomSheetAddAssetPresenter()
            int r1 = r3.section
            r0.getBottomSheetServices(r1)
            return
        L31:
            r0 = move-exception
            throw r0
        L33:
            int r0 = r3.section
            if (r0 != r2) goto L46
            java.util.List<id.dana.model.ThirdPartyService> r0 = r3.data
            r3.showPaymentSection(r0)
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L47
            int r0 = r0 + 45
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1     // Catch: java.lang.Exception -> L47
            int r0 = r0 % 2
        L46:
            return
        L47:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.getServices():void");
    }

    private final DanaH5Listener createH5AppListener() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
                BottomSheetAddAsset.access$getDanaLoadingDialog(BottomSheetAddAsset.this).PlaceComponentResult();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                DanaH5.dispose();
                Function0 access$getOnDismissBottomSheet$p = BottomSheetAddAsset.access$getOnDismissBottomSheet$p(BottomSheetAddAsset.this);
                if (access$getOnDismissBottomSheet$p != null) {
                    access$getOnDismissBottomSheet$p.invoke();
                }
            }
        };
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 119;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        return danaH5Listener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0113, code lost:
    
        r1 = r4.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0115, code lost:
    
        if (r1 == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0117, code lost:
    
        r3 = r1.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0119, code lost:
    
        initRecyclerView(r0, r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x011c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x011d, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0121, code lost:
    
        if (r0 == null) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0123, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0125, code lost:
    
        if (r0 == null) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0127, code lost:
    
        r0 = r0.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x012a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x012b, code lost:
    
        if (r0 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x012d, code lost:
    
        r0.setText(getString(id.dana.R.string.add_single_asset_payment_title));
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0136, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x013a, code lost:
    
        if (r0 == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x013c, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x013e, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x013f, code lost:
    
        if (r2 == true) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0141, code lost:
    
        r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 39;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r2 % 128;
        r2 = r2 % 2;
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x014c, code lost:
    
        if (r0 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x014e, code lost:
    
        r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 23;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r2 % 128;
        r2 = r2 % 2;
        r0 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x015a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x015b, code lost:
    
        r2 = getLoyaltyServiceAdapter();
        r4 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0163, code lost:
    
        if (r4 == null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0165, code lost:
    
        r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0167, code lost:
    
        if (r4 == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x016a, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x016b, code lost:
    
        if (r5 == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x016d, code lost:
    
        r5 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 75;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0176, code lost:
    
        if ((r5 % 2) != 0) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0178, code lost:
    
        r1 = r4.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x017a, code lost:
    
        r3 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x017b, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x017f, code lost:
    
        r3 = r4.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0181, code lost:
    
        initRecyclerView(r0, r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0184, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0185, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0189, code lost:
    
        if (r0 == null) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x018b, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x018d, code lost:
    
        if (r0 == null) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x018f, code lost:
    
        r0 = r0.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0192, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0193, code lost:
    
        if (r0 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0195, code lost:
    
        r0.setText(getString(id.dana.R.string.add_single_asset_voucher_title));
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01a1, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01a5, code lost:
    
        if (r0 == null) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
    
        if (r0 != 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01a7, code lost:
    
        r1 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01aa, code lost:
    
        r1 = 'P';
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x01ac, code lost:
    
        if (r1 == 'G') goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01af, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01b1, code lost:
    
        if (r0 == null) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x01b3, code lost:
    
        r0 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01b6, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x01b7, code lost:
    
        r1 = getVoucherServiceAdapter();
        r2 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01bf, code lost:
    
        if (r2 == null) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x01c1, code lost:
    
        r2 = r2.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x01c3, code lost:
    
        if (r2 == null) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01c5, code lost:
    
        r3 = r2.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x01c7, code lost:
    
        initRecyclerView(r0, r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01ca, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x01cb, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x01cf, code lost:
    
        if (r0 == null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x01d1, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x01d3, code lost:
    
        if (r0 == null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x01d5, code lost:
    
        r0 = r0.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if (r0 == 1) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x01d8, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x01db, code lost:
    
        if (r0 == null) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x01dd, code lost:
    
        r5 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x01e0, code lost:
    
        r5 = 'S';
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x01e2, code lost:
    
        if (r5 == '@') goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x01e5, code lost:
    
        r0.setText(getString(id.dana.R.string.add_single_asset_payment_title));
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x01ee, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x01f2, code lost:
    
        if (r0 == null) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x01f4, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x01f6, code lost:
    
        if (r0 == null) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x01f8, code lost:
    
        r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 69;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0201, code lost:
    
        if ((r2 % 2) == 0) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0203, code lost:
    
        r0 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0205, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x020b, code lost:
    
        r0 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        if (r0 == 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x020e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x020f, code lost:
    
        r1 = getPaymentServiceAdapter();
        r2 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0217, code lost:
    
        if (r2 == null) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0219, code lost:
    
        r2 = r2.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x021b, code lost:
    
        if (r2 == null) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x021d, code lost:
    
        r3 = r2.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x021f, code lost:
    
        initRecyclerView(r0, r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0222, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0223, code lost:
    
        setSectionTitle();
        initAllList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0229, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r7 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
    
        r7 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r7 == 5) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003a, code lost:
    
        r0 = r0.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        r0.setText(getString(id.dana.R.string.add_single_asset_financial_title));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0052, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0054, code lost:
    
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
    
        r0 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005a, code lost:
    
        r4 = getFinancialServiceAdapter();
        r5 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0062, code lost:
    
        if (r5 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0064, code lost:
    
        r6 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0067, code lost:
    
        r6 = 'D';
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0069, code lost:
    
        if (r6 == '\f') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006c, code lost:
    
        r2 = r5.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006e, code lost:
    
        if (r2 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0070, code lost:
    
        r3 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 113;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3 % 128;
        r3 = r3 % 2;
        r3 = r2.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007b, code lost:
    
        initRecyclerView(r0, r4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007f, code lost:
    
        r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 1;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r2 % 128;
        r2 = r2 % 2;
        r7 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008a, code lost:
    
        if (r0 == 3) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008e, code lost:
    
        if (r0 == 4) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0090, code lost:
    
        if (r0 != 5) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0094, code lost:
    
        if (r10.identityAssetSaved != false) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0096, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009a, code lost:
    
        if (r0 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009c, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009e, code lost:
    
        if (r0 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a0, code lost:
    
        r4 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 + 31;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ab, code lost:
    
        if ((r4 % 2) != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ad, code lost:
    
        r4 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b0, code lost:
    
        r4 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b2, code lost:
    
        if (r4 == 'X') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b4, code lost:
    
        r0 = r0.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b7, code lost:
    
        r0 = r0.scheduleImpl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b9, code lost:
    
        r4 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bd, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00be, code lost:
    
        if (r0 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c0, code lost:
    
        r0.setText(getString(id.dana.R.string.add_single_asset_identity_title));
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00cc, code lost:
    
        r0 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d0, code lost:
    
        if (r0 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d2, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d4, code lost:
    
        if (r0 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d6, code lost:
    
        r4 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 13;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00df, code lost:
    
        if ((r4 % 2) == 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e1, code lost:
    
        r0 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00e3, code lost:
    
        r2 = 3 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00e7, code lost:
    
        r0 = r0.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00ea, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00eb, code lost:
    
        r2 = getIdentityServiceAdapter();
        r4 = getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00f5, code lost:
    
        if (r4 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f7, code lost:
    
        r7 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00f9, code lost:
    
        if (r7 == ':') goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00fc, code lost:
    
        r6 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 11;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0105, code lost:
    
        if ((r6 % 2) == 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0108, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0109, code lost:
    
        if (r5 == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x010b, code lost:
    
        r1 = r4.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x010d, code lost:
    
        r4 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x010e, code lost:
    
        if (r1 == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if ((r0 != 0 ? 7 : '\f') != '\f') goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.fragment.app.Fragment, id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.appcompat.widget.AppCompatTextView] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initList() {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.initList():void");
    }

    private final void setLastAddedAssetType(int lastAddedAssetType) {
        NewWalletFragment newWalletFragment;
        Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag(HomeTabFragment.FragmentTag.WALLET_FRAGMENT);
        if (findFragmentByTag instanceof NewWalletFragment) {
            newWalletFragment = (NewWalletFragment) findFragmentByTag;
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 99;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
        } else {
            newWalletFragment = null;
        }
        if ((newWalletFragment != null ? 'b' : 'c') != 'b') {
            return;
        }
        newWalletFragment.setLastAddedAssetType(Integer.valueOf(lastAddedAssetType));
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 97;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void initAllList() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 27;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        try {
            initRecyclerView(getRecyclerView(this.paymentSectionIndex), getPaymentServiceAdapter(), getTextView(this.paymentSectionIndex));
            initRecyclerView(getRecyclerView(this.investmentSectionIndex), getFinancialServiceAdapter(), getTextView(this.investmentSectionIndex));
            initRecyclerView(getRecyclerView(this.voucherSectionIndex), getVoucherServiceAdapter(), getTextView(this.voucherSectionIndex));
            initRecyclerView(getRecyclerView(this.loyaltySectionIndex), getLoyaltyServiceAdapter(), getTextView(this.loyaltySectionIndex));
            initRecyclerView(getRecyclerView(this.identitySectionIndex), getIdentityServiceAdapter(), getTextView(this.identitySectionIndex));
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 101;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void initRecyclerView(RecyclerView rv, AddAssetAdapter adapter, AppCompatTextView title) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        if (rv != null) {
            try {
                rv.setVisibility(0);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new GridLayoutManager(rv.getContext(), 4));
            } catch (Exception e) {
                throw e;
            }
        }
        if (!(title != null)) {
            return;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 99;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            title.setVisibility(0);
        } else {
            title.setVisibility(1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0067, code lost:
    
        if (r7 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006e, code lost:
    
        if (r7 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0070, code lost:
    
        r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 13;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0079, code lost:
    
        r1 = r7.getErrorConfigVersion;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.recyclerview.widget.RecyclerView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.recyclerview.widget.RecyclerView getRecyclerView(int r7) {
        /*
            r6 = this;
            r0 = 2
            r1 = 0
            if (r7 == 0) goto L9b
            r2 = 3
            r3 = 1
            if (r7 == r3) goto L7c
            r4 = 0
            if (r7 == r0) goto L51
            if (r7 == r2) goto L29
            id.dana.databinding.BottomSheetAddAssetContainerBinding r7 = r6.getBinding()
            if (r7 == 0) goto Lb0
            int r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r2 = r2 + 113
            int r5 = r2 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r5
            int r2 = r2 % r0
            id.dana.databinding.BottomSheetAddAssetBinding r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            if (r7 == 0) goto L21
            r3 = 0
        L21:
            if (r3 == 0) goto L25
            goto Lb0
        L25:
            androidx.recyclerview.widget.RecyclerView r1 = r7.BuiltInFictitiousFunctionClassFactory
            goto Lb0
        L29:
            id.dana.databinding.BottomSheetAddAssetContainerBinding r7 = r6.getBinding()
            if (r7 == 0) goto Lb0
            int r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r2 = r2 + 123
            int r5 = r2 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r5
            int r2 = r2 % r0
            if (r2 != 0) goto L46
            id.dana.databinding.BottomSheetAddAssetBinding r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r1.length     // Catch: java.lang.Throwable -> L44
            if (r7 == 0) goto L40
            r3 = 0
        L40:
            if (r3 == 0) goto L4e
            goto Lb0
        L44:
            r7 = move-exception
            throw r7
        L46:
            id.dana.databinding.BottomSheetAddAssetBinding r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            if (r7 == 0) goto L4b
            r4 = 1
        L4b:
            if (r4 == r3) goto L4e
            goto Lb0
        L4e:
            androidx.recyclerview.widget.RecyclerView r1 = r7.getAuthRequestContext
            goto Lb0
        L51:
            id.dana.databinding.BottomSheetAddAssetContainerBinding r7 = r6.getBinding()
            if (r7 == 0) goto Lb0
            int r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L99
            int r2 = r2 + 117
            int r3 = r2 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r3     // Catch: java.lang.Exception -> L99
            int r2 = r2 % r0
            if (r2 == 0) goto L6c
            id.dana.databinding.BottomSheetAddAssetBinding r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            r2 = 81
            int r2 = r2 / r4
            if (r7 == 0) goto Lb0
            goto L70
        L6a:
            r7 = move-exception
            throw r7
        L6c:
            id.dana.databinding.BottomSheetAddAssetBinding r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            if (r7 == 0) goto Lb0
        L70:
            int r1 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r1 = r1 + 13
            int r2 = r1 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2
            int r1 = r1 % r0
            androidx.recyclerview.widget.RecyclerView r1 = r7.getErrorConfigVersion     // Catch: java.lang.Exception -> L99
            goto Lb0
        L7c:
            id.dana.databinding.BottomSheetAddAssetContainerBinding r7 = r6.getBinding()
            if (r7 == 0) goto Lb0
            int r3 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L99
            int r3 = r3 + 71
            int r4 = r3 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r4     // Catch: java.lang.Exception -> L99
            int r3 = r3 % r0
            id.dana.databinding.BottomSheetAddAssetBinding r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            r0 = 48
            if (r7 == 0) goto L92
            goto L94
        L92:
            r2 = 48
        L94:
            if (r2 == r0) goto Lb0
            androidx.recyclerview.widget.RecyclerView r1 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            goto Lb0
        L99:
            r7 = move-exception
            throw r7
        L9b:
            id.dana.databinding.BottomSheetAddAssetContainerBinding r7 = r6.getBinding()
            if (r7 == 0) goto Lb0
            int r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r2 = r2 + 61
            int r3 = r2 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r3
            int r2 = r2 % r0
            id.dana.databinding.BottomSheetAddAssetBinding r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            if (r7 == 0) goto Lb0
            androidx.recyclerview.widget.RecyclerView r1 = r7.MyBillsEntityDataFactory
        Lb0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.getRecyclerView(int):androidx.recyclerview.widget.RecyclerView");
    }

    private final AppCompatTextView getTextView(int index) {
        BottomSheetAddAssetContainerBinding binding;
        BottomSheetAddAssetBinding bottomSheetAddAssetBinding;
        AppCompatTextView appCompatTextView = null;
        try {
            if (index != 0) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 27;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                int i2 = i % 2;
                if (index != 1) {
                    if ((index != 2 ? 'b' : (char) 17) != 'b') {
                        BottomSheetAddAssetContainerBinding binding2 = getBinding();
                        if (binding2 != null) {
                            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 13;
                            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                            if (i3 % 2 != 0) {
                                bottomSheetAddAssetBinding = binding2.KClassImpl$Data$declaredNonStaticMembers$2;
                                appCompatTextView.hashCode();
                                if (bottomSheetAddAssetBinding == null) {
                                    return null;
                                }
                            } else {
                                bottomSheetAddAssetBinding = binding2.KClassImpl$Data$declaredNonStaticMembers$2;
                                if (bottomSheetAddAssetBinding == null) {
                                    return null;
                                }
                            }
                            return bottomSheetAddAssetBinding.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        }
                        return null;
                    } else if (index == 3) {
                        BottomSheetAddAssetContainerBinding binding3 = getBinding();
                        if (binding3 != null) {
                            BottomSheetAddAssetBinding bottomSheetAddAssetBinding2 = binding3.KClassImpl$Data$declaredNonStaticMembers$2;
                            if ((bottomSheetAddAssetBinding2 != null ? (char) 21 : '/') != '/') {
                                return bottomSheetAddAssetBinding2.moveToNextValue;
                            }
                            return null;
                        }
                        return null;
                    } else {
                        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 95;
                        NetworkUserEntityData$$ExternalSyntheticLambda2 = i4 % 128;
                        if (i4 % 2 == 0) {
                            binding = getBinding();
                            appCompatTextView.hashCode();
                            if (binding == null) {
                                return null;
                            }
                        } else {
                            binding = getBinding();
                            if (binding == null) {
                                return null;
                            }
                        }
                        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 101;
                        NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
                        int i6 = i5 % 2;
                        BottomSheetAddAssetBinding bottomSheetAddAssetBinding3 = binding.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (bottomSheetAddAssetBinding3 != null) {
                            return bottomSheetAddAssetBinding3.lookAheadTest;
                        }
                        return null;
                    }
                }
                BottomSheetAddAssetContainerBinding binding4 = getBinding();
                if (!(binding4 != null)) {
                    return null;
                }
                int i7 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 99;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i7 % 128;
                int i8 = i7 % 2;
                BottomSheetAddAssetBinding bottomSheetAddAssetBinding4 = binding4.KClassImpl$Data$declaredNonStaticMembers$2;
                if (bottomSheetAddAssetBinding4 != null) {
                    try {
                        appCompatTextView = bottomSheetAddAssetBinding4.GetContactSyncConfig;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } else {
                BottomSheetAddAssetContainerBinding binding5 = getBinding();
                if (binding5 != null) {
                    int i9 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 11;
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = i9 % 128;
                    int i10 = i9 % 2;
                    BottomSheetAddAssetBinding bottomSheetAddAssetBinding5 = binding5.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (bottomSheetAddAssetBinding5 != null) {
                        appCompatTextView = bottomSheetAddAssetBinding5.scheduleImpl;
                    }
                }
            }
            return appCompatTextView;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void setSectionTitle() {
        AppCompatTextView textView = getTextView(this.paymentSectionIndex);
        if (textView != null) {
            textView.setText(getString(R.string.add_asset_payment_title));
        }
        AppCompatTextView textView2 = getTextView(this.investmentSectionIndex);
        if (textView2 != null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 7;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            textView2.setText(getString(R.string.add_asset_financial_title));
        }
        AppCompatTextView textView3 = getTextView(this.voucherSectionIndex);
        if (!(textView3 == null)) {
            textView3.setText(getString(R.string.add_asset_voucher_title));
        }
        AppCompatTextView textView4 = getTextView(this.loyaltySectionIndex);
        if (textView4 != null) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
            int i4 = i3 % 2;
            textView4.setText(getString(R.string.add_asset_loyalty_title));
        }
        AppCompatTextView textView5 = getTextView(this.identitySectionIndex);
        if (!(textView5 != null)) {
            return;
        }
        textView5.setText(getString(R.string.add_asset_identity_title));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
    
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        if (r0.isEmpty() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
    
        r0 = 'M';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        if (r0 == 'M') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 59;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        if ((r0 % 2) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        r3 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:
    
        if (r0 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
    
        if (r0 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0054, code lost:
    
        if (id.dana.wallet_v3.util.WalletSectionPositionUtilKt.isContainPaymentSection(r5.walletSectionOrderingList) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
    
        if (r1 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0059, code lost:
    
        getPaymentServiceAdapter().setItems(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0060, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0061, code lost:
    
        r6 = getRecyclerView(r5.paymentSectionIndex);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0069, code lost:
    
        if (r6 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006b, code lost:
    
        r6.setVisibility(8);
        r6 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 + 45;
        id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0078, code lost:
    
        r6 = getTextView(r5.paymentSectionIndex);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007e, code lost:
    
        if (r6 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0080, code lost:
    
        r6.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0083, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
    
        if (r0 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showPaymentSection(java.util.List<id.dana.model.ThirdPartyService> r6) {
        /*
            r5 = this;
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L86
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1     // Catch: java.lang.Exception -> L84
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L45
            goto L1d
        L16:
            r6 = move-exception
            throw r6
        L18:
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L45
        L1d:
            boolean r0 = r0.isEmpty()
            r3 = 77
            if (r0 != 0) goto L27
            r0 = 1
            goto L29
        L27:
            r0 = 77
        L29:
            if (r0 == r3) goto L45
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 59
            int r3 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L39
            r0 = 1
            goto L3a
        L39:
            r0 = 0
        L3a:
            int r3 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L86
            int r3 = r3 + 81
            int r4 = r3 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r4     // Catch: java.lang.Exception -> L84
            int r3 = r3 % 2
            goto L46
        L45:
            r0 = 1
        L46:
            if (r0 != 0) goto L4a
            r0 = 0
            goto L4b
        L4a:
            r0 = 1
        L4b:
            if (r0 == 0) goto L4e
            goto L61
        L4e:
            java.util.List<java.lang.String> r0 = r5.walletSectionOrderingList
            boolean r0 = id.dana.wallet_v3.util.WalletSectionPositionUtilKt.isContainPaymentSection(r0)
            if (r0 == 0) goto L57
            r1 = 1
        L57:
            if (r1 == 0) goto L61
            id.dana.wallet_v3.view.addasset.adapter.AddAssetAdapter r0 = r5.getPaymentServiceAdapter()
            r0.setItems(r6)
            return
        L61:
            int r6 = r5.paymentSectionIndex
            androidx.recyclerview.widget.RecyclerView r6 = r5.getRecyclerView(r6)
            r0 = 8
            if (r6 == 0) goto L78
            r6.setVisibility(r0)
            int r6 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r6 = r6 + 45
            int r1 = r6 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r6 = r6 % 2
        L78:
            int r6 = r5.paymentSectionIndex
            androidx.appcompat.widget.AppCompatTextView r6 = r5.getTextView(r6)
            if (r6 == 0) goto L83
            r6.setVisibility(r0)
        L83:
            return
        L84:
            r6 = move-exception
            throw r6
        L86:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.showPaymentSection(java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if ((r0 ? 16 : 'P') != 'P') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        if ((id.dana.wallet_v3.util.WalletSectionPositionUtilKt.isContainInvestmentSection(r4.walletSectionOrderingList) ? kotlin.text.Typography.less : '[') != '[') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        getFinancialServiceAdapter().setItems(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showFinancialSection(java.util.List<id.dana.model.ThirdPartyService> r5) {
        /*
            r4 = this;
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L4a
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 75
            int r2 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L31
            java.util.List<java.lang.String> r0 = r4.walletSectionOrderingList     // Catch: java.lang.Exception -> L2f
            boolean r0 = id.dana.wallet_v3.util.WalletSectionPositionUtilKt.isContainInvestmentSection(r0)     // Catch: java.lang.Exception -> L2f
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L2d
            r2 = 80
            if (r0 == 0) goto L28
            r0 = 16
            goto L2a
        L28:
            r0 = 80
        L2a:
            if (r0 == r2) goto L4a
            goto L42
        L2d:
            r5 = move-exception
            throw r5
        L2f:
            r5 = move-exception
            goto L7e
        L31:
            java.util.List<java.lang.String> r0 = r4.walletSectionOrderingList
            boolean r0 = id.dana.wallet_v3.util.WalletSectionPositionUtilKt.isContainInvestmentSection(r0)
            r2 = 91
            if (r0 == 0) goto L3e
            r0 = 60
            goto L40
        L3e:
            r0 = 91
        L40:
            if (r0 == r2) goto L4a
        L42:
            id.dana.wallet_v3.view.addasset.adapter.AddAssetAdapter r0 = r4.getFinancialServiceAdapter()
            r0.setItems(r5)
            return
        L4a:
            int r5 = r4.investmentSectionIndex
            androidx.recyclerview.widget.RecyclerView r5 = r4.getRecyclerView(r5)
            r0 = 0
            if (r5 == 0) goto L55
            r2 = 1
            goto L56
        L55:
            r2 = 0
        L56:
            r3 = 8
            if (r2 == 0) goto L5d
            r5.setVisibility(r3)
        L5d:
            int r5 = r4.investmentSectionIndex     // Catch: java.lang.Exception -> L2f
            androidx.appcompat.widget.AppCompatTextView r5 = r4.getTextView(r5)     // Catch: java.lang.Exception -> L2f
            if (r5 == 0) goto L66
            goto L67
        L66:
            r0 = 1
        L67:
            if (r0 == r1) goto L7d
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + r1
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L7a
            r0 = 123(0x7b, float:1.72E-43)
            r5.setVisibility(r0)
            goto L7d
        L7a:
            r5.setVisibility(r3)
        L7d:
            return
        L7e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.showFinancialSection(java.util.List):void");
    }

    private final void showVoucherSection(List<ThirdPartyService> voucherServices) {
        if (voucherServices.isEmpty() ^ true) {
            try {
                if ((WalletSectionPositionUtilKt.isContainVoucherSection(this.walletSectionOrderingList) ? '!' : 'L') == '!') {
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 21;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                    int i2 = i % 2;
                    getVoucherServiceAdapter().setItems(voucherServices);
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 61;
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                    int i4 = i3 % 2;
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        RecyclerView recyclerView = getRecyclerView(this.voucherSectionIndex);
        if (recyclerView != null) {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 23;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
            if (!(i5 % 2 != 0)) {
                recyclerView.setVisibility(8);
            } else {
                recyclerView.setVisibility(119);
            }
            int i6 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 93;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i6 % 128;
            int i7 = i6 % 2;
        }
        AppCompatTextView textView = getTextView(this.voucherSectionIndex);
        if (!(textView != null)) {
            return;
        }
        int i8 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i8 % 128;
        if (i8 % 2 != 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(7);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        if ((!r5.isEmpty()) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        if (id.dana.wallet_v3.util.WalletSectionPositionUtilKt.isContainLoyaltySection(r4.walletSectionOrderingList) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        r0 = kotlin.text.Typography.dollar;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        r0 = 'Y';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        if (r0 == '$') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
    
        getLoyaltyServiceAdapter().setItems(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if ((r5.isEmpty() | true ? 14 : 29) != 29) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showLoyaltySection(java.util.List<id.dana.model.ThirdPartyService> r5) {
        /*
            r4 = this;
            int r0 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 109
            int r1 = r0 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            r1 = 89
            if (r0 != 0) goto L23
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 | 1
            r2 = 29
            if (r0 == 0) goto L1e
            r0 = 14
            goto L20
        L1e:
            r0 = 29
        L20:
            if (r0 == r2) goto L4a
            goto L2e
        L23:
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Exception -> L73
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L73
            r0 = r0 ^ 1
            if (r0 == 0) goto L4a
        L2e:
            java.util.List<java.lang.String> r0 = r4.walletSectionOrderingList     // Catch: java.lang.Exception -> L48
            boolean r0 = id.dana.wallet_v3.util.WalletSectionPositionUtilKt.isContainLoyaltySection(r0)     // Catch: java.lang.Exception -> L48
            r2 = 36
            if (r0 == 0) goto L3b
            r0 = 36
            goto L3d
        L3b:
            r0 = 89
        L3d:
            if (r0 == r2) goto L40
            goto L4a
        L40:
            id.dana.wallet_v3.view.addasset.adapter.AddAssetAdapter r0 = r4.getLoyaltyServiceAdapter()
            r0.setItems(r5)
            return
        L48:
            r5 = move-exception
            throw r5
        L4a:
            int r5 = r4.loyaltySectionIndex
            androidx.recyclerview.widget.RecyclerView r5 = r4.getRecyclerView(r5)
            r0 = 8
            if (r5 == 0) goto L57
            r5.setVisibility(r0)
        L57:
            int r5 = r4.loyaltySectionIndex
            androidx.appcompat.widget.AppCompatTextView r5 = r4.getTextView(r5)
            if (r5 == 0) goto L72
            int r2 = id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r2 = r2 + 75
            int r3 = r2 % 128
            id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L6f
            r5.setVisibility(r1)
            goto L72
        L6f:
            r5.setVisibility(r0)
        L72:
            return
        L73:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset.showLoyaltySection(java.util.List):void");
    }

    private final void showIdentitySection(List<ThirdPartyService> identityServices) {
        if (identityServices.isEmpty() ^ true) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
            int i2 = i % 2;
            if ((!this.identityAssetSaved ? '3' : '5') != '5' && WalletSectionPositionUtilKt.isContainIdentitySection(this.walletSectionOrderingList)) {
                getIdentityServiceAdapter().setItems(identityServices);
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 107;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                int i4 = i3 % 2;
                return;
            }
        }
        RecyclerView recyclerView = getRecyclerView(this.identitySectionIndex);
        if (recyclerView != null) {
            try {
                recyclerView.setVisibility(8);
            } catch (Exception e) {
                throw e;
            }
        }
        AppCompatTextView textView = getTextView(this.identitySectionIndex);
        if (textView != null) {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 65;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i5 % 128;
            int i6 = i5 % 2;
            textView.setVisibility(8);
        }
    }

    private final void trackServiceOpen(ThirdPartyService it) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 113;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if ((i % 2 == 0 ? (char) 23 : (char) 0) != 0) {
                ServicesTracker.getAuthRequestContext(getContext(), it.NetworkUserEntityData$$ExternalSyntheticLambda8, it.newProxyInstance, it.NetworkUserEntityData$$ExternalSyntheticLambda6, it.NetworkUserEntityData$$ExternalSyntheticLambda0);
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                ServicesTracker.getAuthRequestContext(getContext(), it.NetworkUserEntityData$$ExternalSyntheticLambda8, it.newProxyInstance, it.NetworkUserEntityData$$ExternalSyntheticLambda6, it.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final String getFormattedUrl(String url, ThirdPartyService thirdPartyService) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 65;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        if (!(Intrinsics.areEqual(thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8, "service_deals"))) {
            return url;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 125;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            String obj = Uri.parse(url).buildUpon().appendQueryParameter("version", String.valueOf(this.danaDealsVersion)).build().toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            Object obj2 = null;
            obj2.hashCode();
            return obj;
        }
        try {
            String obj3 = Uri.parse(url).buildUpon().appendQueryParameter("version", String.valueOf(this.danaDealsVersion)).build().toString();
            Intrinsics.checkNotNullExpressionValue(obj3, "");
            return obj3;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$walletH5Listener$1] */
    private final BottomSheetAddAsset$walletH5Listener$1 walletH5Listener() {
        ?? r0 = new DanaH5Listener() { // from class: id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset$walletH5Listener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerDestroyed(Bundle bundle) {
                DanaH5Listener.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle bundle) {
                BottomSheetAddAsset.access$getDanaLoadingDialog(BottomSheetAddAsset.this).PlaceComponentResult();
            }
        };
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 95;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? (char) 4 : Typography.less) != '<') {
            int i2 = 26 / 0;
            return r0;
        }
        return r0;
    }

    private static void c(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
                int i2 = $10 + 35;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i4 = 58224;
                int i5 = 0;
                while (true) {
                    if (i5 >= 16) {
                        break;
                    }
                    int i6 = $10 + 77;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (lookAheadTest ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (getErrorConfigVersion ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (moveToNextValue ^ 6353485791441662354L)))));
                    i4 -= 40503;
                    i5++;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
