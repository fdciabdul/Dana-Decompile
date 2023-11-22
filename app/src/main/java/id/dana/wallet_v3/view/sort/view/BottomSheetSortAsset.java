package id.dana.wallet_v3.view.sort.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.databinding.BottomSheetSortAssetBinding;
import id.dana.databinding.BottomSheetSortAssetContainerBinding;
import id.dana.di.ComponentHolder;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.wallet_v3.di.component.DaggerBottomSheetSortAssetComponent;
import id.dana.wallet_v3.di.module.BottomSheetSortAssetModule;
import id.dana.wallet_v3.view.sort.model.SortCategoryModel;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter;
import id.dana.wallet_v3.view.sort.view.WalletSortCategoryView;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0016\b\u0002\u0010:\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0004\u0018\u00010+\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001c\u0010\fJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\fJ\u000f\u0010 \u001a\u00020\u0004H\u0014¢\u0006\u0004\b \u0010\fJ\u000f\u0010!\u001a\u00020\u0004H\u0014¢\u0006\u0004\b!\u0010\fJ\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\fJ\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\fR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u0004\u0018\u00010'8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'0+8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\"\u00101\u001a\u0002008\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010:\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0004\u0018\u00010+8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b?\u0010@"}, d2 = {"Lid/dana/wallet_v3/view/sort/view/BottomSheetSortAsset;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "position", "", "checkSelectedCategory", "(I)V", "Lkotlin/Function0;", "action", "delayToDismiss", "(Lkotlin/jvm/functions/Function0;)V", "disableResetButton", "()V", "enableApplyButton", "enableResetButton", "Landroid/widget/FrameLayout;", "getBottomSheet", "()Landroid/widget/FrameLayout;", "Lid/dana/wallet_v3/di/module/BottomSheetSortAssetModule;", "getBottomSheetAddAssetModule", "()Lid/dana/wallet_v3/di/module/BottomSheetSortAssetModule;", "Lid/dana/wallet_v3/view/sort/view/BottomSheetSortAsset$getChipCategoryListener$1;", "getChipCategoryListener", "()Lid/dana/wallet_v3/view/sort/view/BottomSheetSortAsset$getChipCategoryListener$1;", "", "getDimAmount", "()F", "getOrderCategory", IAPSyncCommand.COMMAND_INIT, "initInjector", "initOnClickListener", "initView", "onDismiss", "onShow", "onStart", "setupBottomSheet", "Lid/dana/domain/pocket/model/AssetStatus;", "assetStatusOrder", "Lid/dana/domain/pocket/model/AssetStatus;", "Lid/dana/databinding/BottomSheetSortAssetContainerBinding;", "getBinding", "()Lid/dana/databinding/BottomSheetSortAssetContainerBinding;", "binding", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "getBindingInflater", "()Lkotlin/jvm/functions/Function1;", "bindingInflater", "Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetPresenter;", "bottomSheetSortAssetPresenter", "Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetPresenter;", "getBottomSheetSortAssetPresenter", "()Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetPresenter;", "setBottomSheetSortAssetPresenter", "(Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetPresenter;)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onDismissBottomSheet", "Lkotlin/jvm/functions/Function1;", "savedPosition", "I", "", HomeTabActivity.WALLET_SECTION, "Ljava/lang/String;", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BottomSheetSortAsset extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> _$_findViewCache;
    private AssetStatus assetStatusOrder;
    @Inject
    public BottomSheetSortAssetPresenter bottomSheetSortAssetPresenter;
    private CompositeDisposable compositeDisposable;
    private final Function1<AssetStatus, Unit> onDismissBottomSheet;
    private int savedPosition;
    private final String section;

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetSortAsset(Function1<? super AssetStatus, Unit> function1, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onDismissBottomSheet = function1;
        this.section = str;
        this.assetStatusOrder = AssetStatus.EXPIRING_SOON;
    }

    public /* synthetic */ BottomSheetSortAsset(Function1 function1, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1, str);
    }

    @JvmName(name = "getBottomSheetSortAssetPresenter")
    public final BottomSheetSortAssetPresenter getBottomSheetSortAssetPresenter() {
        BottomSheetSortAssetPresenter bottomSheetSortAssetPresenter = this.bottomSheetSortAssetPresenter;
        if (bottomSheetSortAssetPresenter != null) {
            return bottomSheetSortAssetPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBottomSheetSortAssetPresenter")
    public final void setBottomSheetSortAssetPresenter(BottomSheetSortAssetPresenter bottomSheetSortAssetPresenter) {
        Intrinsics.checkNotNullParameter(bottomSheetSortAssetPresenter, "");
        this.bottomSheetSortAssetPresenter = bottomSheetSortAssetPresenter;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    @JvmName(name = "getBindingInflater")
    public final Function1<LayoutInflater, BottomSheetSortAssetContainerBinding> getBindingInflater() {
        return new Function1<LayoutInflater, BottomSheetSortAssetContainerBinding>() { // from class: id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset$bindingInflater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BottomSheetSortAssetContainerBinding invoke(LayoutInflater layoutInflater) {
                Intrinsics.checkNotNullParameter(layoutInflater, "");
                BottomSheetSortAssetContainerBinding PlaceComponentResult = BottomSheetSortAssetContainerBinding.PlaceComponentResult(BottomSheetSortAsset.this.getLayoutInflater());
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                return PlaceComponentResult;
            }
        };
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    @JvmName(name = "getBinding")
    public final BottomSheetSortAssetContainerBinding getBinding() {
        ViewBinding viewBinding = getViewBinding();
        if (viewBinding instanceof BottomSheetSortAssetContainerBinding) {
            return (BottomSheetSortAssetContainerBinding) viewBinding;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final FrameLayout getPlaceComponentResult() {
        BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
        BottomSheetSortAssetContainerBinding binding = getBinding();
        if (binding == null || (bottomSheetSortAssetBinding = binding.getAuthRequestContext) == null) {
            return null;
        }
        return bottomSheetSortAssetBinding.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        initMatchParentDialog(getDialog());
        initTransparentDialogDim(getDialog());
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        initInjector();
        getOrderCategory();
        initView();
        initOnClickListener();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        setupBottomSheet();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onDismiss() {
        super.onDismiss();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            compositeDisposable = null;
        }
        compositeDisposable.dispose();
    }

    private final void setupBottomSheet() {
        initBottomSheet(getScreenHeight(getDialog()), 3);
        Dialog dialog = getDialog();
        if (dialog == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
        BottomSheetBehavior<FrameLayout> behavior = ((BottomSheetDialog) dialog).getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "");
        behavior.setState(3);
    }

    private final void initInjector() {
        DaggerBottomSheetSortAssetComponent.builder().applicationComponent(ComponentHolder.getAuthRequestContext()).bottomSheetSortAssetModule(getBottomSheetAddAssetModule()).build().inject(this);
    }

    private final BottomSheetSortAssetModule getBottomSheetAddAssetModule() {
        return new BottomSheetSortAssetModule(new BottomSheetSortAssetContract.View() { // from class: id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset$getBottomSheetAddAssetModule$1
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

            @Override // id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract.View
            public final void onErrorGetOrderCategory() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract.View
            public final void onSuccessGetOrderCategory(List<SortCategoryModel> order) {
                BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
                WalletSortCategoryView walletSortCategoryView;
                Intrinsics.checkNotNullParameter(order, "");
                BottomSheetSortAssetContainerBinding binding = BottomSheetSortAsset.this.getBinding();
                if (binding == null || (bottomSheetSortAssetBinding = binding.getAuthRequestContext) == null || (walletSortCategoryView = bottomSheetSortAssetBinding.moveToNextValue) == null) {
                    return;
                }
                walletSortCategoryView.setCategoryItem(order);
            }

            @Override // id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract.View
            public final void onSuccessGetVoucherAndTicketOrder(int position, String savedOrder) {
                BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
                WalletSortCategoryView walletSortCategoryView;
                BottomSheetSortAssetBinding bottomSheetSortAssetBinding2;
                WalletSortCategoryView walletSortCategoryView2;
                Intrinsics.checkNotNullParameter(savedOrder, "");
                BottomSheetSortAsset.this.savedPosition = position;
                BottomSheetSortAsset.this.assetStatusOrder = AssetStatus.valueOf(savedOrder);
                if (position != 0) {
                    BottomSheetSortAssetContainerBinding binding = BottomSheetSortAsset.this.getBinding();
                    if (binding != null && (bottomSheetSortAssetBinding2 = binding.getAuthRequestContext) != null && (walletSortCategoryView2 = bottomSheetSortAssetBinding2.moveToNextValue) != null) {
                        walletSortCategoryView2.setLastSelectedCategory(position);
                    }
                    BottomSheetSortAsset.this.enableResetButton();
                    return;
                }
                BottomSheetSortAssetContainerBinding binding2 = BottomSheetSortAsset.this.getBinding();
                if (binding2 != null && (bottomSheetSortAssetBinding = binding2.getAuthRequestContext) != null && (walletSortCategoryView = bottomSheetSortAssetBinding.moveToNextValue) != null) {
                    walletSortCategoryView.setSelectedCategoryToDefault();
                }
                BottomSheetSortAsset.this.disableResetButton();
            }

            @Override // id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract.View
            public final void onErrorGetVoucherAndTicketOrder() {
                BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
                WalletSortCategoryView walletSortCategoryView;
                BottomSheetSortAssetContainerBinding binding = BottomSheetSortAsset.this.getBinding();
                if (binding == null || (bottomSheetSortAssetBinding = binding.getAuthRequestContext) == null || (walletSortCategoryView = bottomSheetSortAssetBinding.moveToNextValue) == null) {
                    return;
                }
                walletSortCategoryView.setSelectedCategoryToDefault();
            }
        });
    }

    private final void getOrderCategory() {
        getBottomSheetSortAssetPresenter().getSortOrder(this.section);
    }

    private final void initView() {
        BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
        WalletSortCategoryView walletSortCategoryView;
        this.compositeDisposable = new CompositeDisposable();
        BottomSheetSortAssetContainerBinding binding = getBinding();
        if (binding != null && (bottomSheetSortAssetBinding = binding.getAuthRequestContext) != null && (walletSortCategoryView = bottomSheetSortAssetBinding.moveToNextValue) != null) {
            walletSortCategoryView.setWalletSortCategoryViewListener(getChipCategoryListener());
        }
        if (this.savedPosition == 0) {
            disableResetButton();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset$getChipCategoryListener$1] */
    private final BottomSheetSortAsset$getChipCategoryListener$1 getChipCategoryListener() {
        return new WalletSortCategoryView.WalletSortCategoryViewListener() { // from class: id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset$getChipCategoryListener$1
            @Override // id.dana.wallet_v3.view.sort.view.WalletSortCategoryView.WalletSortCategoryViewListener
            public final void onClickChipCategory(SortCategoryModel sortCategoryModel, int position) {
                Intrinsics.checkNotNullParameter(sortCategoryModel, "");
                BottomSheetSortAsset.this.assetStatusOrder = sortCategoryModel.getOrder();
                BottomSheetSortAsset.this.enableApplyButton();
                BottomSheetSortAsset.this.checkSelectedCategory(position);
            }
        };
    }

    private final void initOnClickListener() {
        BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
        DanaButtonPrimaryView danaButtonPrimaryView;
        BottomSheetSortAssetBinding bottomSheetSortAssetBinding2;
        DanaButtonSecondaryView danaButtonSecondaryView;
        BottomSheetSortAssetContainerBinding binding = getBinding();
        if (binding != null && (bottomSheetSortAssetBinding2 = binding.getAuthRequestContext) != null && (danaButtonSecondaryView = bottomSheetSortAssetBinding2.BuiltInFictitiousFunctionClassFactory) != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BottomSheetSortAsset.m3114initOnClickListener$lambda1(BottomSheetSortAsset.this, view);
                }
            });
        }
        BottomSheetSortAssetContainerBinding binding2 = getBinding();
        if (binding2 == null || (bottomSheetSortAssetBinding = binding2.getAuthRequestContext) == null || (danaButtonPrimaryView = bottomSheetSortAssetBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetSortAsset.m3115initOnClickListener$lambda3(BottomSheetSortAsset.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-1  reason: not valid java name */
    public static final void m3114initOnClickListener$lambda1(final BottomSheetSortAsset bottomSheetSortAsset, View view) {
        BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
        WalletSortCategoryView walletSortCategoryView;
        Intrinsics.checkNotNullParameter(bottomSheetSortAsset, "");
        BottomSheetSortAssetContainerBinding binding = bottomSheetSortAsset.getBinding();
        if (binding != null && (bottomSheetSortAssetBinding = binding.getAuthRequestContext) != null && (walletSortCategoryView = bottomSheetSortAssetBinding.moveToNextValue) != null) {
            walletSortCategoryView.setSelectedCategoryToDefault();
        }
        bottomSheetSortAsset.getBottomSheetSortAssetPresenter().saveVoucherTicketOrder(AssetStatus.EXPIRING_SOON.name());
        Function1<AssetStatus, Unit> function1 = bottomSheetSortAsset.onDismissBottomSheet;
        if (function1 != null) {
            function1.invoke(AssetStatus.EXPIRING_SOON);
        }
        bottomSheetSortAsset.delayToDismiss(new Function0<Unit>() { // from class: id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset$initOnClickListener$1$2
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
                BottomSheetSortAsset.this.dismiss();
            }
        });
        bottomSheetSortAsset.disableResetButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnClickListener$lambda-3  reason: not valid java name */
    public static final void m3115initOnClickListener$lambda3(BottomSheetSortAsset bottomSheetSortAsset, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetSortAsset, "");
        bottomSheetSortAsset.getBottomSheetSortAssetPresenter().saveVoucherTicketOrder(bottomSheetSortAsset.assetStatusOrder.name());
        bottomSheetSortAsset.dismiss();
        Function1<AssetStatus, Unit> function1 = bottomSheetSortAsset.onDismissBottomSheet;
        if (function1 != null) {
            function1.invoke(bottomSheetSortAsset.assetStatusOrder);
        }
    }

    private final void delayToDismiss(final Function0<Unit> action) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        Scheduler KClassImpl$Data$declaredNonStaticMembers$22;
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            compositeDisposable = null;
        }
        Completable MyBillsEntityDataFactory = Completable.MyBillsEntityDataFactory();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$23 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableDelay(MyBillsEntityDataFactory, 500L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
        KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$24 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$23, KClassImpl$Data$declaredNonStaticMembers$22));
        Scheduler PlaceComponentResult = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$25 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$24, PlaceComponentResult));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$25, "");
        compositeDisposable.getAuthRequestContext(SubscribersKt.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$25, null, new Function0<Unit>() { // from class: id.dana.wallet_v3.view.sort.view.BottomSheetSortAsset$delayToDismiss$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                action.invoke();
            }
        }, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkSelectedCategory(int position) {
        if (position == 0 || this.savedPosition == 0) {
            disableResetButton();
        } else {
            enableResetButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableResetButton() {
        BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
        DanaButtonSecondaryView danaButtonSecondaryView;
        BottomSheetSortAssetContainerBinding binding = getBinding();
        if (binding == null || (bottomSheetSortAssetBinding = binding.getAuthRequestContext) == null || (danaButtonSecondaryView = bottomSheetSortAssetBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        Context context = getContext();
        String string = context != null ? context.getString(R.string.reset) : null;
        if (string == null) {
            string = "";
        }
        danaButtonSecondaryView.setDanaButtonView(0, string, "", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableResetButton() {
        BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
        DanaButtonSecondaryView danaButtonSecondaryView;
        BottomSheetSortAssetContainerBinding binding = getBinding();
        if (binding == null || (bottomSheetSortAssetBinding = binding.getAuthRequestContext) == null || (danaButtonSecondaryView = bottomSheetSortAssetBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        Context context = getContext();
        String string = context != null ? context.getString(R.string.reset) : null;
        if (string == null) {
            string = "";
        }
        danaButtonSecondaryView.setDanaButtonView(1, string, "", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableApplyButton() {
        BottomSheetSortAssetBinding bottomSheetSortAssetBinding;
        DanaButtonPrimaryView danaButtonPrimaryView;
        BottomSheetSortAssetContainerBinding binding = getBinding();
        if (binding == null || (bottomSheetSortAssetBinding = binding.getAuthRequestContext) == null || (danaButtonPrimaryView = bottomSheetSortAssetBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        Context context = getContext();
        String string = context != null ? context.getString(R.string.bottom_apply) : null;
        if (string == null) {
            string = "";
        }
        danaButtonPrimaryView.setDanaButtonView(1, string, "", null);
    }
}
