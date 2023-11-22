package id.dana.wallet_v3.loyalty.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.OnBackPressedCallback;
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
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.DanaH5;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.FragmentLoyaltyDetailWalletBinding;
import id.dana.databinding.ViewWalletV3SearchStubBinding;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.utils.TagFormat;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.wallet_v3.WalletDetailBaseImplementation;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.factory.WalletIntentFactory;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.listener.WalletDetailBaseFunction;
import id.dana.wallet_v3.loyalty.adapter.LoyaltyWalletAdapter;
import id.dana.wallet_v3.loyalty.di.DaggerLoyaltyWalletDetailComponent;
import id.dana.wallet_v3.loyalty.di.LoyaltyWalletDetailModule;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract;
import id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$ptrCardLoyaltyHandle$2;
import id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$walletCardAssetClickListener$2;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.view.NewWalletFragment;
import id.dana.wallet_v3.view.ptr.PtrWalletFrameLayout;
import id.dana.wallet_v3.view.search.adapter.WalletVerticalSpaceItemDecoration;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 h2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001hB\u0007¢\u0006\u0004\bg\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u0012J\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u0012J\u000f\u0010\u001d\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001d\u0010\u0012J\u000f\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u0012J\u000f\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010\u0012J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b#\u0010$J\u0018\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H\u0096\u0001¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u0012J\r\u0010+\u001a\u00020\b¢\u0006\u0004\b+\u0010\u0012J\u000f\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b,\u0010\u0012J\u000f\u0010-\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010\u0012J\u000f\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010\u0012J\u0019\u00100\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020'H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u0010\u0012J\u000f\u00106\u001a\u00020\bH\u0002¢\u0006\u0004\b6\u0010\u0012R\u0018\u00107\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010>\u001a\u0002098CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010@R\u0016\u0010B\u001a\u00020'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u00108R\"\u0010E\u001a\u00020D8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001b\u0010O\u001a\u00020K8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bL\u0010;\u001a\u0004\bM\u0010NR\u0014\u0010Q\u001a\u00020P8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010/\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00108R\u001b\u0010W\u001a\u00020S8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bT\u0010;\u001a\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u001b\u0010_\u001a\u00020[8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010;\u001a\u0004\b]\u0010^R\"\u0010a\u001a\u00020`8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f"}, d2 = {"Lid/dana/wallet_v3/loyalty/view/LoyaltyWalletDetailFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentLoyaltyDetailWalletBinding;", "Lid/dana/wallet_v3/listener/WalletDetailBaseFunction;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "tag", "", "backFromSearch", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", HomeTabActivity.WALLET_SECTION, "backToMainPage", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/fragment/app/FragmentManager;I)V", "disableSwipe", "()V", "getLayout", "()I", "Lid/dana/wallet_v3/loyalty/di/LoyaltyWalletDetailModule;", "getLoyaltyWalletDetailModule", "()Lid/dana/wallet_v3/loyalty/di/LoyaltyWalletDetailModule;", "Lid/dana/wallet_v3/view/NewWalletFragment;", "getWalletFragment", "(Landroidx/fragment/app/FragmentManager;)Lid/dana/wallet_v3/view/NewWalletFragment;", "hideLoadingLoyalty", "hideShimmeringSkeleton", IAPSyncCommand.COMMAND_INIT, "initInjector", "initOnClickListener", "initView", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/FragmentLoyaltyDetailWalletBinding;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "isFromDeeplinkWallet", "(Landroid/app/Activity;)Z", "navigateToSearch", "onCollapseFromSearch", "onDestroyView", "onStart", "openAddLoyaltyCard", "pocketId", "openLoyaltyDetailH5", "(Ljava/lang/String;)V", "isDefaultIndonesian", "setupLottieBasedOnLanguage", "(Z)V", "showLoadingLoyalty", "showShimmeringSkeleton", "accessToken", "Ljava/lang/String;", "Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog$delegate", "Lkotlin/Lazy;", "getDanaLoadingDialog", "()Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog", "hasMore", "Z", GriverMonitorConstants.KEY_IS_LOADING, "isOpenDetail", WalletConstant.KYC_LEVEL, "Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;", "loyaltyPresenter", "Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;", "getLoyaltyPresenter", "()Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;", "setLoyaltyPresenter", "(Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;)V", "Lid/dana/wallet_v3/loyalty/adapter/LoyaltyWalletAdapter;", "loyaltyWalletAdapter$delegate", "getLoyaltyWalletAdapter", "()Lid/dana/wallet_v3/loyalty/adapter/LoyaltyWalletAdapter;", "loyaltyWalletAdapter", "Lid/dana/wallet_v3/loyalty/view/LoyaltyWalletDetailFragment$onBackPressedCallback$1;", "onBackPressedCallback", "Lid/dana/wallet_v3/loyalty/view/LoyaltyWalletDetailFragment$onBackPressedCallback$1;", "Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardLoyaltyHandle$delegate", "getPtrCardLoyaltyHandle", "()Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardLoyaltyHandle", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonScreen", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener$delegate", "getWalletCardAssetClickListener", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "walletV3TrackerImplementation", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "getWalletV3TrackerImplementation", "()Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "setWalletV3TrackerImplementation", "(Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoyaltyWalletDetailFragment extends ViewBindingFragment<FragmentLoyaltyDetailWalletBinding> implements WalletDetailBaseFunction {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOYALTY_CARD_ITEMS = "LOYALTY_CARD_ITEMS";
    private String accessToken;
    private boolean isLoading;
    private boolean isOpenDetail;
    private String kycLevel;
    @Inject
    public LoyaltyWalletContract.Presenter loyaltyPresenter;
    private String pocketId;
    private SkeletonScreen skeletonScreen;
    @Inject
    public WalletV3TrackerImpl walletV3TrackerImplementation;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final /* synthetic */ WalletDetailBaseImplementation $$delegate_0 = new WalletDetailBaseImplementation();

    /* renamed from: loyaltyWalletAdapter$delegate  reason: from kotlin metadata */
    private final Lazy loyaltyWalletAdapter = LazyKt.lazy(new Function0<LoyaltyWalletAdapter>() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$loyaltyWalletAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LoyaltyWalletAdapter invoke() {
            WalletCardAssetClickListener walletCardAssetClickListener;
            walletCardAssetClickListener = LoyaltyWalletDetailFragment.this.getWalletCardAssetClickListener();
            return new LoyaltyWalletAdapter(walletCardAssetClickListener);
        }
    });

    /* renamed from: danaLoadingDialog$delegate  reason: from kotlin metadata */
    private final Lazy danaLoadingDialog = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(LoyaltyWalletDetailFragment.this.getActivity());
        }
    });

    /* renamed from: walletCardAssetClickListener$delegate  reason: from kotlin metadata */
    private final Lazy walletCardAssetClickListener = LazyKt.lazy(new Function0<LoyaltyWalletDetailFragment$walletCardAssetClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$walletCardAssetClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$walletCardAssetClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final LoyaltyWalletDetailFragment loyaltyWalletDetailFragment = LoyaltyWalletDetailFragment.this;
            return new WalletCardAssetClickListener() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$walletCardAssetClickListener$2.1
                /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
                /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
                /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
                /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
                @Override // id.dana.wallet_v3.listener.WalletCardAssetClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void onCardClicked(id.dana.wallet_v3.model.WalletV3CardModel r5) {
                    /*
                        r4 = this;
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.this
                        java.lang.String r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.access$getAccessToken$p(r0)
                        r1 = 0
                        r2 = 1
                        if (r0 == 0) goto L1e
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                        int r0 = r0.length()
                        if (r0 <= 0) goto L19
                        r0 = 1
                        goto L1a
                    L19:
                        r0 = 0
                    L1a:
                        if (r0 != r2) goto L1e
                        r0 = 1
                        goto L1f
                    L1e:
                        r0 = 0
                    L1f:
                        if (r0 == 0) goto L8a
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.this
                        java.lang.String r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.access$getKycLevel$p(r0)
                        if (r0 == 0) goto L37
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                        int r0 = r0.length()
                        if (r0 <= 0) goto L33
                        r0 = 1
                        goto L34
                    L33:
                        r0 = 0
                    L34:
                        if (r0 != r2) goto L37
                        r1 = 1
                    L37:
                        if (r1 == 0) goto L8a
                        boolean r0 = r5 instanceof id.dana.wallet_v3.model.LoyaltyCardModel
                        if (r0 == 0) goto L8a
                        int r0 = r5.getViewType()
                        r1 = 3
                        if (r0 != r1) goto L47
                        java.lang.String r0 = "/create-card?entry-point=cardList&loyaltyToken={token}&infoSnapModal=&kycLevel={kycLevel}"
                        goto L49
                    L47:
                        java.lang.String r0 = "/card-detail/{id}?loyaltyToken={token}&infoSnapModal=&kycLevel={kycLevel}"
                    L49:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "https://web-loyalty.dana.id"
                        r1.append(r2)
                        id.dana.utils.TagFormat r0 = id.dana.utils.TagFormat.MyBillsEntityDataFactory(r0)
                        id.dana.wallet_v3.model.LoyaltyCardModel r5 = (id.dana.wallet_v3.model.LoyaltyCardModel) r5
                        java.lang.String r5 = r5.getPocketId()
                        java.lang.String r2 = "id"
                        id.dana.utils.TagFormat r5 = r0.PlaceComponentResult(r2, r5)
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.this
                        java.lang.String r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.access$getAccessToken$p(r0)
                        java.lang.String r2 = "token"
                        id.dana.utils.TagFormat r5 = r5.PlaceComponentResult(r2, r0)
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.this
                        java.lang.String r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.access$getKycLevel$p(r0)
                        java.lang.String r2 = "kycLevel"
                        id.dana.utils.TagFormat r5 = r5.PlaceComponentResult(r2, r0)
                        java.lang.String r5 = r5.MyBillsEntityDataFactory()
                        r1.append(r5)
                        java.lang.String r5 = r1.toString()
                        id.dana.danah5.DanaH5.startContainerFullUrl(r5)
                        return
                    L8a:
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.this
                        id.dana.dialog.DanaLoadingDialog r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.access$getDanaLoadingDialog(r0)
                        android.app.Dialog r1 = r0.MyBillsEntityDataFactory
                        boolean r1 = r1.isShowing()
                        if (r1 != 0) goto La2
                        android.app.Dialog r1 = r0.MyBillsEntityDataFactory
                        r1.show()
                        id.dana.richview.LogoProgressView r0 = r0.getAuthRequestContext
                        r0.startRefresh()
                    La2:
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.this
                        id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract$Presenter r0 = r0.getLoyaltyPresenter()
                        r0.fetchLoyaltyAccessTokenAndKycLevel()
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment r0 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.this
                        boolean r1 = r5 instanceof id.dana.wallet_v3.model.LoyaltyCardModel
                        r3 = 0
                        if (r1 == 0) goto Lb5
                        id.dana.wallet_v3.model.LoyaltyCardModel r5 = (id.dana.wallet_v3.model.LoyaltyCardModel) r5
                        goto Lb6
                    Lb5:
                        r5 = r3
                    Lb6:
                        if (r5 == 0) goto Lbc
                        java.lang.String r3 = r5.getPocketId()
                    Lbc:
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.access$setPocketId$p(r0, r3)
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment r5 = id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.this
                        id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.access$setOpenDetail$p(r5, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$walletCardAssetClickListener$2.AnonymousClass1.onCardClicked(id.dana.wallet_v3.model.WalletV3CardModel):void");
                }
            };
        }
    });

    /* renamed from: ptrCardLoyaltyHandle$delegate  reason: from kotlin metadata */
    private final Lazy ptrCardLoyaltyHandle = LazyKt.lazy(new Function0<LoyaltyWalletDetailFragment$ptrCardLoyaltyHandle$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$ptrCardLoyaltyHandle$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$ptrCardLoyaltyHandle$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final LoyaltyWalletDetailFragment loyaltyWalletDetailFragment = LoyaltyWalletDetailFragment.this;
            return new PtrHandler() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$ptrCardLoyaltyHandle$2.1
                @Override // in.srain.cube.views.ptr.PtrHandler
                public final boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                    FragmentLoyaltyDetailWalletBinding binding;
                    RecyclerView recyclerView;
                    binding = LoyaltyWalletDetailFragment.this.getBinding();
                    RecyclerView.LayoutManager layoutManager = (binding == null || (recyclerView = binding.moveToNextValue) == null) ? null : recyclerView.getLayoutManager();
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? layoutManager : null;
                    return (linearLayoutManager != null ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : -1) == 0;
                }

                @Override // in.srain.cube.views.ptr.PtrHandler
                public final void onRefreshBegin(PtrFrameLayout frame) {
                    FragmentLoyaltyDetailWalletBinding binding;
                    PtrWalletFrameLayout ptrWalletFrameLayout;
                    LoyaltyWalletDetailFragment.this.navigateToSearch();
                    binding = LoyaltyWalletDetailFragment.this.getBinding();
                    if (binding == null || (ptrWalletFrameLayout = binding.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
                        return;
                    }
                    ptrWalletFrameLayout.refreshComplete();
                }
            };
        }
    });
    private boolean hasMore = true;
    private final LoyaltyWalletDetailFragment$onBackPressedCallback$1 onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$onBackPressedCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(true);
        }

        @Override // androidx.view.OnBackPressedCallback
        public final void handleOnBackPressed() {
            FragmentLoyaltyDetailWalletBinding binding;
            LoyaltyWalletDetailFragment loyaltyWalletDetailFragment = LoyaltyWalletDetailFragment.this;
            binding = loyaltyWalletDetailFragment.getBinding();
            RecyclerView recyclerView = binding != null ? binding.moveToNextValue : null;
            FragmentManager parentFragmentManager = LoyaltyWalletDetailFragment.this.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            loyaltyWalletDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 3);
        }
    };

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
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
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
        return R.layout.fragment_loyalty_detail_wallet;
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

    @JvmName(name = "getLoyaltyPresenter")
    public final LoyaltyWalletContract.Presenter getLoyaltyPresenter() {
        LoyaltyWalletContract.Presenter presenter = this.loyaltyPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setLoyaltyPresenter")
    public final void setLoyaltyPresenter(LoyaltyWalletContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.loyaltyPresenter = presenter;
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

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getLoyaltyWalletAdapter")
    public final LoyaltyWalletAdapter getLoyaltyWalletAdapter() {
        return (LoyaltyWalletAdapter) this.loyaltyWalletAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getDanaLoadingDialog")
    public final DanaLoadingDialog getDanaLoadingDialog() {
        return (DanaLoadingDialog) this.danaLoadingDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getWalletCardAssetClickListener")
    public final WalletCardAssetClickListener getWalletCardAssetClickListener() {
        return (WalletCardAssetClickListener) this.walletCardAssetClickListener.getValue();
    }

    @JvmName(name = "getPtrCardLoyaltyHandle")
    private final PtrHandler getPtrCardLoyaltyHandle() {
        return (PtrHandler) this.ptrCardLoyaltyHandle.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity == null || !isFromDeeplinkWallet(activity)) {
            return;
        }
        FragmentLoyaltyDetailWalletBinding binding = getBinding();
        RecyclerView recyclerView = binding != null ? binding.moveToNextValue : null;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        backToMainPage(recyclerView, parentFragmentManager, 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    @Override // id.dana.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void init() {
        /*
            r3 = this;
            r3.initInjector()
            r3.initView()
            r3.initOnClickListener()
            java.lang.String r0 = r3.accessToken
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            if (r0 != r2) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 == 0) goto L3c
            java.lang.String r0 = r3.kycLevel
            if (r0 == 0) goto L33
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L2f
            r0 = 1
            goto L30
        L2f:
            r0 = 0
        L30:
            if (r0 != r2) goto L33
            r1 = 1
        L33:
            if (r1 == 0) goto L3c
            id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract$Presenter r0 = r3.getLoyaltyPresenter()
            r0.fetchLoyaltyAccessTokenAndKycLevel()
        L3c:
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 == 0) goto L52
            androidx.activity.OnBackPressedDispatcher r0 = r0.getOnBackPressedDispatcher()
            if (r0 == 0) goto L52
            r1 = r3
            androidx.lifecycle.LifecycleOwner r1 = (androidx.view.LifecycleOwner) r1
            id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$onBackPressedCallback$1 r2 = r3.onBackPressedCallback
            androidx.activity.OnBackPressedCallback r2 = (androidx.view.OnBackPressedCallback) r2
            r0.PlaceComponentResult(r1, r2)
        L52:
            r3.disableSwipe()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment.init():void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        setEnabled(false);
        remove();
        _$_clearFindViewByIdCache();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final FragmentLoyaltyDetailWalletBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentLoyaltyDetailWalletBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentLoyaltyDetailWalletBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private final void initInjector() {
        DaggerLoyaltyWalletDetailComponent.builder().applicationComponent(getApplicationComponent()).loyaltyWalletDetailModule(getLoyaltyWalletDetailModule()).build().inject(this);
    }

    public final void onCollapseFromSearch() {
        MotionLayout motionLayout;
        MotionLayout motionLayout2;
        FragmentLoyaltyDetailWalletBinding binding = getBinding();
        if (binding != null && (motionLayout2 = binding.MyBillsEntityDataFactory) != null) {
            motionLayout2.setTransition(R.id.collapse_from_search);
        }
        FragmentLoyaltyDetailWalletBinding binding2 = getBinding();
        if (binding2 == null || (motionLayout = binding2.MyBillsEntityDataFactory) == null) {
            return;
        }
        motionLayout.transitionToEnd();
    }

    private final LoyaltyWalletDetailModule getLoyaltyWalletDetailModule() {
        return new LoyaltyWalletDetailModule(new LoyaltyWalletContract.View() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$getLoyaltyWalletDetailModule$1
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

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onErrorGetLoyaltyAsset() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onGetLoyaltyAccessToken(String token) {
                boolean z;
                String str;
                String str2;
                LoyaltyWalletDetailFragment.this.accessToken = token;
                z = LoyaltyWalletDetailFragment.this.isOpenDetail;
                if (z) {
                    str = LoyaltyWalletDetailFragment.this.kycLevel;
                    boolean z2 = false;
                    if (str != null) {
                        if (str.length() > 0) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        LoyaltyWalletDetailFragment loyaltyWalletDetailFragment = LoyaltyWalletDetailFragment.this;
                        str2 = loyaltyWalletDetailFragment.pocketId;
                        loyaltyWalletDetailFragment.openLoyaltyDetailH5(str2);
                    }
                }
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onGetKycLevel(String kycLevel) {
                boolean z;
                String str;
                String str2;
                LoyaltyWalletDetailFragment.this.kycLevel = kycLevel;
                z = LoyaltyWalletDetailFragment.this.isOpenDetail;
                if (z) {
                    str = LoyaltyWalletDetailFragment.this.accessToken;
                    boolean z2 = false;
                    if (str != null) {
                        if (str.length() > 0) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        LoyaltyWalletDetailFragment loyaltyWalletDetailFragment = LoyaltyWalletDetailFragment.this;
                        str2 = loyaltyWalletDetailFragment.pocketId;
                        loyaltyWalletDetailFragment.openLoyaltyDetailH5(str2);
                    }
                }
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onErrorGetLoyaltyAccessToken() {
                DanaLoadingDialog danaLoadingDialog;
                LoyaltyWalletDetailFragment.this.isOpenDetail = false;
                danaLoadingDialog = LoyaltyWalletDetailFragment.this.getDanaLoadingDialog();
                danaLoadingDialog.PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onErrorKycLevel() {
                DanaLoadingDialog danaLoadingDialog;
                LoyaltyWalletDetailFragment.this.isOpenDetail = false;
                danaLoadingDialog = LoyaltyWalletDetailFragment.this.getDanaLoadingDialog();
                danaLoadingDialog.PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onLoadingGetLoyaltyAsset() {
                LoyaltyWalletDetailFragment.this.showLoadingLoyalty();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onDismissLoadingGetLoyaltyAsset() {
                LoyaltyWalletDetailFragment.this.hideLoadingLoyalty();
            }

            @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.View
            public final void onSuccessGetLoyaltyAsset(NewPocketQueryListModel<LoyaltyCardModel> assets, int pageNumber) {
                LoyaltyWalletAdapter loyaltyWalletAdapter;
                LoyaltyWalletAdapter loyaltyWalletAdapter2;
                Intrinsics.checkNotNullParameter(assets, "");
                LoyaltyWalletDetailFragment.this.hideShimmeringSkeleton();
                if (pageNumber == 1) {
                    loyaltyWalletAdapter2 = LoyaltyWalletDetailFragment.this.getLoyaltyWalletAdapter();
                    loyaltyWalletAdapter2.removeAllItems();
                }
                loyaltyWalletAdapter = LoyaltyWalletDetailFragment.this.getLoyaltyWalletAdapter();
                loyaltyWalletAdapter.appendItems(assets.getPockets());
                LoyaltyWalletDetailFragment.this.hasMore = assets.getHasMore();
            }
        });
    }

    private final void initView() {
        ArrayList arrayList;
        PtrWalletFrameLayout ptrWalletFrameLayout;
        Parcelable[] parcelableArray;
        List list;
        ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding;
        ConstraintLayout constraintLayout;
        ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        FragmentLoyaltyDetailWalletBinding binding = getBinding();
        if (binding != null && (recyclerView2 = binding.moveToNextValue) != null) {
            recyclerView2.setItemAnimator(null);
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
            recyclerView2.setAdapter(getLoyaltyWalletAdapter());
            recyclerView2.setNestedScrollingEnabled(false);
            recyclerView2.addItemDecoration(new WalletVerticalSpaceItemDecoration());
        }
        FragmentLoyaltyDetailWalletBinding binding2 = getBinding();
        if (binding2 != null && (recyclerView = binding2.moveToNextValue) != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$initView$2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView recyclerView3, int dx, int dy) {
                    boolean z;
                    boolean z2;
                    Intrinsics.checkNotNullParameter(recyclerView3, "");
                    if (recyclerView3.canScrollVertically(1)) {
                        return;
                    }
                    z = LoyaltyWalletDetailFragment.this.hasMore;
                    if (z) {
                        z2 = LoyaltyWalletDetailFragment.this.isLoading;
                        if (z2) {
                            return;
                        }
                        LoyaltyWalletDetailFragment.this.getLoyaltyPresenter().getLoyaltyCardAssets(false);
                    }
                }
            });
        }
        FragmentLoyaltyDetailWalletBinding binding3 = getBinding();
        AppCompatTextView appCompatTextView = (binding3 == null || (viewWalletV3SearchStubBinding2 = binding3.scheduleImpl) == null) ? null : viewWalletV3SearchStubBinding2.PlaceComponentResult;
        if (appCompatTextView != null) {
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R.string.wallet_search_bar_hint_loyalty) : null);
        }
        FragmentLoyaltyDetailWalletBinding binding4 = getBinding();
        if (binding4 != null && (viewWalletV3SearchStubBinding = binding4.scheduleImpl) != null && (constraintLayout = viewWalletV3SearchStubBinding.BuiltInFictitiousFunctionClassFactory) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoyaltyWalletDetailFragment.m3022initView$lambda2(LoyaltyWalletDetailFragment.this, view);
                }
            });
        }
        LoyaltyWalletAdapter loyaltyWalletAdapter = getLoyaltyWalletAdapter();
        Bundle arguments = getArguments();
        if (arguments == null || (parcelableArray = arguments.getParcelableArray(LOYALTY_CARD_ITEMS)) == null || (list = ArraysKt.toList(parcelableArray)) == null) {
            arrayList = null;
        } else {
            List<Parcelable> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Parcelable parcelable : list2) {
                arrayList2.add(parcelable instanceof LoyaltyCardModel ? (LoyaltyCardModel) parcelable : null);
            }
            arrayList = arrayList2;
        }
        loyaltyWalletAdapter.setItems(arrayList);
        Bundle arguments2 = getArguments();
        this.accessToken = arguments2 != null ? arguments2.getString(WalletConstant.ACCESS_TOKEN) : null;
        Bundle arguments3 = getArguments();
        this.kycLevel = arguments3 != null ? arguments3.getString(WalletConstant.KYC_LEVEL_BUNDLE) : null;
        FragmentLoyaltyDetailWalletBinding binding5 = getBinding();
        if (binding5 != null && (ptrWalletFrameLayout = binding5.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            ptrWalletFrameLayout.setPtrHandler(getPtrCardLoyaltyHandle());
        }
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        setupLottieBasedOnLanguage(LocaleUtil.PlaceComponentResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m3022initView$lambda2(LoyaltyWalletDetailFragment loyaltyWalletDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(loyaltyWalletDetailFragment, "");
        loyaltyWalletDetailFragment.navigateToSearch();
    }

    private final void initOnClickListener() {
        DanaButtonPrimaryView danaButtonPrimaryView;
        LottieAnimationView lottieAnimationView;
        FragmentLoyaltyDetailWalletBinding binding = getBinding();
        if (binding != null && (lottieAnimationView = binding.BuiltInFictitiousFunctionClassFactory) != null) {
            lottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoyaltyWalletDetailFragment.m3020initOnClickListener$lambda4(LoyaltyWalletDetailFragment.this, view);
                }
            });
        }
        FragmentLoyaltyDetailWalletBinding binding2 = getBinding();
        if (binding2 == null || (danaButtonPrimaryView = binding2.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoyaltyWalletDetailFragment.m3021initOnClickListener$lambda5(LoyaltyWalletDetailFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-4  reason: not valid java name */
    public static final void m3020initOnClickListener$lambda4(LoyaltyWalletDetailFragment loyaltyWalletDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(loyaltyWalletDetailFragment, "");
        FragmentLoyaltyDetailWalletBinding binding = loyaltyWalletDetailFragment.getBinding();
        RecyclerView recyclerView = binding != null ? binding.moveToNextValue : null;
        FragmentManager parentFragmentManager = loyaltyWalletDetailFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        loyaltyWalletDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-5  reason: not valid java name */
    public static final void m3021initOnClickListener$lambda5(LoyaltyWalletDetailFragment loyaltyWalletDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(loyaltyWalletDetailFragment, "");
        loyaltyWalletDetailFragment.getWalletV3TrackerImplementation().trackOpenAddAsset(TrackerKey.WalletAddAssetSource.ADD_LOYALTY_SECTION);
        loyaltyWalletDetailFragment.openAddLoyaltyCard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToSearch() {
        MotionLayout motionLayout;
        MotionLayout motionLayout2;
        FragmentLoyaltyDetailWalletBinding binding = getBinding();
        if (binding != null && (motionLayout2 = binding.MyBillsEntityDataFactory) != null) {
            motionLayout2.setTransition(R.id.expand_to_search);
        }
        FragmentLoyaltyDetailWalletBinding binding2 = getBinding();
        if (binding2 == null || (motionLayout = binding2.MyBillsEntityDataFactory) == null) {
            return;
        }
        motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LoyaltyWalletDetailFragment.m3023navigateToSearch$lambda6(LoyaltyWalletDetailFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: navigateToSearch$lambda-6  reason: not valid java name */
    public static final void m3023navigateToSearch$lambda6(LoyaltyWalletDetailFragment loyaltyWalletDetailFragment) {
        Intrinsics.checkNotNullParameter(loyaltyWalletDetailFragment, "");
        WalletIntentFactory walletIntentFactory = WalletIntentFactory.INSTANCE;
        LoyaltyWalletDetailFragment loyaltyWalletDetailFragment2 = loyaltyWalletDetailFragment;
        WalletSearchFragment.Companion companion = WalletSearchFragment.INSTANCE;
        Context context = loyaltyWalletDetailFragment.getContext();
        walletIntentFactory.openNewFragmentWithAnimation(loyaltyWalletDetailFragment2, WalletSearchFragment.Companion.newInstance$default(companion, "loyalty", context != null ? context.getString(R.string.wallet_search_bar_hint_loyalty) : null, null, null, 12, null));
    }

    private final void openAddLoyaltyCard() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://web-loyalty.dana.id");
        sb.append(TagFormat.MyBillsEntityDataFactory(DanaUrl.CREATE_LOYALTY).PlaceComponentResult("token", this.accessToken).PlaceComponentResult(WalletConstant.KYC_LEVEL, this.kycLevel).MyBillsEntityDataFactory());
        DanaH5.startContainerFullUrl(sb.toString(), new DanaH5Listener() { // from class: id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment$openAddLoyaltyCard$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                LoyaltyWalletDetailFragment.this.showShimmeringSkeleton();
                LoyaltyWalletDetailFragment.this.getLoyaltyPresenter().getLoyaltyCardAssets(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingLoyalty() {
        this.isLoading = true;
        getLoyaltyWalletAdapter().showLoadingViewOnTheLastItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoadingLoyalty() {
        this.isLoading = false;
        getLoyaltyWalletAdapter().hideLoadingView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openLoyaltyDetailH5(String pocketId) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://web-loyalty.dana.id");
        TagFormat MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory(DanaUrl.LOYALTY_DETAIL);
        if (pocketId == null) {
            pocketId = "";
        }
        sb.append(MyBillsEntityDataFactory.PlaceComponentResult("id", pocketId).PlaceComponentResult("token", this.accessToken).PlaceComponentResult(WalletConstant.KYC_LEVEL, this.kycLevel).MyBillsEntityDataFactory());
        DanaH5.startContainerFullUrl(sb.toString());
        this.isOpenDetail = false;
        getDanaLoadingDialog().PlaceComponentResult();
    }

    private final void disableSwipe() {
        FragmentActivity activity = getActivity();
        HomeTabActivity homeTabActivity = activity instanceof HomeTabActivity ? (HomeTabActivity) activity : null;
        if (homeTabActivity != null) {
            homeTabActivity.setSwipeable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showShimmeringSkeleton() {
        this.isLoading = true;
        FragmentLoyaltyDetailWalletBinding binding = getBinding();
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(binding != null ? binding.moveToNextValue : null);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_wallet_detail_skeleton;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = getLoyaltyWalletAdapter();
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

    private final void setupLottieBasedOnLanguage(boolean isDefaultIndonesian) {
        LottieAnimationView lottieAnimationView;
        String str = isDefaultIndonesian ? "json/lottie/wallet_close_detail_page_id.lottie" : "json/lottie/wallet_close_detail_page_en.lottie";
        FragmentLoyaltyDetailWalletBinding binding = getBinding();
        if (binding == null || (lottieAnimationView = binding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        lottieAnimationView.setAnimation(str);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/wallet_v3/loyalty/view/LoyaltyWalletDetailFragment$Companion;", "", "", "Lid/dana/wallet_v3/model/WalletV3CardModel;", FirebaseAnalytics.Param.ITEMS, "", WalletConstant.KYC_LEVEL, "accessToken", "Lid/dana/wallet_v3/loyalty/view/LoyaltyWalletDetailFragment;", "newInstance", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lid/dana/wallet_v3/loyalty/view/LoyaltyWalletDetailFragment;", LoyaltyWalletDetailFragment.LOYALTY_CARD_ITEMS, "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoyaltyWalletDetailFragment newInstance(List<? extends WalletV3CardModel> items, String kycLevel, String accessToken) {
            Intrinsics.checkNotNullParameter(items, "");
            Bundle bundle = new Bundle();
            Object[] array = items.toArray(new WalletV3CardModel[0]);
            if (array != null) {
                bundle.putParcelableArray(LoyaltyWalletDetailFragment.LOYALTY_CARD_ITEMS, (Parcelable[]) array);
                bundle.putString(WalletConstant.KYC_LEVEL_BUNDLE, kycLevel);
                bundle.putString(WalletConstant.ACCESS_TOKEN, accessToken);
                LoyaltyWalletDetailFragment loyaltyWalletDetailFragment = new LoyaltyWalletDetailFragment();
                loyaltyWalletDetailFragment.setArguments(bundle);
                return loyaltyWalletDetailFragment;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }
}
