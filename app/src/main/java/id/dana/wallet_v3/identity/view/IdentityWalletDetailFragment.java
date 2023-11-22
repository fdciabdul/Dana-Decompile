package id.dana.wallet_v3.identity.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
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
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
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
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.challenge.ChallengeControl;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.util.DANAToast;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.FragmentIdentityDetailWalletBinding;
import id.dana.databinding.ViewWalletV3SearchStubBinding;
import id.dana.pocket.model.PocketQueryListModel;
import id.dana.wallet.personal.PersonalContract;
import id.dana.wallet_v3.WalletDetailBaseImplementation;
import id.dana.wallet_v3.di.module.PersonalModule;
import id.dana.wallet_v3.factory.WalletIntentFactory;
import id.dana.wallet_v3.identity.IdentityToastAndDialogImpl;
import id.dana.wallet_v3.identity.adapter.IdentityWalletAdapter;
import id.dana.wallet_v3.identity.di.DaggerIdentityWalletDetailComponent;
import id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$ptrCardIdentityHandle$2;
import id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$walletCardAssetClickListener$2;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.listener.WalletDetailBaseFunction;
import id.dana.wallet_v3.model.IdentityCardModel;
import id.dana.wallet_v3.model.InsuranceAssetModel;
import id.dana.wallet_v3.model.KtpInfoModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.tracker.WalletV3TrackerImpl;
import id.dana.wallet_v3.view.NewWalletFragment;
import id.dana.wallet_v3.view.ptr.PtrWalletFrameLayout;
import id.dana.wallet_v3.view.search.adapter.WalletVerticalSpaceItemDecoration;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
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

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001mB\u0007¢\u0006\u0004\bl\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u0012J\u000f\u0010\u001c\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001c\u0010\u0012J\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u0012J\u000f\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u0012J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J\u0018\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0096\u0001¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\u0012J)\u0010.\u001a\u00020\b2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\b¢\u0006\u0004\b0\u0010\u0012J\r\u00101\u001a\u00020\b¢\u0006\u0004\b1\u0010\u0012J\u000f\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u0010\u0012J\u000f\u00103\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u0010\u0012J\u000f\u00104\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u0010\u0012J\u000f\u00105\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u0010\u0012J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020&H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\bH\u0002¢\u0006\u0004\b9\u0010\u0012R\"\u0010;\u001a\u00020:8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020A8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001b\u0010\\\u001a\u00020X8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bY\u0010C\u001a\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u001b\u0010d\u001a\u00020`8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\ba\u0010C\u001a\u0004\bb\u0010cR\"\u0010f\u001a\u00020e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k"}, d2 = {"Lid/dana/wallet_v3/identity/view/IdentityWalletDetailFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentIdentityDetailWalletBinding;", "Lid/dana/wallet_v3/listener/WalletDetailBaseFunction;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "tag", "", "backFromSearch", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", HomeTabActivity.WALLET_SECTION, "backToMainPage", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/fragment/app/FragmentManager;I)V", "disableSwipe", "()V", "getLayout", "()I", "Lid/dana/wallet_v3/di/module/PersonalModule;", "getPersonalModule", "()Lid/dana/wallet_v3/di/module/PersonalModule;", "Lid/dana/wallet_v3/view/NewWalletFragment;", "getWalletFragment", "(Landroidx/fragment/app/FragmentManager;)Lid/dana/wallet_v3/view/NewWalletFragment;", "hideShimmeringSkeleton", IAPSyncCommand.COMMAND_INIT, "initInjector", "initOnClickListener", "initView", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/FragmentIdentityDetailWalletBinding;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "isFromDeeplinkWallet", "(Landroid/app/Activity;)Z", "navigateToSearch", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onAddKtpAsset", "onCollapseFromSearch", "onDestroyView", "onStart", "setLastAddedAssetType", "setViewSuccessSaveKtp", "isDefaultIndonesian", "setupLottieBasedOnLanguage", "(Z)V", "showShimmeringSkeleton", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lid/dana/wallet_v3/identity/IdentityToastAndDialogImpl;", "identityToastAndDialog$delegate", "Lkotlin/Lazy;", "getIdentityToastAndDialog", "()Lid/dana/wallet_v3/identity/IdentityToastAndDialogImpl;", "identityToastAndDialog", "Lid/dana/wallet_v3/identity/adapter/IdentityWalletAdapter;", "identityWalletAdapter$delegate", "getIdentityWalletAdapter", "()Lid/dana/wallet_v3/identity/adapter/IdentityWalletAdapter;", "identityWalletAdapter", GriverMonitorConstants.KEY_IS_LOADING, "Z", "Lid/dana/wallet_v3/identity/view/IdentityWalletDetailFragment$onBackPressedCallback$1;", "onBackPressedCallback", "Lid/dana/wallet_v3/identity/view/IdentityWalletDetailFragment$onBackPressedCallback$1;", "Lid/dana/wallet/personal/PersonalContract$Presenter;", "personalPresenter", "Lid/dana/wallet/personal/PersonalContract$Presenter;", "getPersonalPresenter", "()Lid/dana/wallet/personal/PersonalContract$Presenter;", "setPersonalPresenter", "(Lid/dana/wallet/personal/PersonalContract$Presenter;)V", "Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardIdentityHandle$delegate", "getPtrCardIdentityHandle", "()Lin/srain/cube/views/ptr/PtrHandler;", "ptrCardIdentityHandle", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonScreen", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener$delegate", "getWalletCardAssetClickListener", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "walletV3TrackerImplementation", "Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "getWalletV3TrackerImplementation", "()Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "setWalletV3TrackerImplementation", "(Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IdentityWalletDetailFragment extends ViewBindingFragment<FragmentIdentityDetailWalletBinding> implements WalletDetailBaseFunction {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String IDENTITY_CARD_ITEMS = "IDENTITY_CARD_ITEMS";
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    private boolean isLoading;
    @Inject
    public PersonalContract.Presenter personalPresenter;
    private SkeletonScreen skeletonScreen;
    @Inject
    public WalletV3TrackerImpl walletV3TrackerImplementation;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final /* synthetic */ WalletDetailBaseImplementation $$delegate_0 = new WalletDetailBaseImplementation();

    /* renamed from: identityToastAndDialog$delegate  reason: from kotlin metadata */
    private final Lazy identityToastAndDialog = LazyKt.lazy(new Function0<IdentityToastAndDialogImpl>() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$identityToastAndDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IdentityToastAndDialogImpl invoke() {
            return new IdentityToastAndDialogImpl(IdentityWalletDetailFragment.this);
        }
    });

    /* renamed from: identityWalletAdapter$delegate  reason: from kotlin metadata */
    private final Lazy identityWalletAdapter = LazyKt.lazy(new Function0<IdentityWalletAdapter>() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$identityWalletAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IdentityWalletAdapter invoke() {
            WalletCardAssetClickListener walletCardAssetClickListener;
            walletCardAssetClickListener = IdentityWalletDetailFragment.this.getWalletCardAssetClickListener();
            return new IdentityWalletAdapter(walletCardAssetClickListener);
        }
    });
    private final IdentityWalletDetailFragment$onBackPressedCallback$1 onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$onBackPressedCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(true);
        }

        @Override // androidx.view.OnBackPressedCallback
        public final void handleOnBackPressed() {
            FragmentIdentityDetailWalletBinding binding;
            IdentityWalletDetailFragment identityWalletDetailFragment = IdentityWalletDetailFragment.this;
            binding = identityWalletDetailFragment.getBinding();
            RecyclerView recyclerView = binding != null ? binding.getErrorConfigVersion : null;
            FragmentManager parentFragmentManager = IdentityWalletDetailFragment.this.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            identityWalletDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 4);
        }
    };

    /* renamed from: walletCardAssetClickListener$delegate  reason: from kotlin metadata */
    private final Lazy walletCardAssetClickListener = LazyKt.lazy(new Function0<IdentityWalletDetailFragment$walletCardAssetClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$walletCardAssetClickListener$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$walletCardAssetClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final IdentityWalletDetailFragment identityWalletDetailFragment = IdentityWalletDetailFragment.this;
            return new WalletCardAssetClickListener() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$walletCardAssetClickListener$2.1
                @Override // id.dana.wallet_v3.listener.WalletCardAssetClickListener
                public final void onCardClicked(WalletV3CardModel data) {
                    IdentityToastAndDialogImpl identityToastAndDialog;
                    Intrinsics.checkNotNullParameter(data, "");
                    if (data.getViewType() == 14) {
                        identityToastAndDialog = IdentityWalletDetailFragment.this.getIdentityToastAndDialog();
                        identityToastAndDialog.openPinChallenge();
                        return;
                    }
                    IdentityWalletDetailFragment.this.onAddKtpAsset();
                }
            };
        }
    });

    /* renamed from: ptrCardIdentityHandle$delegate  reason: from kotlin metadata */
    private final Lazy ptrCardIdentityHandle = LazyKt.lazy(new Function0<IdentityWalletDetailFragment$ptrCardIdentityHandle$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$ptrCardIdentityHandle$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$ptrCardIdentityHandle$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final IdentityWalletDetailFragment identityWalletDetailFragment = IdentityWalletDetailFragment.this;
            return new PtrHandler() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$ptrCardIdentityHandle$2.1
                @Override // in.srain.cube.views.ptr.PtrHandler
                public final boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                    FragmentIdentityDetailWalletBinding binding;
                    RecyclerView recyclerView;
                    binding = IdentityWalletDetailFragment.this.getBinding();
                    RecyclerView.LayoutManager layoutManager = (binding == null || (recyclerView = binding.getErrorConfigVersion) == null) ? null : recyclerView.getLayoutManager();
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? layoutManager : null;
                    return (linearLayoutManager != null ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : -1) == 0;
                }

                @Override // in.srain.cube.views.ptr.PtrHandler
                public final void onRefreshBegin(PtrFrameLayout frame) {
                    FragmentIdentityDetailWalletBinding binding;
                    PtrWalletFrameLayout ptrWalletFrameLayout;
                    IdentityWalletDetailFragment.this.navigateToSearch();
                    binding = IdentityWalletDetailFragment.this.getBinding();
                    if (binding == null || (ptrWalletFrameLayout = binding.moveToNextValue) == null) {
                        return;
                    }
                    ptrWalletFrameLayout.refreshComplete();
                }
            };
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCollapseFromSearch$lambda-4  reason: not valid java name */
    public static final void m3007onCollapseFromSearch$lambda4() {
    }

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
        return R.layout.fragment_identity_detail_wallet;
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

    @JvmName(name = "getPersonalPresenter")
    public final PersonalContract.Presenter getPersonalPresenter() {
        PersonalContract.Presenter presenter = this.personalPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPersonalPresenter")
    public final void setPersonalPresenter(PersonalContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.personalPresenter = presenter;
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
    @JvmName(name = "getIdentityToastAndDialog")
    public final IdentityToastAndDialogImpl getIdentityToastAndDialog() {
        return (IdentityToastAndDialogImpl) this.identityToastAndDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getIdentityWalletAdapter")
    public final IdentityWalletAdapter getIdentityWalletAdapter() {
        return (IdentityWalletAdapter) this.identityWalletAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getWalletCardAssetClickListener")
    public final WalletCardAssetClickListener getWalletCardAssetClickListener() {
        return (WalletCardAssetClickListener) this.walletCardAssetClickListener.getValue();
    }

    @JvmName(name = "getPtrCardIdentityHandle")
    private final PtrHandler getPtrCardIdentityHandle() {
        return (PtrHandler) this.ptrCardIdentityHandle.getValue();
    }

    public final void onAddKtpAsset() {
        getPersonalPresenter().consultAgreementCenter();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        setEnabled(false);
        remove();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(getIdentityToastAndDialog());
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        getLifecycle().BuiltInFictitiousFunctionClassFactory(getIdentityToastAndDialog());
        initInjector();
        initView();
        initOnClickListener();
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.PlaceComponentResult(this, this.onBackPressedCallback);
        }
        disableSwipe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final FragmentIdentityDetailWalletBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentIdentityDetailWalletBinding MyBillsEntityDataFactory = FragmentIdentityDetailWalletBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    private final void initInjector() {
        DaggerIdentityWalletDetailComponent.builder().applicationComponent(getApplicationComponent()).personalModule(getPersonalModule()).build().inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity == null || !isFromDeeplinkWallet(activity)) {
            return;
        }
        FragmentIdentityDetailWalletBinding binding = getBinding();
        RecyclerView recyclerView = binding != null ? binding.getErrorConfigVersion : null;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        backToMainPage(recyclerView, parentFragmentManager, 4);
    }

    private final void initView() {
        ArrayList arrayList;
        PtrWalletFrameLayout ptrWalletFrameLayout;
        IdentityCardModel identityCardModel;
        Parcelable[] parcelableArray;
        List list;
        ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding;
        ConstraintLayout constraintLayout;
        ViewWalletV3SearchStubBinding viewWalletV3SearchStubBinding2;
        RecyclerView recyclerView;
        FragmentIdentityDetailWalletBinding binding = getBinding();
        if (binding != null && (recyclerView = binding.getErrorConfigVersion) != null) {
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(getIdentityWalletAdapter());
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.addItemDecoration(new WalletVerticalSpaceItemDecoration());
        }
        FragmentIdentityDetailWalletBinding binding2 = getBinding();
        AppCompatTextView appCompatTextView = (binding2 == null || (viewWalletV3SearchStubBinding2 = binding2.lookAheadTest) == null) ? null : viewWalletV3SearchStubBinding2.PlaceComponentResult;
        if (appCompatTextView != null) {
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R.string.wallet_search_bar_hint_identity) : null);
        }
        FragmentIdentityDetailWalletBinding binding3 = getBinding();
        if (binding3 != null && (viewWalletV3SearchStubBinding = binding3.lookAheadTest) != null && (constraintLayout = viewWalletV3SearchStubBinding.BuiltInFictitiousFunctionClassFactory) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IdentityWalletDetailFragment.m3004initView$lambda2(IdentityWalletDetailFragment.this, view);
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments == null || (parcelableArray = arguments.getParcelableArray(IDENTITY_CARD_ITEMS)) == null || (list = ArraysKt.toList(parcelableArray)) == null) {
            arrayList = null;
        } else {
            List<Parcelable> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Parcelable parcelable : list2) {
                arrayList2.add(parcelable instanceof IdentityCardModel ? (IdentityCardModel) parcelable : null);
            }
            arrayList = arrayList2;
        }
        getIdentityWalletAdapter().setItems(arrayList);
        FragmentIdentityDetailWalletBinding binding4 = getBinding();
        DanaButtonPrimaryView danaButtonPrimaryView = binding4 != null ? binding4.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setVisibility(arrayList != null && (identityCardModel = (IdentityCardModel) arrayList.get(0)) != null && identityCardModel.getViewType() == 3 ? 0 : 8);
        }
        FragmentIdentityDetailWalletBinding binding5 = getBinding();
        if (binding5 != null && (ptrWalletFrameLayout = binding5.moveToNextValue) != null) {
            ptrWalletFrameLayout.setPtrHandler(getPtrCardIdentityHandle());
        }
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        setupLottieBasedOnLanguage(LocaleUtil.PlaceComponentResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m3004initView$lambda2(IdentityWalletDetailFragment identityWalletDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(identityWalletDetailFragment, "");
        identityWalletDetailFragment.navigateToSearch();
    }

    public final void onCollapseFromSearch() {
        MotionLayout motionLayout;
        MotionLayout motionLayout2;
        FragmentIdentityDetailWalletBinding binding = getBinding();
        if (binding != null && (motionLayout2 = binding.MyBillsEntityDataFactory) != null) {
            motionLayout2.setTransition(R.id.collapse_from_search);
        }
        FragmentIdentityDetailWalletBinding binding2 = getBinding();
        if (binding2 == null || (motionLayout = binding2.MyBillsEntityDataFactory) == null) {
            return;
        }
        motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                IdentityWalletDetailFragment.m3007onCollapseFromSearch$lambda4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToSearch() {
        MotionLayout motionLayout;
        MotionLayout motionLayout2;
        FragmentIdentityDetailWalletBinding binding = getBinding();
        if (binding != null && (motionLayout2 = binding.MyBillsEntityDataFactory) != null) {
            motionLayout2.setTransition(R.id.expand_to_search);
        }
        FragmentIdentityDetailWalletBinding binding2 = getBinding();
        if (binding2 == null || (motionLayout = binding2.MyBillsEntityDataFactory) == null) {
            return;
        }
        motionLayout.transitionToEnd(new Runnable() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                IdentityWalletDetailFragment.m3005navigateToSearch$lambda5(IdentityWalletDetailFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: navigateToSearch$lambda-5  reason: not valid java name */
    public static final void m3005navigateToSearch$lambda5(IdentityWalletDetailFragment identityWalletDetailFragment) {
        Intrinsics.checkNotNullParameter(identityWalletDetailFragment, "");
        WalletIntentFactory walletIntentFactory = WalletIntentFactory.INSTANCE;
        IdentityWalletDetailFragment identityWalletDetailFragment2 = identityWalletDetailFragment;
        WalletSearchFragment.Companion companion = WalletSearchFragment.INSTANCE;
        Context context = identityWalletDetailFragment.getContext();
        walletIntentFactory.openNewFragmentWithAnimation(identityWalletDetailFragment2, WalletSearchFragment.Companion.newInstance$default(companion, "identity", context != null ? context.getString(R.string.wallet_search_bar_hint_identity) : null, null, null, 12, null));
    }

    private final void initOnClickListener() {
        DanaButtonPrimaryView danaButtonPrimaryView;
        LottieAnimationView lottieAnimationView;
        FragmentIdentityDetailWalletBinding binding = getBinding();
        if (binding != null && (lottieAnimationView = binding.getAuthRequestContext) != null) {
            lottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IdentityWalletDetailFragment.m3002initOnClickListener$lambda6(IdentityWalletDetailFragment.this, view);
                }
            });
        }
        FragmentIdentityDetailWalletBinding binding2 = getBinding();
        if (binding2 == null || (danaButtonPrimaryView = binding2.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdentityWalletDetailFragment.m3003initOnClickListener$lambda7(IdentityWalletDetailFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-6  reason: not valid java name */
    public static final void m3002initOnClickListener$lambda6(IdentityWalletDetailFragment identityWalletDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(identityWalletDetailFragment, "");
        FragmentIdentityDetailWalletBinding binding = identityWalletDetailFragment.getBinding();
        RecyclerView recyclerView = binding != null ? binding.getErrorConfigVersion : null;
        FragmentManager parentFragmentManager = identityWalletDetailFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        identityWalletDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-7  reason: not valid java name */
    public static final void m3003initOnClickListener$lambda7(IdentityWalletDetailFragment identityWalletDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(identityWalletDetailFragment, "");
        identityWalletDetailFragment.getWalletV3TrackerImplementation().trackOpenAddAsset(TrackerKey.WalletAddAssetSource.ADD_IDENTITY_SECTION);
        identityWalletDetailFragment.onAddKtpAsset();
    }

    private final PersonalModule getPersonalModule() {
        return new PersonalModule(new PersonalContract.View() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$getPersonalModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onCheckKtpPopUpError(String errorCode) {
                Intrinsics.checkNotNullParameter(errorCode, "");
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onGetIdentityReloadIntervalTime(long millis) {
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onGetInsuranceQueryListError() {
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onGetInsuranceQueryListSuccess(PocketQueryListModel<InsuranceAssetModel> pocketQueryList, boolean isNeedToReset) {
                Intrinsics.checkNotNullParameter(pocketQueryList, "");
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onGetKtpInfoQueryError() {
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onGetKtpInfoQuerySuccess(PocketQueryListModel<KtpInfoModel> pocketQueryList, boolean isNeedToReset) {
                Intrinsics.checkNotNullParameter(pocketQueryList, "");
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onKtpSaved(boolean isShowKtp) {
                FragmentIdentityDetailWalletBinding binding;
                binding = IdentityWalletDetailFragment.this.getBinding();
                DanaButtonPrimaryView danaButtonPrimaryView = binding != null ? binding.KClassImpl$Data$declaredNonStaticMembers$2 : null;
                if (danaButtonPrimaryView != null) {
                    danaButtonPrimaryView.setVisibility(8);
                }
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onKtpNotSaved() {
                IdentityWalletAdapter identityWalletAdapter;
                FragmentIdentityDetailWalletBinding binding;
                identityWalletAdapter = IdentityWalletDetailFragment.this.getIdentityWalletAdapter();
                identityWalletAdapter.setItems(CollectionsKt.listOf(new IdentityCardModel.KtpCard(null, null, null, 3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194295, null)));
                binding = IdentityWalletDetailFragment.this.getBinding();
                DanaButtonPrimaryView danaButtonPrimaryView = binding != null ? binding.KClassImpl$Data$declaredNonStaticMembers$2 : null;
                if (danaButtonPrimaryView != null) {
                    danaButtonPrimaryView.setVisibility(0);
                }
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onSaveKtpSuccess() {
                IdentityToastAndDialogImpl identityToastAndDialog;
                IdentityWalletDetailFragment.this.hideShimmeringSkeleton();
                identityToastAndDialog = IdentityWalletDetailFragment.this.getIdentityToastAndDialog();
                identityToastAndDialog.showSuccessToast(IdentityWalletDetailFragment.this);
                IdentityWalletDetailFragment.this.setViewSuccessSaveKtp();
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onSaveKtpError() {
                IdentityToastAndDialogImpl identityToastAndDialog;
                IdentityWalletDetailFragment.this.hideShimmeringSkeleton();
                identityToastAndDialog = IdentityWalletDetailFragment.this.getIdentityToastAndDialog();
                identityToastAndDialog.showErrorToast();
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onGetUserKYCStatusSuccess(Map<String, String> extendInfo) {
                IdentityToastAndDialogImpl identityToastAndDialog;
                Intrinsics.checkNotNullParameter(extendInfo, "");
                identityToastAndDialog = IdentityWalletDetailFragment.this.getIdentityToastAndDialog();
                String kycLandingPageUrl = IdentityWalletDetailFragment.this.getDynamicUrlWrapper().getKycLandingPageUrl();
                Intrinsics.checkNotNullExpressionValue(kycLandingPageUrl, "");
                final IdentityWalletDetailFragment identityWalletDetailFragment = IdentityWalletDetailFragment.this;
                identityToastAndDialog.checkKYCStatusAndCertType(extendInfo, kycLandingPageUrl, new Function0<Unit>() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$getPersonalModule$1$onGetUserKYCStatusSuccess$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        IdentityWalletDetailFragment.this.showShimmeringSkeleton();
                        IdentityWalletDetailFragment.this.getPersonalPresenter().recordAgreement(true, true);
                    }
                });
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onGetUserKYCStatusError() {
                IdentityToastAndDialogImpl identityToastAndDialog;
                identityToastAndDialog = IdentityWalletDetailFragment.this.getIdentityToastAndDialog();
                identityToastAndDialog.showErrorToast();
            }

            @Override // id.dana.wallet.personal.PersonalContract.View
            public final void onConsultAgreementCenterError() {
                FragmentActivity activity = IdentityWalletDetailFragment.this.getActivity();
                if (activity != null) {
                    DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                    String string = IdentityWalletDetailFragment.this.getString(R.string.SchedulerPoolFactory);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    DANAToast.MyBillsEntityDataFactory(activity, string, "");
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        LottieAnimationView lottieAnimationView;
        Bundle extras;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1012) {
            if (resultCode == -1) {
                startActivityForResult(new Intent(getContext(), KtpDetailActivity.class), NewWalletFragment.INSTANCE.getIDENTITY_REQUEST_CODE());
            } else if (resultCode == 0) {
                if (Intrinsics.areEqual((data == null || (extras = data.getExtras()) == null) ? null : extras.getString(ChallengeControl.Key.CANCEL_REASON), ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED)) {
                    getIdentityToastAndDialog().showErrorVerifyPinPopup();
                }
            }
        } else if (requestCode == NewWalletFragment.INSTANCE.getIDENTITY_REQUEST_CODE() && resultCode == -1) {
            getPersonalPresenter().checkKtpPopUp();
            setLastAddedAssetType();
            FragmentIdentityDetailWalletBinding binding = getBinding();
            if (binding == null || (lottieAnimationView = binding.getAuthRequestContext) == null) {
                return;
            }
            lottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IdentityWalletDetailFragment.m3006onActivityResult$lambda8(IdentityWalletDetailFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityResult$lambda-8  reason: not valid java name */
    public static final void m3006onActivityResult$lambda8(IdentityWalletDetailFragment identityWalletDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(identityWalletDetailFragment, "");
        FragmentIdentityDetailWalletBinding binding = identityWalletDetailFragment.getBinding();
        RecyclerView recyclerView = binding != null ? binding.getErrorConfigVersion : null;
        FragmentManager parentFragmentManager = identityWalletDetailFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        identityWalletDetailFragment.backToMainPage(recyclerView, parentFragmentManager, 4);
    }

    private final void setLastAddedAssetType() {
        Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag(HomeTabFragment.FragmentTag.WALLET_FRAGMENT);
        NewWalletFragment newWalletFragment = findFragmentByTag instanceof NewWalletFragment ? (NewWalletFragment) findFragmentByTag : null;
        if (newWalletFragment != null) {
            newWalletFragment.setLastAddedAssetType(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [id.dana.component.buttoncomponent.DanaButtonPrimaryView] */
    public final void setViewSuccessSaveKtp() {
        List<IdentityCardModel.KtpCard> listOf = CollectionsKt.listOf(new IdentityCardModel.KtpCard(null, null, null, 14, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194295, null));
        Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag(HomeTabFragment.FragmentTag.WALLET_FRAGMENT);
        NewWalletFragment newWalletFragment = findFragmentByTag instanceof NewWalletFragment ? (NewWalletFragment) findFragmentByTag : null;
        if (newWalletFragment != null) {
            newWalletFragment.updateIdentityCardState(listOf);
        }
        List<WalletV3CardModel> items = getIdentityWalletAdapter().getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        CollectionsKt.removeAll(CollectionsKt.toMutableList((Collection) items), (Function1) new Function1<WalletV3CardModel, Boolean>() { // from class: id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment$setViewSuccessSaveKtp$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WalletV3CardModel walletV3CardModel) {
                return Boolean.valueOf(walletV3CardModel.getViewType() == 3);
            }
        });
        getIdentityWalletAdapter().setItems(listOf);
        FragmentIdentityDetailWalletBinding binding = getBinding();
        String str = binding != null ? binding.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (str != null) {
            ((View) str).setVisibility(8);
        }
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
        FragmentIdentityDetailWalletBinding binding = getBinding();
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(binding != null ? binding.getErrorConfigVersion : null);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_wallet_detail_skeleton;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = getIdentityWalletAdapter();
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
        FragmentIdentityDetailWalletBinding binding = getBinding();
        if (binding == null || (lottieAnimationView = binding.getAuthRequestContext) == null) {
            return;
        }
        lottieAnimationView.setAnimation(str);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/wallet_v3/identity/view/IdentityWalletDetailFragment$Companion;", "", "", "Lid/dana/wallet_v3/model/WalletV3CardModel;", FirebaseAnalytics.Param.ITEMS, "Lid/dana/wallet_v3/identity/view/IdentityWalletDetailFragment;", "newInstance", "(Ljava/util/List;)Lid/dana/wallet_v3/identity/view/IdentityWalletDetailFragment;", "", IdentityWalletDetailFragment.IDENTITY_CARD_ITEMS, "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IdentityWalletDetailFragment newInstance(List<? extends WalletV3CardModel> items) {
            Intrinsics.checkNotNullParameter(items, "");
            Bundle bundle = new Bundle();
            Object[] array = items.toArray(new WalletV3CardModel[0]);
            if (array != null) {
                bundle.putParcelableArray(IdentityWalletDetailFragment.IDENTITY_CARD_ITEMS, (Parcelable[]) array);
                IdentityWalletDetailFragment identityWalletDetailFragment = new IdentityWalletDetailFragment();
                identityWalletDetailFragment.setArguments(bundle);
                return identityWalletDetailFragment;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }
}
