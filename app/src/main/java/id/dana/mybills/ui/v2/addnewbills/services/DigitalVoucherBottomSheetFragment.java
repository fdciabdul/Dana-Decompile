package id.dana.mybills.ui.v2.addnewbills.services;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.FlowExtKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.fragment.FragmentKt;
import androidx.view.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentDigitalVoucherBottomSheetBinding;
import id.dana.mybills.databinding.ViewFooterAddNewBillsBinding;
import id.dana.mybills.databinding.ViewHeaderDetailBillsBinding;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.di.provider.MyBillsComponentProvider;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.constant.SubscriptionIntervalType;
import id.dana.mybills.ui.customview.BodySaveToBillsView;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.MyBillsToolbarView;
import id.dana.mybills.ui.model.BizProductModel;
import id.dana.mybills.ui.model.DropdownOptionsModel;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.model.MyBillsServiceModel;
import id.dana.mybills.ui.model.SaveMyBillsSubscriptionModel;
import id.dana.mybills.ui.model.SaveSubscriptionRequestModel;
import id.dana.mybills.ui.v2.MyBillsHomeActivity;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel;
import id.dana.mybills.ui.v2.addnewbills.AddToMyBillsState;
import id.dana.mybills.utils.MyBillsTrackerUtil;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b1\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0016\u0010\u0019\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010%R\u0012\u0010'\u001a\u00020&X\u0087\"¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010*R\u0013\u0010\u001f\u001a\u00020\tX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010,R\u0013\u0010\u001c\u001a\u00020\fX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010,R\u0013\u0010\u0007\u001a\u00020-X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010,R\u0012\u0010/\u001a\u00020.X\u0087\"¢\u0006\u0006\n\u0004\b/\u00100"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/services/DigitalVoucherBottomSheetFragment;", "Lid/dana/mybills/ui/v2/addnewbills/services/BaseMyBillsBottomSheet;", "Lid/dana/mybills/databinding/FragmentDigitalVoucherBottomSheetBinding;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "scheduleImpl", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "()Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "Landroidx/core/widget/NestedScrollView;", "moveToNextValue", "()Landroidx/core/widget/NestedScrollView;", "", "initRecordTimeStamp", "()Ljava/lang/String;", "Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "GetContactSyncConfig", "()Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Lid/dana/mybills/ui/model/BizProductModel;", "Lid/dana/mybills/ui/model/BizProductModel;", "PlaceComponentResult", "", "Z", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "myBillsAnalyticTracker", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "Lid/dana/mybills/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DigitalVoucherBottomSheetFragment extends BaseMyBillsBottomSheet<FragmentDigitalVoucherBottomSheetBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private BizProductModel PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private MyBillsServiceModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public MyBillsAnalyticTracker myBillsAnalyticTracker;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ ViewBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentDigitalVoucherBottomSheetBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentDigitalVoucherBottomSheetBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater(), viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet, id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        Parcelable parcelable;
        Parcelable parcelable2;
        super.getAuthRequestContext();
        String string = getString(R.string.my_bills_label_add_new_bills);
        Intrinsics.checkNotNullExpressionValue(string, "");
        super.getAuthRequestContext(string, R.drawable.res_0x7f08086b_networkuserentitydata_externalsyntheticlambda2, new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$init$1
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
                FragmentKt.getAuthRequestContext(DigitalVoucherBottomSheetFragment.this).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable("BUNDLE_KEY_PRODUCT", BizProductModel.class);
            } else {
                Parcelable parcelable3 = arguments.getParcelable("BUNDLE_KEY_PRODUCT");
                if (!(parcelable3 instanceof BizProductModel)) {
                    parcelable3 = null;
                }
                parcelable = (BizProductModel) parcelable3;
            }
            this.PlaceComponentResult = (BizProductModel) parcelable;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable2 = (Parcelable) arguments.getParcelable("BUNDLE_KEY_DIGITAL_VOUCHER", MyBillsServiceModel.class);
            } else {
                Parcelable parcelable4 = arguments.getParcelable("BUNDLE_KEY_DIGITAL_VOUCHER");
                if (!(parcelable4 instanceof MyBillsServiceModel)) {
                    parcelable4 = null;
                }
                parcelable2 = (MyBillsServiceModel) parcelable4;
            }
            this.BuiltInFictitiousFunctionClassFactory = (MyBillsServiceModel) parcelable2;
            Unit unit = Unit.INSTANCE;
        }
        getAuthRequestContext("BUNDLE_KEY_DIGITAL_VOUCHER");
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.mybills.di.provider.MyBillsComponentProvider");
        }
        ((MyBillsComponentProvider) applicationContext).provideMyBillsComponent().getAuthRequestContext().PlaceComponentResult(this);
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            BodySaveToBillsView bodySaveToBillsView = ((FragmentDigitalVoucherBottomSheetBinding) vb).lookAheadTest;
            bodySaveToBillsView.setToggleSaveToMyBillsVisible(false);
            bodySaveToBillsView.setIsSaveToMyBillsActive(false);
            bodySaveToBillsView.setOnToggleCheckedChanged(new BodySaveToBillsView.OnToggleAddToMyBillsChecked() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$initSwitchButton$1$1
                @Override // id.dana.mybills.ui.customview.BodySaveToBillsView.OnToggleAddToMyBillsChecked
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                    DigitalVoucherBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(DigitalVoucherBottomSheetFragment.this).KClassImpl$Data$declaredNonStaticMembers$2(AddToMyBillsState.getAuthRequestContext(DigitalVoucherBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(DigitalVoucherBottomSheetFragment.this).MyBillsEntityDataFactory.getValue(), p0));
                }
            });
            bodySaveToBillsView.setSwitchAddToMyBillsChecked(false);
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                FragmentDigitalVoucherBottomSheetBinding fragmentDigitalVoucherBottomSheetBinding = (FragmentDigitalVoucherBottomSheetBinding) vb2;
                DanaButtonPrimaryView danaButtonPrimaryView = fragmentDigitalVoucherBottomSheetBinding.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2;
                danaButtonPrimaryView.setEnabled(false);
                danaButtonPrimaryView.setDisabled(getString(R.string.my_bills_label_pay));
                danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DigitalVoucherBottomSheetFragment.PlaceComponentResult(DigitalVoucherBottomSheetFragment.this);
                    }
                });
                fragmentDigitalVoucherBottomSheetBinding.moveToNextValue.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DigitalVoucherBottomSheetFragment.getAuthRequestContext(DigitalVoucherBottomSheetFragment.this);
                    }
                });
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    final FragmentDigitalVoucherBottomSheetBinding fragmentDigitalVoucherBottomSheetBinding2 = (FragmentDigitalVoucherBottomSheetBinding) vb3;
                    fragmentDigitalVoucherBottomSheetBinding2.MyBillsEntityDataFactory.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$$ExternalSyntheticLambda2
                        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                        public final void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                            DigitalVoucherBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(FragmentDigitalVoucherBottomSheetBinding.this, nestedScrollView, i2, i4);
                        }
                    });
                    StateFlow<AddNewBillsUiState> stateFlow = ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda8;
                    Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
                    Intrinsics.checkNotNullExpressionValue(lifecycle, "");
                    Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new DigitalVoucherBottomSheetFragment$initObserver$1(this, null));
                    LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
                    FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
                    MyBillsServiceModel myBillsServiceModel = this.BuiltInFictitiousFunctionClassFactory;
                    String bizType = myBillsServiceModel != null ? myBillsServiceModel.getBizType() : null;
                    if (bizType == null) {
                        bizType = "";
                    }
                    ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).BuiltInFictitiousFunctionClassFactory(bizType);
                    BizProductModel bizProductModel = this.PlaceComponentResult;
                    if (bizProductModel != null) {
                        VB vb4 = this.MyBillsEntityDataFactory;
                        if (vb4 != 0) {
                            ((FragmentDigitalVoucherBottomSheetBinding) vb4).PlaceComponentResult.setText(bizProductModel.getProviderName());
                            VB vb5 = this.MyBillsEntityDataFactory;
                            if (vb5 != 0) {
                                CustomDropdownView customDropdownView = ((FragmentDigitalVoucherBottomSheetBinding) vb5).BuiltInFictitiousFunctionClassFactory;
                                List<DropdownOptionsModel> listOf = CollectionsKt.listOf(new DropdownOptionsModel(bizProductModel.getGoodsTitle(), bizProductModel.getDenom().getDisplayAmount(), bizProductModel.getGoodsId(), bizProductModel.getDenom(), null, 16, null));
                                customDropdownView.setOptions(listOf);
                                customDropdownView.setSelected((DropdownOptionsModel) CollectionsKt.first((List) listOf));
                                customDropdownView.isDropDownViewActivated(false, false);
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                    ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).MyBillsEntityDataFactory();
                    AddNewBillsViewModel addNewBillsViewModel = (AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
                    BizProductModel bizProductModel2 = this.PlaceComponentResult;
                    String goodsId = bizProductModel2 != null ? bizProductModel2.getGoodsId() : null;
                    if (goodsId == null) {
                        goodsId = "";
                    }
                    BizProductModel bizProductModel3 = this.PlaceComponentResult;
                    String goodsType = bizProductModel3 != null ? bizProductModel3.getGoodsType() : null;
                    addNewBillsViewModel.BuiltInFictitiousFunctionClassFactory(goodsId, goodsType != null ? goodsType : "");
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final String initRecordTimeStamp() {
        MyBillsServiceModel serviceModel;
        String name;
        BizProductModel bizProductModel = this.PlaceComponentResult;
        if (bizProductModel == null || (serviceModel = bizProductModel.getServiceModel()) == null || (name = serviceModel.getName()) == null) {
            MyBillsServiceModel myBillsServiceModel = this.BuiltInFictitiousFunctionClassFactory;
            String name2 = myBillsServiceModel != null ? myBillsServiceModel.getName() : null;
            return name2 == null ? "" : name2;
        }
        return name;
    }

    public DigitalVoucherBottomSheetFragment() {
        final DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = DigitalVoucherBottomSheetFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        final Function0 function03 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(digitalVoucherBottomSheetFragment, Reflection.getOrCreateKotlinClass(AddNewBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.PlaceComponentResult(Lazy.this).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = Function0.this;
                if (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) {
                    ViewModelStoreOwner PlaceComponentResult = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<HighlightTransactionPayRequestModel>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$payRequestModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HighlightTransactionPayRequestModel invoke() {
                return new HighlightTransactionPayRequestModel(null, null, null, null, null, 31, null);
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<SaveSubscriptionRequestModel>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$saveRequestModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SaveSubscriptionRequestModel invoke() {
                return new SaveSubscriptionRequestModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FragmentDigitalVoucherBottomSheetBinding fragmentDigitalVoucherBottomSheetBinding, NestedScrollView nestedScrollView, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragmentDigitalVoucherBottomSheetBinding, "");
        Intrinsics.checkNotNullParameter(nestedScrollView, "");
        if (i == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i < i2) {
            fragmentDigitalVoucherBottomSheetBinding.lookAheadTest.getDropDownPaymentType().closeDropDownButton();
        }
    }

    public static /* synthetic */ void getAuthRequestContext(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(digitalVoucherBottomSheetFragment, "");
        ((AddNewBillsViewModel) digitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).BuiltInFictitiousFunctionClassFactory(digitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(), false);
    }

    public static /* synthetic */ void PlaceComponentResult(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(digitalVoucherBottomSheetFragment, "");
        if (digitalVoucherBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2) {
            digitalVoucherBottomSheetFragment.MyBillsEntityDataFactory(MyBillsPurposeAction.PAY);
            ((AddNewBillsViewModel) digitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).MyBillsEntityDataFactory(digitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1());
            return;
        }
        ((AddNewBillsViewModel) digitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).BuiltInFictitiousFunctionClassFactory(digitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(), true);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment, SaveMyBillsSubscriptionModel saveMyBillsSubscriptionModel) {
        String subscriptionId = saveMyBillsSubscriptionModel.getSubscriptionId();
        if (subscriptionId != null) {
            digitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1().setSubscriptionId(subscriptionId);
            if (((HighlightTransactionPayRequestModel) digitalVoucherBottomSheetFragment.MyBillsEntityDataFactory.getValue()).getTransactionAmount() != null) {
                ((AddNewBillsViewModel) digitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).MyBillsEntityDataFactory((HighlightTransactionPayRequestModel) digitalVoucherBottomSheetFragment.MyBillsEntityDataFactory.getValue());
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment) {
        VB vb = digitalVoucherBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewFooterAddNewBillsBinding viewFooterAddNewBillsBinding = ((FragmentDigitalVoucherBottomSheetBinding) vb).moveToNextValue;
            if (digitalVoucherBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2) {
                DanaButtonPrimaryView danaButtonPrimaryView = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
                danaButtonPrimaryView.setVisibility(0);
                danaButtonPrimaryView.setEnabled(true);
                danaButtonPrimaryView.setActiveButton(digitalVoucherBottomSheetFragment.getString(R.string.my_bills_label_pay), null);
                DanaButtonSecondaryView danaButtonSecondaryView = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
                danaButtonSecondaryView.setVisibility(8);
                return;
            }
            DanaButtonPrimaryView danaButtonPrimaryView2 = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView2, "");
            danaButtonPrimaryView2.setVisibility(0);
            danaButtonPrimaryView2.setEnabled(true);
            danaButtonPrimaryView2.setActiveButton(digitalVoucherBottomSheetFragment.getString(R.string.my_bills_label_save_pay), null);
            DanaButtonSecondaryView danaButtonSecondaryView2 = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
            danaButtonSecondaryView2.setVisibility(0);
            danaButtonSecondaryView2.setEnabled(true);
            viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setActiveButton(digitalVoucherBottomSheetFragment.getString(R.string.res_0x7f130f59_summaryvoucherview_externalsyntheticlambda0), null);
            Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ HighlightTransactionPayRequestModel KClassImpl$Data$declaredNonStaticMembers$2(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment) {
        return (HighlightTransactionPayRequestModel) digitalVoucherBottomSheetFragment.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ AddNewBillsViewModel BuiltInFictitiousFunctionClassFactory(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment) {
        return (AddNewBillsViewModel) digitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment) {
        FragmentActivity requireActivity = digitalVoucherBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.hideBlockerLoading();
        }
    }

    public static final /* synthetic */ void moveToNextValue(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment) {
        FragmentActivity requireActivity = digitalVoucherBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.showBlockerLoading();
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment, boolean z) {
        String authRequestContext;
        MyBillsAnalyticTracker myBillsAnalyticTracker = digitalVoucherBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
        authRequestContext = MyBillsTrackerUtil.getAuthRequestContext(z, "");
        myBillsAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, digitalVoucherBottomSheetFragment.initRecordTimeStamp());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment, AddNewBillsUiState.OnSuccessSaveMyBills onSuccessSaveMyBills) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = digitalVoucherBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        String initRecordTimeStamp = digitalVoucherBottomSheetFragment.initRecordTimeStamp();
        MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
        myBillsAnalyticTracker.MyBillsEntityDataFactory(initRecordTimeStamp, MyBillsTrackerUtil.BuiltInFictitiousFunctionClassFactory(onSuccessSaveMyBills.MyBillsEntityDataFactory.getRecurringType()));
    }

    private final HighlightTransactionPayRequestModel NetworkUserEntityData$$ExternalSyntheticLambda1() {
        HighlightTransactionPayRequestModel highlightTransactionPayRequestModel = (HighlightTransactionPayRequestModel) this.MyBillsEntityDataFactory.getValue();
        BizProductModel bizProductModel = this.PlaceComponentResult;
        highlightTransactionPayRequestModel.setTransactionAmount(bizProductModel != null ? bizProductModel.getDenom() : null);
        highlightTransactionPayRequestModel.setPayMode("DIRECT");
        return highlightTransactionPayRequestModel;
    }

    private final SaveSubscriptionRequestModel NetworkUserEntityData$$ExternalSyntheticLambda2() {
        MoneyViewModel denom;
        MyBillsServiceModel serviceModel;
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            String billsName = ((FragmentDigitalVoucherBottomSheetBinding) vb).lookAheadTest.getBillsName();
            if (billsName.length() == 0) {
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    billsName = ((FragmentDigitalVoucherBottomSheetBinding) vb2).DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2.getText().toString();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            String str = billsName;
            VB vb3 = this.MyBillsEntityDataFactory;
            if (vb3 != 0) {
                Calendar kClassImpl$Data$declaredNonStaticMembers$2 = ((FragmentDigitalVoucherBottomSheetBinding) vb3).lookAheadTest.getKClassImpl$Data$declaredNonStaticMembers$2();
                BizProductModel bizProductModel = this.PlaceComponentResult;
                String goodsId = bizProductModel != null ? bizProductModel.getGoodsId() : null;
                VB vb4 = this.MyBillsEntityDataFactory;
                if (vb4 != 0) {
                    String selectedPaymentType = ((FragmentDigitalVoucherBottomSheetBinding) vb4).lookAheadTest.getSelectedPaymentType();
                    SaveSubscriptionRequestModel saveSubscriptionRequestModel = (SaveSubscriptionRequestModel) this.getAuthRequestContext.getValue();
                    saveSubscriptionRequestModel.setTitle(str);
                    BizProductModel bizProductModel2 = this.PlaceComponentResult;
                    saveSubscriptionRequestModel.setGoodsId(bizProductModel2 != null ? bizProductModel2.getGoodsId() : null);
                    saveSubscriptionRequestModel.setBillerId(goodsId);
                    saveSubscriptionRequestModel.setRecurringType(selectedPaymentType);
                    BizProductModel bizProductModel3 = this.PlaceComponentResult;
                    saveSubscriptionRequestModel.setBizType((bizProductModel3 == null || (serviceModel = bizProductModel3.getServiceModel()) == null) ? null : serviceModel.getBizType());
                    saveSubscriptionRequestModel.setMessage(str);
                    saveSubscriptionRequestModel.setSubscriptionDayOfMonth(String.valueOf(kClassImpl$Data$declaredNonStaticMembers$2.get(5)));
                    saveSubscriptionRequestModel.setSubscriptionHourOfDay(String.valueOf(kClassImpl$Data$declaredNonStaticMembers$2.get(11)));
                    saveSubscriptionRequestModel.setSubscriptionMonthOfYear(String.valueOf(kClassImpl$Data$declaredNonStaticMembers$2.get(2)));
                    saveSubscriptionRequestModel.setSubscriptionIntervalType(SubscriptionIntervalType.MONTHLY);
                    BizProductModel bizProductModel4 = this.PlaceComponentResult;
                    saveSubscriptionRequestModel.setType(bizProductModel4 != null ? bizProductModel4.getGoodsType() : null);
                    saveSubscriptionRequestModel.setTimezone(TimeZone.getDefault().getDisplayName(false, 0));
                    saveSubscriptionRequestModel.setPayMode(Intrinsics.areEqual(selectedPaymentType, RecurringType.REMINDER) ? "DIRECT" : "AUTO_DEBIT");
                    saveSubscriptionRequestModel.setPaymentMethod("BALANCE");
                    BizProductModel bizProductModel5 = this.PlaceComponentResult;
                    saveSubscriptionRequestModel.setDenom(bizProductModel5 != null ? bizProductModel5.getDenom() : null);
                    BizProductModel bizProductModel6 = this.PlaceComponentResult;
                    saveSubscriptionRequestModel.setTotalAmount(bizProductModel6 != null ? bizProductModel6.getDenom() : null);
                    BizProductModel bizProductModel7 = this.PlaceComponentResult;
                    saveSubscriptionRequestModel.setProductTitle(bizProductModel7 != null ? bizProductModel7.getGoodsTitle() : null);
                    BizProductModel bizProductModel8 = this.PlaceComponentResult;
                    saveSubscriptionRequestModel.setExtendInfoTitle((bizProductModel8 == null || (denom = bizProductModel8.getDenom()) == null) ? null : denom.getDisplayAmount());
                    BizProductModel bizProductModel9 = this.PlaceComponentResult;
                    Map<String, Object> extendInfo = bizProductModel9 != null ? bizProductModel9.getExtendInfo() : null;
                    if (extendInfo == null) {
                        extendInfo = MapsKt.emptyMap();
                    }
                    saveSubscriptionRequestModel.setExtendInfo(extendInfo);
                    return saveSubscriptionRequestModel;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void MyBillsEntityDataFactory(String p0) {
        MyBillsServiceModel serviceModel;
        String source;
        MyBillsAnalyticTracker myBillsAnalyticTracker = this.myBillsAnalyticTracker;
        String str = "";
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        String initRecordTimeStamp = initRecordTimeStamp();
        BizProductModel bizProductModel = this.PlaceComponentResult;
        if (bizProductModel == null || (serviceModel = bizProductModel.getServiceModel()) == null || (source = serviceModel.getSource()) == null) {
            MyBillsServiceModel myBillsServiceModel = this.BuiltInFictitiousFunctionClassFactory;
            String source2 = myBillsServiceModel != null ? myBillsServiceModel.getSource() : null;
            if (source2 != null) {
                str = source2;
            }
        } else {
            str = source;
        }
        myBillsAnalyticTracker.MyBillsEntityDataFactory(initRecordTimeStamp, str, p0);
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final ConstraintLayout scheduleImpl() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ConstraintLayout constraintLayout = ((FragmentDigitalVoucherBottomSheetBinding) vb).moveToNextValue.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        return constraintLayout;
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final ViewHeaderDetailBillsBinding NetworkUserEntityData$$ExternalSyntheticLambda0() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewHeaderDetailBillsBinding viewHeaderDetailBillsBinding = ((FragmentDigitalVoucherBottomSheetBinding) vb).DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(viewHeaderDetailBillsBinding, "");
            return viewHeaderDetailBillsBinding;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final NestedScrollView moveToNextValue() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            NestedScrollView nestedScrollView = ((FragmentDigitalVoucherBottomSheetBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
            return nestedScrollView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final MyBillsToolbarView GetContactSyncConfig() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            MyBillsToolbarView myBillsToolbarView = ((FragmentDigitalVoucherBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(myBillsToolbarView, "");
            return myBillsToolbarView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            RelativeLayout relativeLayout = ((FragmentDigitalVoucherBottomSheetBinding) vb).getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
            return relativeLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
