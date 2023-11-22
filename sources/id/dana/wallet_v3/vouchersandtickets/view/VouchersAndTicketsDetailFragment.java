package id.dana.wallet_v3.vouchersandtickets.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.contract.payasset.SceneType;
import id.dana.core.ui.util.DANAToast;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.DanaH5;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.databinding.FragmentVouchersAndTicketsDetailBinding;
import id.dana.databinding.ViewWalletV3SearchStubBinding;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.wallet_v3.constant.WalletAssetType;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.wallet_v3.WalletDetailBaseImplementation;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.factory.WalletIntentFactory;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.listener.WalletDetailBaseFunction;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.util.SwipeHelper;
import id.dana.wallet_v3.view.NewWalletFragment;
import id.dana.wallet_v3.view.addasset.view.BottomSheetAddAsset;
import id.dana.wallet_v3.view.ptr.PtrWalletFrameLayout;
import id.dana.wallet_v3.view.search.adapter.WalletVerticalSpaceItemDecoration;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment;
import id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset;
import id.dana.wallet_v3.vouchersandtickets.adapter.VouchersAndTicketsAdapter;
import id.dana.wallet_v3.vouchersandtickets.di.DaggerVouchersAndTicketsDetailComponent;
import id.dana.wallet_v3.vouchersandtickets.di.VouchersAndTicketsDetailModule;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract;
import id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$ptrCardVouchersAndTicketsHandle$2;
import id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$walletCardAssetClickListener$2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0081\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0081\u0001B\b¢\u0006\u0005\b\u0080\u0001\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u001cJ\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\u001cJ\u000f\u0010)\u001a\u00020\bH\u0014¢\u0006\u0004\b)\u0010\u001cJ\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u001cJ\u000f\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\u001cJ\u000f\u0010,\u001a\u00020\bH\u0002¢\u0006\u0004\b,\u0010\u001cJ\u000f\u0010-\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010\u001cJ\u0017\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0014¢\u0006\u0004\b0\u00101J\u0018\u00105\u001a\u0002042\u0006\u00103\u001a\u000202H\u0096\u0001¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\bH\u0002¢\u0006\u0004\b7\u0010\u001cJ\r\u00108\u001a\u00020\b¢\u0006\u0004\b8\u0010\u001cJ\u000f\u00109\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u0010\u001cJ\u000f\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b:\u0010\u001cJ\u000f\u0010;\u001a\u00020\bH\u0002¢\u0006\u0004\b;\u0010\u001cJ\u000f\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b<\u0010\u001cJ\u0017\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\bH\u0002¢\u0006\u0004\b@\u0010\u001cJ\u0017\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u000204H\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\bH\u0002¢\u0006\u0004\bD\u0010\u001cJ\u000f\u0010E\u001a\u00020\bH\u0002¢\u0006\u0004\bE\u0010\u001cJ\u000f\u0010F\u001a\u00020\bH\u0002¢\u0006\u0004\bF\u0010\u001cJ\u001d\u0010I\u001a\u00020\b2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00150GH\u0002¢\u0006\u0004\bI\u0010JR*\u0010M\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010Kj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010RR\u0016\u0010T\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010U\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010RR\u0016\u0010V\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010RR\u0016\u0010W\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010RR\u0016\u0010X\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010RR\u0014\u0010Z\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020\\8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u001b\u0010l\u001a\u00020h8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bi\u0010^\u001a\u0004\bj\u0010kR\"\u0010n\u001a\u00020m8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001b\u0010x\u001a\u00020t8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bu\u0010^\u001a\u0004\bv\u0010wR\"\u0010z\u001a\u00020y8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007f"}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/view/VouchersAndTicketsDetailFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentVouchersAndTicketsDetailBinding;", "Lid/dana/wallet_v3/listener/WalletDetailBaseFunction;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "tag", "", "backFromSearch", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", HomeTabActivity.WALLET_SECTION, "backToMainPage", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/fragment/app/FragmentManager;I)V", "Lid/dana/utils/danah5/DanaH5Listener;", "createH5AppListener", "()Lid/dana/utils/danah5/DanaH5Listener;", "position", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", H5GetLogInfoBridge.RESULT_MODEL, "Lkotlin/Function0;", "cancelAction", "deleteVoucherConfirmationDialog", "(ILid/dana/wallet_v3/model/VoucherAndTicketCardModel;Lkotlin/jvm/functions/Function0;)V", "disableSwipe", "()V", "getLayout", "()I", "Lid/dana/wallet_v3/view/NewWalletFragment;", "getNewWalletFragment", "()Lid/dana/wallet_v3/view/NewWalletFragment;", "Lid/dana/wallet_v3/vouchersandtickets/di/VouchersAndTicketsDetailModule;", "getVouchersAndTicketsDetailModule", "()Lid/dana/wallet_v3/vouchersandtickets/di/VouchersAndTicketsDetailModule;", "getWalletFragment", "(Landroidx/fragment/app/FragmentManager;)Lid/dana/wallet_v3/view/NewWalletFragment;", "hideLoadingVoucherAndTicket", "hideShimmeringSkeleton", IAPSyncCommand.COMMAND_INIT, "initArgsData", "initInjector", "initOnClickListener", "initView", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/FragmentVouchersAndTicketsDetailBinding;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "isFromDeeplinkWallet", "(Landroid/app/Activity;)Z", "navigateToSearch", "onCollapseFromSearch", "onDestroyView", "onStart", "openBottomSheetAddAsset", "openBottomSheetSortAsset", "url", "redirectToMerchantPage", "(Ljava/lang/String;)V", "refreshVoucherList", "isDefaultIndonesian", "setupLottieBasedOnLanguage", "(Z)V", "showLoadingVoucherAndTicket", "showShimmeringSkeleton", "showSuccessToast", "Lid/dana/wallet_v3/model/NewPocketQueryListModel;", SceneType.ASSETS, "updateVoucherAssetView", "(Lid/dana/wallet_v3/model/NewPocketQueryListModel;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "assetTypes", "Ljava/util/ArrayList;", "danaDealsVersion", "I", "fromDeleteVoucher", "Z", "fromSearch", "fromVoucherDetail", "hasMore", GriverMonitorConstants.KEY_IS_LOADING, "isNeedResetPagination", "isSwipe", "Lid/dana/wallet_v3/vouchersandtickets/view/VouchersAndTicketsDetailFragment$onBackPressedCallback$1;", "onBackPressedCallback", "Lid/dana/wallet_v3/vouchersandtickets/view/VouchersAndTicketsDetailFragment$onBackPressedCallback$1;", "Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardVouchersAndTicketsHandle$delegate", "Lkotlin/Lazy;", "getPtrCardVouchersAndTicketsHandle", "()Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardVouchersAndTicketsHandle", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonScreen", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/wallet_v3/util/SwipeHelper;", "swipeHelper", "Lid/dana/wallet_v3/util/SwipeHelper;", "Lid/dana/wallet_v3/vouchersandtickets/adapter/VouchersAndTicketsAdapter;", "vouchersAndTicketsAdapter$delegate", "getVouchersAndTicketsAdapter", "()Lid/dana/wallet_v3/vouchersandtickets/adapter/VouchersAndTicketsAdapter;", "vouchersAndTicketsAdapter", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VouchersAndTicketsDetailContract$Presenter;", "vouchersAndTicketsDetailPresenter", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VouchersAndTicketsDetailContract$Presenter;", "getVouchersAndTicketsDetailPresenter", "()Lid/dana/wallet_v3/vouchersandtickets/presenter/VouchersAndTicketsDetailContract$Presenter;", "setVouchersAndTicketsDetailPresenter", "(Lid/dana/wallet_v3/vouchersandtickets/presenter/VouchersAndTicketsDetailContract$Presenter;)V", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener$delegate", "getWalletCardAssetClickListener", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "walletV3TrackerImplementation", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "getWalletV3TrackerImplementation", "()Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "setWalletV3TrackerImplementation", "(Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VouchersAndTicketsDetailFragment extends ViewBindingFragment<FragmentVouchersAndTicketsDetailBinding> implements WalletDetailBaseFunction {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HAS_MORE_VOUCHER_AND_TICKET = "HAS_MORE_VOUCHER_AND_TICKET";
    private static final String IS_NEED_RESET_PAGINATION = "IS_NEED_RESET_PAGINATION";
    private static final String VOUCHES_AND_TICKET_ITEMS = "VOUCHES_AND_TICKET_CARD_ITEMS";
    private ArrayList<String> assetTypes;
    private boolean fromDeleteVoucher;
    private boolean fromSearch;
    private boolean fromVoucherDetail;
    private boolean isLoading;
    private boolean isNeedResetPagination;
    private boolean isSwipe;
    private SkeletonScreen skeletonScreen;
    private SwipeHelper swipeHelper;
    @Inject
    public VouchersAndTicketsDetailContract.Presenter vouchersAndTicketsDetailPresenter;
    @Inject
    public WalletV3TrackerImpl walletV3TrackerImplementation;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final /* synthetic */ WalletDetailBaseImplementation $$delegate_0 = new WalletDetailBaseImplementation();

    /* renamed from: vouchersAndTicketsAdapter$delegate  reason: from kotlin metadata */
    private final Lazy vouchersAndTicketsAdapter = LazyKt.lazy(new Function0<VouchersAndTicketsAdapter>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$vouchersAndTicketsAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VouchersAndTicketsAdapter invoke() {
            WalletCardAssetClickListener walletCardAssetClickListener;
            walletCardAssetClickListener = VouchersAndTicketsDetailFragment.this.getWalletCardAssetClickListener();
            return new VouchersAndTicketsAdapter(walletCardAssetClickListener);
        }
    });

    /* renamed from: ptrCardVouchersAndTicketsHandle$delegate  reason: from kotlin metadata */
    private final Lazy ptrCardVouchersAndTicketsHandle = LazyKt.lazy(new Function0<VouchersAndTicketsDetailFragment$ptrCardVouchersAndTicketsHandle$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$ptrCardVouchersAndTicketsHandle$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$ptrCardVouchersAndTicketsHandle$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment = VouchersAndTicketsDetailFragment.this;
            return new PtrHandler() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$ptrCardVouchersAndTicketsHandle$2.1
                @Override // in.srain.cube.views.ptr.PtrHandler
                public final boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                    FragmentVouchersAndTicketsDetailBinding binding;
                    boolean z;
                    RecyclerView recyclerView;
                    binding = VouchersAndTicketsDetailFragment.this.getBinding();
                    RecyclerView.LayoutManager layoutManager = (binding == null || (recyclerView = binding.moveToNextValue) == null) ? null : recyclerView.getLayoutManager();
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? layoutManager : null;
                    if ((linearLayoutManager != null ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : -1) == 0) {
                        z = VouchersAndTicketsDetailFragment.this.isSwipe;
                        if (!z) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // in.srain.cube.views.ptr.PtrHandler
                public final void onRefreshBegin(PtrFrameLayout frame) {
                    FragmentVouchersAndTicketsDetailBinding binding;
                    PtrWalletFrameLayout ptrWalletFrameLayout;
                    VouchersAndTicketsDetailFragment.this.navigateToSearch();
                    binding = VouchersAndTicketsDetailFragment.this.getBinding();
                    if (binding == null || (ptrWalletFrameLayout = binding.getErrorConfigVersion) == null) {
                        return;
                    }
                    ptrWalletFrameLayout.refreshComplete();
                }
            };
        }
    });
    private boolean hasMore = true;
    private int danaDealsVersion = 1;
    private final VouchersAndTicketsDetailFragment$onBackPressedCallback$1 onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$onBackPressedCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(true);
        }

        @Override // androidx.view.OnBackPressedCallback
        public final void handleOnBackPressed() {
            FragmentVouchersAndTicketsDetailBinding binding;
            VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment = VouchersAndTicketsDetailFragment.this;
            binding = vouchersAndTicketsDetailFragment.getBinding();
            RecyclerView recyclerView = binding != null ? binding.moveToNextValue : null;
            FragmentManager parentFragmentManager = VouchersAndTicketsDetailFragment.this.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            vouchersAndTicketsDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 2);
        }
    };

    /* renamed from: walletCardAssetClickListener$delegate  reason: from kotlin metadata */
    private final Lazy walletCardAssetClickListener = LazyKt.lazy(new Function0<VouchersAndTicketsDetailFragment$walletCardAssetClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$walletCardAssetClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$walletCardAssetClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment = VouchersAndTicketsDetailFragment.this;
            return new WalletCardAssetClickListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$walletCardAssetClickListener$2.1
                /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
                
                    r1 = r1.getNewWalletFragment();
                 */
                @Override // id.dana.wallet_v3.listener.WalletCardAssetClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void onCardClicked(id.dana.wallet_v3.model.WalletV3CardModel r6) {
                    /*
                        r5 = this;
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment r1 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.this
                        boolean r1 = r1.isAdded()
                        if (r1 == 0) goto L1a
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment r1 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.this
                        id.dana.wallet_v3.view.NewWalletFragment r1 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.access$getNewWalletFragment(r1)
                        if (r1 == 0) goto L1a
                        java.lang.String r2 = "VOUCHER_AND_TICKET"
                        r1.setLastWalletSectionTypeDetailOpened(r2)
                    L1a:
                        boolean r1 = r6 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.ParkingTicketCard
                        if (r1 == 0) goto L30
                        id.dana.wallet_v3.model.VoucherAndTicketCardModel$ParkingTicketCard r6 = (id.dana.wallet_v3.model.VoucherAndTicketCardModel.ParkingTicketCard) r6
                        java.lang.String r6 = r6.getQrUrl()
                        if (r6 == 0) goto Lcf
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment r0 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.this
                        id.dana.utils.danah5.DanaH5Listener r0 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.access$createH5AppListener(r0)
                        id.dana.danah5.DanaH5.startContainerFullUrl(r6, r0)
                        return
                    L30:
                        boolean r1 = r6 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.VoucherCard
                        java.lang.String r2 = "https://m.dana.id"
                        r3 = 0
                        r4 = 1
                        if (r1 == 0) goto L6a
                        kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
                        java.lang.Object[] r1 = new java.lang.Object[r4]
                        id.dana.wallet_v3.model.VoucherAndTicketCardModel$VoucherCard r6 = (id.dana.wallet_v3.model.VoucherAndTicketCardModel.VoucherCard) r6
                        java.lang.String r6 = r6.getPocketId()
                        r1[r3] = r6
                        java.lang.Object[] r6 = java.util.Arrays.copyOf(r1, r4)
                        java.lang.String r1 = "/i/dana-promotion/pocket/detail?pocketId=%s&isClosable=true&voucherV2=true"
                        java.lang.String r6 = java.lang.String.format(r1, r6)
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        r0.append(r2)
                        r0.append(r6)
                        java.lang.String r6 = r0.toString()
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment r0 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.this
                        id.dana.utils.danah5.DanaH5Listener r0 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.access$createH5AppListener(r0)
                        id.dana.danah5.DanaH5.startContainerFullUrl(r6, r0)
                        return
                    L6a:
                        boolean r1 = r6 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.DealsCard
                        if (r1 == 0) goto La0
                        kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
                        java.lang.Object[] r1 = new java.lang.Object[r4]
                        id.dana.wallet_v3.model.VoucherAndTicketCardModel$DealsCard r6 = (id.dana.wallet_v3.model.VoucherAndTicketCardModel.DealsCard) r6
                        java.lang.String r6 = r6.getPocketId()
                        r1[r3] = r6
                        java.lang.Object[] r6 = java.util.Arrays.copyOf(r1, r4)
                        java.lang.String r1 = "/n/dana-deals-v2/pocket/detail?pocketId=%s"
                        java.lang.String r6 = java.lang.String.format(r1, r6)
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        r0.append(r2)
                        r0.append(r6)
                        java.lang.String r6 = r0.toString()
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment r0 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.this
                        id.dana.utils.danah5.DanaH5Listener r0 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.access$createH5AppListener(r0)
                        id.dana.danah5.DanaH5.startContainerFullUrl(r6, r0)
                        return
                    La0:
                        boolean r1 = r6 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.TravelTicketCard
                        if (r1 == 0) goto Lb3
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment r1 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.this
                        id.dana.wallet_v3.model.VoucherAndTicketCardModel$TravelTicketCard r6 = (id.dana.wallet_v3.model.VoucherAndTicketCardModel.TravelTicketCard) r6
                        java.lang.String r6 = r6.getPrimaryCTA()
                        if (r6 == 0) goto Laf
                        r0 = r6
                    Laf:
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.access$redirectToMerchantPage(r1, r0)
                        return
                    Lb3:
                        boolean r1 = r6 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.MovieTicketCard
                        if (r1 == 0) goto Lc6
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment r1 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.this
                        id.dana.wallet_v3.model.VoucherAndTicketCardModel$MovieTicketCard r6 = (id.dana.wallet_v3.model.VoucherAndTicketCardModel.MovieTicketCard) r6
                        java.lang.String r6 = r6.getPrimaryCTA()
                        if (r6 == 0) goto Lc2
                        r0 = r6
                    Lc2:
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.access$redirectToMerchantPage(r1, r0)
                        return
                    Lc6:
                        boolean r6 = r6 instanceof id.dana.wallet_v3.model.VoucherAndTicketCardModel.EmptyState
                        if (r6 == 0) goto Lcf
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment r6 = id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.this
                        id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment.access$openBottomSheetAddAsset(r6)
                    Lcf:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$walletCardAssetClickListener$2.AnonymousClass1.onCardClicked(id.dana.wallet_v3.model.WalletV3CardModel):void");
                }
            };
        }
    });

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backFromSearch(FragmentManager fragmentManager, String tag) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(tag, "");
        this.$$delegate_0.backFromSearch(fragmentManager, tag);
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backToMainPage(RecyclerView recyclerView, FragmentManager fragmentManager, int section) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        this.$$delegate_0.backToMainPage(recyclerView, fragmentManager, section);
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_vouchers_and_tickets_detail;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final NewWalletFragment getWalletFragment(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        return this.$$delegate_0.getWalletFragment(fragmentManager);
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final boolean isFromDeeplinkWallet(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        return this.$$delegate_0.isFromDeeplinkWallet(activity);
    }

    @JvmName(name = "getVouchersAndTicketsDetailPresenter")
    public final VouchersAndTicketsDetailContract.Presenter getVouchersAndTicketsDetailPresenter() {
        VouchersAndTicketsDetailContract.Presenter presenter = this.vouchersAndTicketsDetailPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setVouchersAndTicketsDetailPresenter")
    public final void setVouchersAndTicketsDetailPresenter(VouchersAndTicketsDetailContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.vouchersAndTicketsDetailPresenter = presenter;
    }

    @JvmName(name = "getWalletV3TrackerImplementation")
    public final WalletV3TrackerImpl getWalletV3TrackerImplementation() {
        WalletV3TrackerImpl walletV3TrackerImpl = this.walletV3TrackerImplementation;
        if (walletV3TrackerImpl != null) {
            return walletV3TrackerImpl;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setWalletV3TrackerImplementation")
    public final void setWalletV3TrackerImplementation(WalletV3TrackerImpl walletV3TrackerImpl) {
        Intrinsics.checkNotNullParameter(walletV3TrackerImpl, "");
        this.walletV3TrackerImplementation = walletV3TrackerImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final FragmentVouchersAndTicketsDetailBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentVouchersAndTicketsDetailBinding PlaceComponentResult = FragmentVouchersAndTicketsDetailBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getVouchersAndTicketsAdapter")
    public final VouchersAndTicketsAdapter getVouchersAndTicketsAdapter() {
        return (VouchersAndTicketsAdapter) this.vouchersAndTicketsAdapter.getValue();
    }

    @JvmName(name = "getPtrCardVouchersAndTicketsHandle")
    private final PtrHandler getPtrCardVouchersAndTicketsHandle() {
        return (PtrHandler) this.ptrCardVouchersAndTicketsHandle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteVoucherConfirmationDialog(final int position, final VoucherAndTicketCardModel model, final Function0<Unit> cancelAction) {
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(baseActivity);
        builder.DatabaseTableConfigUtil = R.drawable.ic_delete_voucher_confirm;
        BaseActivity baseActivity2 = getBaseActivity();
        builder.SubSequence = baseActivity2 != null ? baseActivity2.getString(R.string.delete_voucher_dialog_title) : null;
        BaseActivity baseActivity3 = getBaseActivity();
        builder.GetContactSyncConfig = baseActivity3 != null ? baseActivity3.getString(R.string.delete_voucher_dialog_desc) : null;
        BaseActivity baseActivity4 = getBaseActivity();
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity4 != null ? baseActivity4.getString(R.string.option_no) : null, new Function1<View, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$deleteVoucherConfirmationDialog$dialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                cancelAction.invoke();
            }
        });
        BaseActivity baseActivity5 = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance = baseActivity5 != null ? baseActivity5.getString(R.string.wallet_cancel_delete_voucher) : null;
        BaseActivity baseActivity6 = getBaseActivity();
        CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(baseActivity6 != null ? baseActivity6.getString(R.string.option_yes) : null, new Function1<View, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$deleteVoucherConfirmationDialog$dialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                VouchersAndTicketsDetailFragment.this.showShimmeringSkeleton();
                VouchersAndTicketsDetailContract.Presenter vouchersAndTicketsDetailPresenter = VouchersAndTicketsDetailFragment.this.getVouchersAndTicketsDetailPresenter();
                int i = position;
                VoucherAndTicketCardModel voucherAndTicketCardModel = model;
                vouchersAndTicketsDetailPresenter.updatePocketAsset(i, voucherAndTicketCardModel != null ? voucherAndTicketCardModel.getPocketId() : null);
            }
        });
        BaseActivity baseActivity7 = getBaseActivity();
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = baseActivity7 != null ? baseActivity7.getString(R.string.wallet_yes_delete_voucher) : null;
        BuiltInFictitiousFunctionClassFactory.moveToNextValue = 0L;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getWalletCardAssetClickListener")
    public final WalletCardAssetClickListener getWalletCardAssetClickListener() {
        return (WalletCardAssetClickListener) this.walletCardAssetClickListener.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity == null || !isFromDeeplinkWallet(activity)) {
            return;
        }
        FragmentVouchersAndTicketsDetailBinding binding = getBinding();
        RecyclerView recyclerView = binding != null ? binding.moveToNextValue : null;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        backToMainPage(recyclerView, parentFragmentManager, 2);
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        initInjector();
        initArgsData();
        initView();
        initOnClickListener();
        disableSwipe();
        FragmentActivity activity = getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.PlaceComponentResult(this, this.onBackPressedCallback);
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        setEnabled(false);
        remove();
        _$_clearFindViewByIdCache();
    }

    private final void initInjector() {
        DaggerVouchersAndTicketsDetailComponent.builder().applicationComponent(getApplicationComponent()).vouchersAndTicketsDetailModule(getVouchersAndTicketsDetailModule()).build().inject(this);
    }

    private final void initArgsData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hasMore = arguments.getBoolean(HAS_MORE_VOUCHER_AND_TICKET);
            this.isNeedResetPagination = arguments.getBoolean(IS_NEED_RESET_PAGINATION);
            this.assetTypes = arguments.getStringArrayList(WalletConstant.ASSET_TYPES);
            this.danaDealsVersion = arguments.getInt(WalletConstant.DANA_DEALS_VERSION);
        }
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$initView$3] */
    private final void initView() {
        ArrayList arrayList;
        PtrWalletFrameLayout ptrWalletFrameLayout;
        ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding;
        RecyclerView recyclerView;
        Parcelable[] parcelableArray;
        List list;
        RecyclerView recyclerView2;
        FragmentVouchersAndTicketsDetailBinding binding = getBinding();
        if (binding != null && (recyclerView2 = binding.moveToNextValue) != null) {
            recyclerView2.setItemAnimator(null);
            final Context context = recyclerView2.getContext();
            recyclerView2.setLayoutManager(new LinearLayoutManager(context) { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$initView$1$1
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public final boolean canScrollVertically() {
                    boolean z;
                    z = VouchersAndTicketsDetailFragment.this.isSwipe;
                    return !z;
                }
            });
            recyclerView2.setAdapter(getVouchersAndTicketsAdapter());
            recyclerView2.setNestedScrollingEnabled(false);
            recyclerView2.addItemDecoration(new WalletVerticalSpaceItemDecoration());
        }
        Bundle arguments = getArguments();
        if (arguments == null || (parcelableArray = arguments.getParcelableArray(VOUCHES_AND_TICKET_ITEMS)) == null || (list = ArraysKt.toList(parcelableArray)) == null) {
            arrayList = null;
        } else {
            List<Parcelable> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Parcelable parcelable : list2) {
                arrayList2.add(parcelable instanceof VoucherAndTicketCardModel ? (VoucherAndTicketCardModel) parcelable : null);
            }
            arrayList = arrayList2;
        }
        getVouchersAndTicketsAdapter().setItems(arrayList);
        Context requireContext = requireContext();
        FragmentVouchersAndTicketsDetailBinding binding2 = getBinding();
        Intrinsics.checkNotNull(binding2);
        RecyclerView recyclerView3 = binding2.moveToNextValue;
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        this.swipeHelper = new VouchersAndTicketsDetailFragment$initView$2(this, requireContext, recyclerView3, arrayList, new Function1<Boolean, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$initView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                VouchersAndTicketsDetailFragment.this.isSwipe = z;
            }
        });
        FragmentVouchersAndTicketsDetailBinding binding3 = getBinding();
        if (binding3 != null && (recyclerView = binding3.moveToNextValue) != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$initView$4$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView recyclerView4, int dx, int dy) {
                    boolean z;
                    boolean z2;
                    boolean z3;
                    ArrayList arrayList3;
                    List<String> voucherAssetTypes;
                    Intrinsics.checkNotNullParameter(recyclerView4, "");
                    if (recyclerView4.canScrollVertically(1)) {
                        return;
                    }
                    z = VouchersAndTicketsDetailFragment.this.hasMore;
                    if (z) {
                        z2 = VouchersAndTicketsDetailFragment.this.isLoading;
                        if (z2) {
                            return;
                        }
                        VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment = VouchersAndTicketsDetailFragment.this;
                        FragmentManager parentFragmentManager = vouchersAndTicketsDetailFragment.getParentFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                        NewWalletFragment walletFragment = vouchersAndTicketsDetailFragment.getWalletFragment(parentFragmentManager);
                        if (walletFragment != null) {
                            VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment2 = VouchersAndTicketsDetailFragment.this;
                            VouchersAndTicketsDetailContract.Presenter vouchersAndTicketsDetailPresenter = vouchersAndTicketsDetailFragment2.getVouchersAndTicketsDetailPresenter();
                            z3 = vouchersAndTicketsDetailFragment2.isNeedResetPagination;
                            String assetOrder = walletFragment.getAssetOrder();
                            if (assetOrder == null) {
                                assetOrder = AssetStatus.EXPIRING_SOON.name();
                            }
                            arrayList3 = vouchersAndTicketsDetailFragment2.assetTypes;
                            if (arrayList3 == null || (voucherAssetTypes = CollectionsKt.toList(arrayList3)) == null) {
                                voucherAssetTypes = WalletAssetType.INSTANCE.getVoucherAssetTypes();
                            }
                            vouchersAndTicketsDetailPresenter.getVoucherAndTicketAsset(z3, false, assetOrder, voucherAssetTypes);
                        }
                    }
                }
            });
        }
        FragmentVouchersAndTicketsDetailBinding binding4 = getBinding();
        AppCompatTextView appCompatTextView = (binding4 == null || (viewWalletV3SearchStubBinding = binding4.NetworkUserEntityData$$ExternalSyntheticLambda2) == null) ? null : viewWalletV3SearchStubBinding.PlaceComponentResult;
        if (appCompatTextView != null) {
            Context context2 = getContext();
            appCompatTextView.setText(context2 != null ? context2.getString(R.string.wallet_search_bar_hint_voucher_ticket) : null);
        }
        FragmentVouchersAndTicketsDetailBinding binding5 = getBinding();
        if (binding5 != null && (ptrWalletFrameLayout = binding5.getErrorConfigVersion) != null) {
            ptrWalletFrameLayout.setPtrHandler(getPtrCardVouchersAndTicketsHandle());
        }
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        setupLottieBasedOnLanguage(LocaleUtil.PlaceComponentResult());
    }

    public final void onCollapseFromSearch() {
        MotionLayout motionLayout;
        MotionLayout motionLayout2;
        FragmentVouchersAndTicketsDetailBinding binding = getBinding();
        if (binding != null && (motionLayout2 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            motionLayout2.setTransition(R.id.collapse_from_search);
        }
        FragmentVouchersAndTicketsDetailBinding binding2 = getBinding();
        if (binding2 == null || (motionLayout = binding2.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            return;
        }
        motionLayout.transitionToEnd();
    }

    private final void initOnClickListener() {
        ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding;
        ConstraintLayout constraintLayout;
        LottieAnimationView lottieAnimationView;
        DanaButtonPrimaryView danaButtonPrimaryView;
        DanaButtonSecondaryView danaButtonSecondaryView;
        AppCompatImageView appCompatImageView;
        FragmentVouchersAndTicketsDetailBinding binding = getBinding();
        if (binding != null && (appCompatImageView = binding.lookAheadTest) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VouchersAndTicketsDetailFragment.m3143initOnClickListener$lambda6(VouchersAndTicketsDetailFragment.this, view);
                }
            });
        }
        FragmentVouchersAndTicketsDetailBinding binding2 = getBinding();
        if (binding2 != null && (danaButtonSecondaryView = binding2.BuiltInFictitiousFunctionClassFactory) != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VouchersAndTicketsDetailFragment.m3144initOnClickListener$lambda7(VouchersAndTicketsDetailFragment.this, view);
                }
            });
        }
        FragmentVouchersAndTicketsDetailBinding binding3 = getBinding();
        if (binding3 != null && (danaButtonPrimaryView = binding3.getAuthRequestContext) != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VouchersAndTicketsDetailFragment.m3145initOnClickListener$lambda8(VouchersAndTicketsDetailFragment.this, view);
                }
            });
        }
        FragmentVouchersAndTicketsDetailBinding binding4 = getBinding();
        if (binding4 != null && (lottieAnimationView = binding4.MyBillsEntityDataFactory) != null) {
            lottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VouchersAndTicketsDetailFragment.m3146initOnClickListener$lambda9(VouchersAndTicketsDetailFragment.this, view);
                }
            });
        }
        FragmentVouchersAndTicketsDetailBinding binding5 = getBinding();
        if (binding5 == null || (viewWalletV3SearchStubBinding = binding5.NetworkUserEntityData$$ExternalSyntheticLambda2) == null || (constraintLayout = viewWalletV3SearchStubBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VouchersAndTicketsDetailFragment.m3142initOnClickListener$lambda10(VouchersAndTicketsDetailFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-6  reason: not valid java name */
    public static final void m3143initOnClickListener$lambda6(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(vouchersAndTicketsDetailFragment, "");
        Intent intent = new Intent(vouchersAndTicketsDetailFragment.getContext(), VoucherAndTicketExpiredListActivity.class);
        intent.putStringArrayListExtra(WalletConstant.ASSET_TYPES, vouchersAndTicketsDetailFragment.assetTypes);
        intent.putExtra(WalletConstant.DANA_DEALS_VERSION, vouchersAndTicketsDetailFragment.danaDealsVersion);
        vouchersAndTicketsDetailFragment.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-7  reason: not valid java name */
    public static final void m3144initOnClickListener$lambda7(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(vouchersAndTicketsDetailFragment, "");
        vouchersAndTicketsDetailFragment.openBottomSheetSortAsset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-8  reason: not valid java name */
    public static final void m3145initOnClickListener$lambda8(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(vouchersAndTicketsDetailFragment, "");
        vouchersAndTicketsDetailFragment.getWalletV3TrackerImplementation().trackOpenAddAsset(TrackerKey.WalletAddAssetSource.ADD_VOUCHER_SECTION);
        vouchersAndTicketsDetailFragment.openBottomSheetAddAsset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-9  reason: not valid java name */
    public static final void m3146initOnClickListener$lambda9(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(vouchersAndTicketsDetailFragment, "");
        FragmentVouchersAndTicketsDetailBinding binding = vouchersAndTicketsDetailFragment.getBinding();
        RecyclerView recyclerView = binding != null ? binding.moveToNextValue : null;
        FragmentManager parentFragmentManager = vouchersAndTicketsDetailFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        vouchersAndTicketsDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-10  reason: not valid java name */
    public static final void m3142initOnClickListener$lambda10(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(vouchersAndTicketsDetailFragment, "");
        vouchersAndTicketsDetailFragment.navigateToSearch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToSearch() {
        MotionLayout motionLayout;
        MotionLayout motionLayout2;
        FragmentVouchersAndTicketsDetailBinding binding = getBinding();
        if (binding != null && (motionLayout2 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            motionLayout2.setTransition(R.id.expand_to_search);
        }
        FragmentVouchersAndTicketsDetailBinding binding2 = getBinding();
        if (binding2 == null || (motionLayout = binding2.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            return;
        }
        motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                VouchersAndTicketsDetailFragment.m3147navigateToSearch$lambda11(VouchersAndTicketsDetailFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: navigateToSearch$lambda-11  reason: not valid java name */
    public static final void m3147navigateToSearch$lambda11(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment) {
        Intrinsics.checkNotNullParameter(vouchersAndTicketsDetailFragment, "");
        WalletIntentFactory walletIntentFactory = WalletIntentFactory.INSTANCE;
        VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment2 = vouchersAndTicketsDetailFragment;
        WalletSearchFragment.Companion companion = WalletSearchFragment.INSTANCE;
        Context context = vouchersAndTicketsDetailFragment.getContext();
        walletIntentFactory.openNewFragmentWithAnimation(vouchersAndTicketsDetailFragment2, WalletSearchFragment.Companion.newInstance$default(companion, "voucher_and_ticket", context != null ? context.getString(R.string.wallet_search_bar_hint_voucher_ticket) : null, null, null, 12, null));
    }

    private final VouchersAndTicketsDetailModule getVouchersAndTicketsDetailModule() {
        return new VouchersAndTicketsDetailModule(new VouchersAndTicketsDetailContract.View() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$getVouchersAndTicketsDetailModule$1
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

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract.View
            public final void onErrorUpdateVoucherAssets() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract.View
            public final void onGetVoucherAndTicketAssetSuccess(NewPocketQueryListModel<VoucherAndTicketCardModel> assets) {
                boolean z;
                boolean z2;
                boolean z3;
                VouchersAndTicketsAdapter vouchersAndTicketsAdapter;
                Intrinsics.checkNotNullParameter(assets, "");
                z = VouchersAndTicketsDetailFragment.this.fromSearch;
                if (!z) {
                    z2 = VouchersAndTicketsDetailFragment.this.fromDeleteVoucher;
                    if (!z2) {
                        z3 = VouchersAndTicketsDetailFragment.this.fromVoucherDetail;
                        if (z3) {
                            VouchersAndTicketsDetailFragment.this.hideShimmeringSkeleton();
                            VouchersAndTicketsDetailFragment.this.updateVoucherAssetView(assets);
                            VouchersAndTicketsDetailFragment.this.fromVoucherDetail = false;
                            return;
                        }
                        vouchersAndTicketsAdapter = VouchersAndTicketsDetailFragment.this.getVouchersAndTicketsAdapter();
                        vouchersAndTicketsAdapter.appendItems(assets.getPockets());
                        VouchersAndTicketsDetailFragment.this.hasMore = assets.getHasMore();
                        return;
                    }
                }
                VouchersAndTicketsDetailFragment.this.hideShimmeringSkeleton();
                VouchersAndTicketsDetailFragment.this.showSuccessToast();
                VouchersAndTicketsDetailFragment.this.updateVoucherAssetView(assets);
                VouchersAndTicketsDetailFragment.this.fromSearch = false;
                VouchersAndTicketsDetailFragment.this.fromDeleteVoucher = false;
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract.View
            public final void onGetVoucherAndTicketAssetError() {
                boolean z;
                z = VouchersAndTicketsDetailFragment.this.fromSearch;
                if (z) {
                    DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                    BaseActivity baseActivity = VouchersAndTicketsDetailFragment.this.getBaseActivity();
                    Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                    String string = VouchersAndTicketsDetailFragment.this.getString(R.string.failed_sort_msg);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    DANAToast.MyBillsEntityDataFactory(baseActivity, string, "");
                    VouchersAndTicketsDetailFragment.this.fromSearch = false;
                }
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract.View
            public final void viewLoadingGetVoucherAndTicketAsset() {
                VouchersAndTicketsDetailFragment.this.showLoadingVoucherAndTicket();
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract.View
            public final void dismissLoadingGetVoucherAndTicketAsset() {
                VouchersAndTicketsDetailFragment.this.hideLoadingVoucherAndTicket();
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract.View
            public final void onSuccessUpdateVoucherAssets(int position) {
                VouchersAndTicketsDetailFragment.this.fromDeleteVoucher = true;
                VouchersAndTicketsDetailFragment.this.refreshVoucherList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSuccessToast() {
        if (this.fromSearch) {
            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
            BaseActivity baseActivity = getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            String string = getString(R.string.success_sort_msg);
            Intrinsics.checkNotNullExpressionValue(string, "");
            DANAToast.PlaceComponentResult(baseActivity, string, "");
            return;
        }
        DANAToast dANAToast2 = DANAToast.BuiltInFictitiousFunctionClassFactory;
        BaseActivity baseActivity2 = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
        String string2 = getString(R.string.success_delete_voucher);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        DANAToast.PlaceComponentResult(baseActivity2, string2, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateVoucherAssetView(NewPocketQueryListModel<VoucherAndTicketCardModel> assets) {
        hideShimmeringSkeleton();
        getVouchersAndTicketsAdapter().setItems(assets.getPockets());
        SwipeHelper swipeHelper = this.swipeHelper;
        if (swipeHelper != null) {
            swipeHelper.updateVoucherList(assets.getPockets());
        }
        this.hasMore = assets.getHasMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingVoucherAndTicket() {
        this.isLoading = true;
        getVouchersAndTicketsAdapter().showLoadingViewOnTheLastItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoadingVoucherAndTicket() {
        this.isLoading = false;
        getVouchersAndTicketsAdapter().hideLoadingView();
    }

    private final void openBottomSheetSortAsset() {
        new BottomSheetSortAsset(new Function1<AssetStatus, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$openBottomSheetSortAsset$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AssetStatus assetStatus) {
                ArrayList arrayList;
                List<String> voucherAssetTypes;
                Intrinsics.checkNotNullParameter(assetStatus, "");
                if (VouchersAndTicketsDetailFragment.this.isAdded()) {
                    VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment = VouchersAndTicketsDetailFragment.this;
                    FragmentManager parentFragmentManager = vouchersAndTicketsDetailFragment.getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                    NewWalletFragment walletFragment = vouchersAndTicketsDetailFragment.getWalletFragment(parentFragmentManager);
                    if (walletFragment != null) {
                        VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment2 = VouchersAndTicketsDetailFragment.this;
                        VouchersAndTicketsDetailContract.Presenter vouchersAndTicketsDetailPresenter = vouchersAndTicketsDetailFragment2.getVouchersAndTicketsDetailPresenter();
                        String name = assetStatus.name();
                        arrayList = vouchersAndTicketsDetailFragment2.assetTypes;
                        if (arrayList == null || (voucherAssetTypes = CollectionsKt.toList(arrayList)) == null) {
                            voucherAssetTypes = WalletAssetType.INSTANCE.getVoucherAssetTypes();
                        }
                        vouchersAndTicketsDetailPresenter.getVoucherAndTicketAsset(false, true, name, voucherAssetTypes);
                        walletFragment.setLastAddedAssetType(3);
                        walletFragment.setAssetOrder(assetStatus.name());
                        walletFragment.refreshDataBasedOnLatestAddedAssetType();
                    }
                }
                VouchersAndTicketsDetailFragment.this.fromSearch = true;
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AssetStatus assetStatus) {
                invoke2(assetStatus);
                return Unit.INSTANCE;
            }
        }, "VOUCHER_AND_TICKET").show(getParentFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openBottomSheetAddAsset() {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$openBottomSheetAddAsset$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (VouchersAndTicketsDetailFragment.this.isAdded()) {
                    VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment = VouchersAndTicketsDetailFragment.this;
                    FragmentManager parentFragmentManager = vouchersAndTicketsDetailFragment.getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                    NewWalletFragment walletFragment = vouchersAndTicketsDetailFragment.getWalletFragment(parentFragmentManager);
                    if (walletFragment != null) {
                        walletFragment.setLastAddedAssetType(3);
                        walletFragment.refreshDataBasedOnLatestAddedAssetType();
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        String lowerCase = "VOUCHER_AND_TICKET".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        new BottomSheetAddAsset(function0, 3, CollectionsKt.listOf(lowerCase), this.danaDealsVersion, null, null, false, null, 240, null).show(getParentFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NewWalletFragment getNewWalletFragment() {
        Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag(HomeTabFragment.FragmentTag.WALLET_FRAGMENT);
        if (findFragmentByTag instanceof NewWalletFragment) {
            return (NewWalletFragment) findFragmentByTag;
        }
        return null;
    }

    private final void disableSwipe() {
        FragmentActivity activity = getActivity();
        HomeTabActivity homeTabActivity = activity instanceof HomeTabActivity ? (HomeTabActivity) activity : null;
        if (homeTabActivity != null) {
            homeTabActivity.setSwipeable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void redirectToMerchantPage(String url) {
        if (url.length() > 0) {
            DanaH5.startContainerFullUrl(url, createH5AppListener());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showShimmeringSkeleton() {
        if (getBinding() == null) {
            return;
        }
        this.isLoading = true;
        FragmentVouchersAndTicketsDetailBinding binding = getBinding();
        Intrinsics.checkNotNull(binding);
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(binding.moveToNextValue);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.voucher_shimmer_loading;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = getVouchersAndTicketsAdapter();
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 5;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        this.skeletonScreen = recyclerViewSkeletonScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideShimmeringSkeleton() {
        this.isLoading = false;
        SkeletonScreen skeletonScreen = this.skeletonScreen;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshVoucherList() {
        List<String> voucherAssetTypes;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        NewWalletFragment walletFragment = getWalletFragment(parentFragmentManager);
        if (walletFragment != null) {
            VouchersAndTicketsDetailContract.Presenter vouchersAndTicketsDetailPresenter = getVouchersAndTicketsDetailPresenter();
            String assetOrder = walletFragment.getAssetOrder();
            if (assetOrder == null) {
                assetOrder = AssetStatus.EXPIRING_SOON.name();
            }
            ArrayList<String> arrayList = this.assetTypes;
            if (arrayList == null || (voucherAssetTypes = CollectionsKt.toList(arrayList)) == null) {
                voucherAssetTypes = WalletAssetType.INSTANCE.getVoucherAssetTypes();
            }
            vouchersAndTicketsDetailPresenter.getVoucherAndTicketAsset(false, true, assetOrder, voucherAssetTypes);
            walletFragment.setLastAddedAssetType(3);
            walletFragment.refreshDataBasedOnLatestAddedAssetType();
        }
    }

    private final void setupLottieBasedOnLanguage(boolean isDefaultIndonesian) {
        LottieAnimationView lottieAnimationView;
        String str = isDefaultIndonesian ? "json/lottie/wallet_close_detail_page_id.lottie" : "json/lottie/wallet_close_detail_page_en.lottie";
        FragmentVouchersAndTicketsDetailBinding binding = getBinding();
        if (binding == null || (lottieAnimationView = binding.MyBillsEntityDataFactory) == null) {
            return;
        }
        lottieAnimationView.setAnimation(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DanaH5Listener createH5AppListener() {
        return new DanaH5Listener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                boolean isSafe;
                ArrayList arrayList;
                List<String> voucherAssetTypes;
                DanaH5.dispose();
                VouchersAndTicketsDetailFragment.this.showShimmeringSkeleton();
                isSafe = VouchersAndTicketsDetailFragment.this.isSafe();
                if (isSafe) {
                    VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment = VouchersAndTicketsDetailFragment.this;
                    FragmentManager parentFragmentManager = vouchersAndTicketsDetailFragment.getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                    NewWalletFragment walletFragment = vouchersAndTicketsDetailFragment.getWalletFragment(parentFragmentManager);
                    if (walletFragment != null) {
                        VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment2 = VouchersAndTicketsDetailFragment.this;
                        VouchersAndTicketsDetailContract.Presenter vouchersAndTicketsDetailPresenter = vouchersAndTicketsDetailFragment2.getVouchersAndTicketsDetailPresenter();
                        String assetOrder = walletFragment.getAssetOrder();
                        if (assetOrder == null) {
                            assetOrder = AssetStatus.EXPIRING_SOON.name();
                        }
                        arrayList = vouchersAndTicketsDetailFragment2.assetTypes;
                        if (arrayList == null || (voucherAssetTypes = CollectionsKt.toList(arrayList)) == null) {
                            voucherAssetTypes = WalletAssetType.INSTANCE.getVoucherAssetTypes();
                        }
                        vouchersAndTicketsDetailPresenter.getVoucherAndTicketAsset(false, true, assetOrder, voucherAssetTypes);
                        walletFragment.setLastAddedAssetType(3);
                        walletFragment.refreshDataBasedOnLatestAddedAssetType();
                        vouchersAndTicketsDetailFragment2.fromVoucherDetail = true;
                    }
                }
            }
        };
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JA\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010"}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/view/VouchersAndTicketsDetailFragment$Companion;", "", "", "Lid/dana/wallet_v3/model/WalletV3CardModel;", FirebaseAnalytics.Param.ITEMS, "", "hasMoreVoucherAndTicket", "isNeedResetPaginantion", "", "assetTypes", "", "danaDealsVersion", "Lid/dana/wallet_v3/vouchersandtickets/view/VouchersAndTicketsDetailFragment;", "newInstance", "(Ljava/util/List;ZZLjava/util/List;I)Lid/dana/wallet_v3/vouchersandtickets/view/VouchersAndTicketsDetailFragment;", VouchersAndTicketsDetailFragment.HAS_MORE_VOUCHER_AND_TICKET, "Ljava/lang/String;", VouchersAndTicketsDetailFragment.IS_NEED_RESET_PAGINATION, "VOUCHES_AND_TICKET_ITEMS", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VouchersAndTicketsDetailFragment newInstance(List<? extends WalletV3CardModel> items, boolean hasMoreVoucherAndTicket, boolean isNeedResetPaginantion, List<String> assetTypes, int danaDealsVersion) {
            Intrinsics.checkNotNullParameter(items, "");
            Intrinsics.checkNotNullParameter(assetTypes, "");
            Bundle bundle = new Bundle();
            Object[] array = items.toArray(new WalletV3CardModel[0]);
            if (array != null) {
                bundle.putParcelableArray(VouchersAndTicketsDetailFragment.VOUCHES_AND_TICKET_ITEMS, (Parcelable[]) array);
                bundle.putBoolean(VouchersAndTicketsDetailFragment.IS_NEED_RESET_PAGINATION, isNeedResetPaginantion);
                bundle.putBoolean(VouchersAndTicketsDetailFragment.HAS_MORE_VOUCHER_AND_TICKET, hasMoreVoucherAndTicket);
                bundle.putStringArrayList(WalletConstant.ASSET_TYPES, new ArrayList<>(CollectionsKt.toMutableList((Collection) assetTypes)));
                bundle.putInt(WalletConstant.DANA_DEALS_VERSION, danaDealsVersion);
                VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment = new VouchersAndTicketsDetailFragment();
                vouchersAndTicketsDetailFragment.setArguments(bundle);
                return vouchersAndTicketsDetailFragment;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }
}
