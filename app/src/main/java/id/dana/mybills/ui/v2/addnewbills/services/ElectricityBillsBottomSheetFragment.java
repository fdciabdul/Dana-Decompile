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
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentElectricityBottomSheetBinding;
import id.dana.mybills.databinding.ViewBodyElectricityMyBillsBinding;
import id.dana.mybills.databinding.ViewFooterAddNewBillsBinding;
import id.dana.mybills.databinding.ViewHeaderDetailBillsBinding;
import id.dana.mybills.di.component.MyBillsComponent;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.di.provider.MyBillsComponentProvider;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.FormModel;
import id.dana.mybills.domain.model.ProductGoodsInfo;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.ui.constant.FormValidatorKey;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.constant.SubscriptionIntervalType;
import id.dana.mybills.ui.customview.BodySaveToBillsView;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.CustomEditTextView;
import id.dana.mybills.ui.customview.CustomerIDProviderView;
import id.dana.mybills.ui.customview.MyBillsToolbarView;
import id.dana.mybills.ui.model.BillPaymentStatusModelKt;
import id.dana.mybills.ui.model.BizProductModel;
import id.dana.mybills.ui.model.DropdownOptionsModel;
import id.dana.mybills.ui.model.DropdownOptionsModelKt;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.model.MyBillsServiceModel;
import id.dana.mybills.ui.model.SaveMyBillsSubscriptionModel;
import id.dana.mybills.ui.model.SaveSubscriptionRequestModel;
import id.dana.mybills.ui.v2.MyBillsHomeActivity;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel;
import id.dana.mybills.utils.AddNewBillsUtils;
import id.dana.mybills.utils.MyBillsTrackerUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020:H\u0002J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u00020:H\u0002J\u0010\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\u0007H\u0002J\b\u0010D\u001a\u00020EH\u0014J\b\u0010F\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020HH\u0014J\b\u0010I\u001a\u00020#H\u0002J\b\u0010J\u001a\u00020)H\u0002J\b\u0010K\u001a\u00020LH\u0014J\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020OH\u0014J\b\u0010P\u001a\u00020QH\u0014J\u0010\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020:H\u0002J\u001a\u0010V\u001a\u00020\u00022\u0006\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010[\u001a\u00020:H\u0014J\b\u0010\\\u001a\u00020:H\u0002J\b\u0010]\u001a\u00020:H\u0002J\b\u0010^\u001a\u00020:H\u0002J\b\u0010_\u001a\u00020:H\u0002J\b\u0010`\u001a\u00020:H\u0002J\b\u0010a\u001a\u00020:H\u0003J\b\u0010b\u001a\u00020:H\u0002J\b\u0010c\u001a\u00020:H\u0002J\b\u0010d\u001a\u00020:H\u0002J\b\u0010e\u001a\u00020:H\u0002J\b\u0010f\u001a\u00020\fH\u0002J\b\u0010g\u001a\u00020\fH\u0002J\b\u0010h\u001a\u00020\fH\u0002J\b\u0010i\u001a\u00020\fH\u0002J\b\u0010j\u001a\u00020\fH\u0002J\u0010\u0010k\u001a\u00020:2\u0006\u0010l\u001a\u00020mH\u0002J\u0016\u0010n\u001a\u00020:2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0012\u0010p\u001a\u00020:2\b\b\u0002\u0010q\u001a\u00020\fH\u0002J\b\u0010r\u001a\u00020:H\u0002J\b\u0010s\u001a\u00020:H\u0002J\b\u0010t\u001a\u00020:H\u0002J\b\u0010u\u001a\u00020:H\u0002J\u001a\u0010v\u001a\u00020:2\u0006\u0010w\u001a\u00020\f2\b\b\u0002\u0010x\u001a\u00020\u0007H\u0002J\u0010\u0010y\u001a\u00020:2\u0006\u0010z\u001a\u00020\u0007H\u0002J\u0010\u0010{\u001a\u00020:2\u0006\u0010|\u001a\u00020}H\u0002J\b\u0010~\u001a\u00020:H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010'\u001a\u0004\b6\u00107¨\u0006\u007f"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/services/ElectricityBillsBottomSheetFragment;", "Lid/dana/mybills/ui/v2/addnewbills/services/BaseMyBillsBottomSheet;", "Lid/dana/mybills/databinding/FragmentElectricityBottomSheetBinding;", "()V", "bizProductModel", "Lid/dana/mybills/ui/model/BizProductModel;", "customerId", "", "electricityProducts", "", "Lid/dana/mybills/domain/model/ProductGoodsInfo;", "isAddToMyBillsChecked", "", "isAllRequiredValuesValid", "value", "isHasActiveBills", "setHasActiveBills", "(Z)V", "isHasBillsToPay", "setHasBillsToPay", "isNoErrorBill", "isViewBillOnly", "job", "Lkotlinx/coroutines/Job;", "myBillsAnalyticTracker", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "getMyBillsAnalyticTracker", "()Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "setMyBillsAnalyticTracker", "(Lid/dana/mybills/tracker/MyBillsAnalyticTracker;)V", "myBillsComponent", "Lid/dana/mybills/di/component/MyBillsComponent;", "myBillsServiceModel", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "payRequestModel", "Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "getPayRequestModel", "()Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "payRequestModel$delegate", "Lkotlin/Lazy;", "saveRequestModel", "Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "selectedAmount", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "selectedGoodsId", "serviceType", "viewModelFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/mybills/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/mybills/di/module/ViewModelFactory;)V", "vm", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "getVm", "()Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "vm$delegate", "actionPaySingleBill", "", "saveSubscriptionModel", "Lid/dana/mybills/ui/model/SaveMyBillsSubscriptionModel;", "checkPayButtonState", "constructFormValidatorSaveBills", "Lid/dana/mybills/domain/model/FormModel;", "constructFormValidatorSinglePay", "getBundleArgument", "getDateRangeBill", "goodType", "getFooterMyBills", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getGoodsId", "getHeader", "Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "getPaySingleRequestModel", "getSaveRequest", "getScrollContainer", "Landroidx/core/widget/NestedScrollView;", "getServiceName", "getToolbar", "Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "getViewBottomSheet", "Landroid/view/View;", "handleDataDetailInquiryPrepaid", "data", "Lid/dana/mybills/domain/model/BizProductDestination;", "hideBlockerLoading", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", BranchLinkConstant.PathTarget.CONTAINER, "Landroid/view/ViewGroup;", IAPSyncCommand.COMMAND_INIT, "initButtonView", "initCustomerDetailsView", "initCustomerIdView", "initDropdownView", "initInjector", "initLifecycleActivity", "initOnScrollBottomSheet", "initRecentTransactionView", "initSwitchButton", "initViews", "isCanPaySingleBill", "isUserCanOnlyPayBills", "isUserCanOnlySaveBills", "isUserCanOnlyViewBill", "isUserCanSaveAndPayBills", "mapDataUserBalance", "amount", "Lid/dana/core/ui/model/CurrencyAmountModel;", "mappingProduct", "products", "resetUI", "isNeedToClearText", "setAutofillAmountRecentTransactionElectricityPrepaid", "setCustomerIDLoadingInvisible", "setErrorMessage", "showBlockerLoading", "trackCheckStatusProductId", "isBillActive", "inquiryResultCode", "trackCreateDetailOpen", "action", "trackMyBillCreateSuccess", "state", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessSaveMyBills;", "validateForm", "feature-mybills_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ElectricityBillsBottomSheetFragment extends BaseMyBillsBottomSheet<FragmentElectricityBottomSheetBinding> {
    private boolean DatabaseTableConfigUtil;
    private final Lazy FragmentBottomSheetPaymentSettingBinding;
    private boolean GetContactSyncConfig;
    private List<ProductGoodsInfo> KClassImpl$Data$declaredNonStaticMembers$2;
    private BizProductModel MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private String NetworkUserEntityData$$ExternalSyntheticLambda3;
    private DropdownOptionsModel NetworkUserEntityData$$ExternalSyntheticLambda4;
    private String NetworkUserEntityData$$ExternalSyntheticLambda5;
    private SaveSubscriptionRequestModel NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda7;
    private MyBillsComponent NetworkUserEntityData$$ExternalSyntheticLambda8;
    private String PlaceComponentResult;
    private Job PrepareContext;
    private boolean initRecordTimeStamp;
    private MyBillsServiceModel isLayoutRequested;
    @Inject
    public MyBillsAnalyticTracker myBillsAnalyticTracker;
    private boolean newProxyInstance;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ ViewBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentElectricityBottomSheetBinding MyBillsEntityDataFactory = FragmentElectricityBottomSheetBinding.MyBillsEntityDataFactory(getLayoutInflater(), viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet, id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        Object obj;
        Parcelable parcelable;
        Parcelable parcelable2;
        super.getAuthRequestContext();
        String string = getString(R.string.my_bills_label_add_new_bills);
        Intrinsics.checkNotNullExpressionValue(string, "");
        super.getAuthRequestContext(string, R.drawable.res_0x7f08086b_networkuserentitydata_externalsyntheticlambda2, new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$init$1
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
                FragmentKt.getAuthRequestContext(ElectricityBillsBottomSheetFragment.this).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        super.getAuthRequestContext("BUNDLE_KEY_ELECTRICITY");
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable("BUNDLE_KEY_ELECTRICITY", MyBillsServiceModel.class);
            } else {
                Parcelable parcelable3 = arguments.getParcelable("BUNDLE_KEY_ELECTRICITY");
                if (!(parcelable3 instanceof MyBillsServiceModel)) {
                    parcelable3 = null;
                }
                parcelable = (MyBillsServiceModel) parcelable3;
            }
            this.isLayoutRequested = (MyBillsServiceModel) parcelable;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable2 = (Parcelable) arguments.getParcelable("BUNDLE_KEY_PRODUCT", BizProductModel.class);
            } else {
                Parcelable parcelable4 = arguments.getParcelable("BUNDLE_KEY_PRODUCT");
                if (!(parcelable4 instanceof BizProductModel)) {
                    parcelable4 = null;
                }
                parcelable2 = (BizProductModel) parcelable4;
            }
            this.MyBillsEntityDataFactory = (BizProductModel) parcelable2;
        }
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.mybills.di.provider.MyBillsComponentProvider");
        }
        MyBillsComponent authRequestContext = ((MyBillsComponentProvider) applicationContext).provideMyBillsComponent().getAuthRequestContext();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = authRequestContext;
        authRequestContext.PlaceComponentResult(this);
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            BodySaveToBillsView bodySaveToBillsView = ((FragmentElectricityBottomSheetBinding) vb).MyBillsEntityDataFactory;
            bodySaveToBillsView.setToggleSaveToMyBillsVisible(false);
            bodySaveToBillsView.setIsSaveToMyBillsActive(false);
            bodySaveToBillsView.setOnToggleCheckedChanged(new BodySaveToBillsView.OnToggleAddToMyBillsChecked() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$initSwitchButton$1$1
                @Override // id.dana.mybills.ui.customview.BodySaveToBillsView.OnToggleAddToMyBillsChecked
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                    ElectricityBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
                    ElectricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(ElectricityBillsBottomSheetFragment.this);
                }
            });
            bodySaveToBillsView.setSwitchAddToMyBillsChecked(false);
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                final ViewBodyElectricityMyBillsBinding viewBodyElectricityMyBillsBinding = ((FragmentElectricityBottomSheetBinding) vb2).moveToNextValue;
                final CustomDropdownView customDropdownView = viewBodyElectricityMyBillsBinding.BuiltInFictitiousFunctionClassFactory;
                String string2 = getString(R.string.my_bills_label_service_type);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                customDropdownView.setTitle(string2);
                String string3 = getString(R.string.res_0x7f130f47_verifypinstatemanager_executeriskchallenge_2_2);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                customDropdownView.setHintDropdown(string3);
                AddNewBillsUtils addNewBillsUtils = AddNewBillsUtils.INSTANCE;
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                customDropdownView.setOptions(AddNewBillsUtils.BuiltInFictitiousFunctionClassFactory(requireContext));
                customDropdownView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ElectricityBillsBottomSheetFragment.PlaceComponentResult(ElectricityBillsBottomSheetFragment.this, customDropdownView);
                    }
                });
                customDropdownView.setListenerItemSelected(new CustomDropdownView.OnItemSelectedListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$initDropdownView$1$1$2
                    @Override // id.dana.mybills.ui.customview.CustomDropdownView.OnItemSelectedListener
                    public final void BuiltInFictitiousFunctionClassFactory(DropdownOptionsModel p0) {
                        String str;
                        List list;
                        String DatabaseTableConfigUtil;
                        Intrinsics.checkNotNullParameter(p0, "");
                        str = ElectricityBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        if (Intrinsics.areEqual(str, p0.getId())) {
                            return;
                        }
                        viewBodyElectricityMyBillsBinding.getAuthRequestContext.setCustomerIDEnable(true);
                        ElectricityBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5 = String.valueOf(p0.getId());
                        VB vb3 = ElectricityBillsBottomSheetFragment.this.MyBillsEntityDataFactory;
                        if (vb3 != 0) {
                            ((FragmentElectricityBottomSheetBinding) vb3).MyBillsEntityDataFactory.setDefaultValue();
                            list = ElectricityBillsBottomSheetFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                            if ((!list.isEmpty()) != false) {
                                ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment = ElectricityBillsBottomSheetFragment.this;
                                DatabaseTableConfigUtil = electricityBillsBottomSheetFragment.DatabaseTableConfigUtil();
                                electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 = DatabaseTableConfigUtil;
                            }
                            ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment2 = ElectricityBillsBottomSheetFragment.this;
                            String id2 = p0.getId();
                            ((AddNewBillsViewModel) electricityBillsBottomSheetFragment2.FragmentBottomSheetPaymentSettingBinding.getValue()).BuiltInFictitiousFunctionClassFactory(id2 != null ? id2 : "");
                            ElectricityBillsBottomSheetFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(true);
                            ElectricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(ElectricityBillsBottomSheetFragment.this);
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                });
                final CustomDropdownView customDropdownView2 = viewBodyElectricityMyBillsBinding.MyBillsEntityDataFactory;
                String string4 = getString(R.string.my_bills_label_amount);
                Intrinsics.checkNotNullExpressionValue(string4, "");
                customDropdownView2.setTitle(string4);
                String string5 = getString(R.string.my_bills_label_choose_amount);
                Intrinsics.checkNotNullExpressionValue(string5, "");
                customDropdownView2.setHintDropdown(string5);
                customDropdownView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ElectricityBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(CustomDropdownView.this);
                    }
                });
                customDropdownView2.setListenerItemSelected(new CustomDropdownView.OnItemSelectedListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$initDropdownView$1$2$2
                    @Override // id.dana.mybills.ui.customview.CustomDropdownView.OnItemSelectedListener
                    public final void BuiltInFictitiousFunctionClassFactory(DropdownOptionsModel p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        ElectricityBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda4 = p0;
                        ElectricityBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3 = String.valueOf(p0.getId());
                        ElectricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(ElectricityBillsBottomSheetFragment.this);
                    }
                });
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    final ViewBodyElectricityMyBillsBinding viewBodyElectricityMyBillsBinding2 = ((FragmentElectricityBottomSheetBinding) vb3).moveToNextValue;
                    CustomEditTextView customEditTextView = viewBodyElectricityMyBillsBinding2.KClassImpl$Data$declaredNonStaticMembers$2;
                    String string6 = getString(R.string.my_bills_label_customer_name);
                    Intrinsics.checkNotNullExpressionValue(string6, "");
                    customEditTextView.setLabelText(string6);
                    CustomEditTextView customEditTextView2 = viewBodyElectricityMyBillsBinding2.PlaceComponentResult;
                    customEditTextView2.addTextChangeListener(new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$initCustomerDetailsView$1$2$1
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
                            ElectricityBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new DropdownOptionsModel(null, null, null, BillPaymentStatusModelKt.toMoneyViewModel(viewBodyElectricityMyBillsBinding2.PlaceComponentResult.getText()), null, 23, null);
                        }
                    });
                    String string7 = getString(R.string.my_bills_label_amount);
                    Intrinsics.checkNotNullExpressionValue(string7, "");
                    customEditTextView2.setLabelText(string7);
                    VB vb4 = this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        CustomerIDProviderView customerIDProviderView = ((FragmentElectricityBottomSheetBinding) vb4).moveToNextValue.getAuthRequestContext;
                        customerIDProviderView.setCustomerIDEnable(false);
                        customerIDProviderView.setListenerTextChanged(new CustomerIDProviderView.OnTextChangedListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$initCustomerIdView$1$1
                            @Override // id.dana.mybills.ui.customview.CustomerIDProviderView.OnTextChangedListener
                            public final void MyBillsEntityDataFactory(String p0) {
                                String str;
                                String str2;
                                Intrinsics.checkNotNullParameter(p0, "");
                                ElectricityBillsBottomSheetFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(false);
                                ElectricityBillsBottomSheetFragment.this.PlaceComponentResult = p0;
                                if (p0.length() > 0) {
                                    AddNewBillsViewModel DatabaseTableConfigUtil = ElectricityBillsBottomSheetFragment.DatabaseTableConfigUtil(ElectricityBillsBottomSheetFragment.this);
                                    str = ElectricityBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                                    str2 = ElectricityBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                                    DatabaseTableConfigUtil.MyBillsEntityDataFactory(str, p0, str2);
                                    return;
                                }
                                ElectricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(ElectricityBillsBottomSheetFragment.this);
                            }
                        });
                        VB vb5 = this.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentElectricityBottomSheetBinding) vb5).NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
                            danaButtonPrimaryView.setEnabled(false);
                            danaButtonPrimaryView.setDisabled(getString(R.string.my_bills_label_pay));
                            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$$ExternalSyntheticLambda3
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    ElectricityBillsBottomSheetFragment.PlaceComponentResult(ElectricityBillsBottomSheetFragment.this);
                                }
                            });
                            VB vb6 = this.MyBillsEntityDataFactory;
                            if (vb6 != 0) {
                                ((FragmentElectricityBottomSheetBinding) vb6).NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$$ExternalSyntheticLambda4
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        ElectricityBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(ElectricityBillsBottomSheetFragment.this);
                                    }
                                });
                                VB vb7 = this.MyBillsEntityDataFactory;
                                if (vb7 != 0) {
                                    ((FragmentElectricityBottomSheetBinding) vb7).MyBillsEntityDataFactory.setOnIconInfoClick(new Function1<View, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$initButtonView$3
                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(View view) {
                                            Intrinsics.checkNotNullParameter(view, "");
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                                            invoke2(view);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    VB vb8 = this.MyBillsEntityDataFactory;
                                    if (vb8 != 0) {
                                        ViewBodyElectricityMyBillsBinding viewBodyElectricityMyBillsBinding3 = ((FragmentElectricityBottomSheetBinding) vb8).moveToNextValue;
                                        BizProductModel bizProductModel = this.MyBillsEntityDataFactory;
                                        if (bizProductModel != null) {
                                            Iterator<T> it = viewBodyElectricityMyBillsBinding3.BuiltInFictitiousFunctionClassFactory.getItemOptions().iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    obj = null;
                                                    break;
                                                }
                                                obj = it.next();
                                                if (Intrinsics.areEqual(((DropdownOptionsModel) obj).getId(), bizProductModel.getGoodsType())) {
                                                    break;
                                                }
                                            }
                                            DropdownOptionsModel dropdownOptionsModel = (DropdownOptionsModel) obj;
                                            if (dropdownOptionsModel != null) {
                                                viewBodyElectricityMyBillsBinding3.BuiltInFictitiousFunctionClassFactory.setSelected(dropdownOptionsModel);
                                            }
                                            viewBodyElectricityMyBillsBinding3.getAuthRequestContext.getText().setText(bizProductModel.getBizId());
                                        }
                                        VB vb9 = this.MyBillsEntityDataFactory;
                                        if (vb9 != 0) {
                                            final FragmentElectricityBottomSheetBinding fragmentElectricityBottomSheetBinding = (FragmentElectricityBottomSheetBinding) vb9;
                                            fragmentElectricityBottomSheetBinding.BuiltInFictitiousFunctionClassFactory.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$$ExternalSyntheticLambda0
                                                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                                                public final void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                                                    ElectricityBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(FragmentElectricityBottomSheetBinding.this, nestedScrollView, i2, i4);
                                                }
                                            });
                                            StateFlow<AddNewBillsUiState> stateFlow = ((AddNewBillsViewModel) this.FragmentBottomSheetPaymentSettingBinding.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda8;
                                            Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
                                            Intrinsics.checkNotNullExpressionValue(lifecycle, "");
                                            Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new ElectricityBillsBottomSheetFragment$initLifecycleActivity$1(this, null));
                                            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
                                            FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
                                            ((AddNewBillsViewModel) this.FragmentBottomSheetPaymentSettingBinding.getValue()).MyBillsEntityDataFactory();
                                            ((AddNewBillsViewModel) this.FragmentBottomSheetPaymentSettingBinding.getValue()).PlaceComponentResult("ELECTRICITY");
                                            return;
                                        }
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final String NetworkUserEntityData$$ExternalSyntheticLambda2() {
        MyBillsServiceModel serviceModel;
        String name;
        BizProductModel bizProductModel = this.MyBillsEntityDataFactory;
        if (bizProductModel == null || (serviceModel = bizProductModel.getServiceModel()) == null || (name = serviceModel.getName()) == null) {
            MyBillsServiceModel myBillsServiceModel = this.isLayoutRequested;
            String name2 = myBillsServiceModel != null ? myBillsServiceModel.getName() : null;
            return name2 == null ? "" : name2;
        }
        return name;
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return !this.GetContactSyncConfig && this.DatabaseTableConfigUtil && this.initRecordTimeStamp;
    }

    private final boolean PrepareContext() {
        return this.GetContactSyncConfig && this.DatabaseTableConfigUtil && !this.NetworkUserEntityData$$ExternalSyntheticLambda2 && this.initRecordTimeStamp;
    }

    private final boolean newProxyInstance() {
        return (this.GetContactSyncConfig || this.DatabaseTableConfigUtil || !this.initRecordTimeStamp) ? false : true;
    }

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from getter */
    private final boolean getNewProxyInstance() {
        return this.newProxyInstance;
    }

    public final String DatabaseTableConfigUtil() {
        Object obj;
        Iterator<T> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ProductGoodsInfo) obj).getType(), this.NetworkUserEntityData$$ExternalSyntheticLambda5)) {
                break;
            }
        }
        ProductGoodsInfo productGoodsInfo = (ProductGoodsInfo) obj;
        return String.valueOf(productGoodsInfo != null ? productGoodsInfo.getGoodsId() : null);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.jvm.functions.Function0, java.lang.Integer] */
    public ElectricityBillsBottomSheetFragment() {
        final ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = ElectricityBillsBottomSheetFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        final ?? r6 = 0;
        this.FragmentBottomSheetPaymentSettingBinding = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(electricityBillsBottomSheetFragment, Reflection.getOrCreateKotlinClass(AddNewBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function03 = Function0.this;
                if (function03 == null || (creationExtras = (CreationExtras) function03.invoke()) == null) {
                    ViewModelStoreOwner PlaceComponentResult = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new DropdownOptionsModel(null, null, null, null, r6, 31, null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = LazyKt.lazy(new Function0<HighlightTransactionPayRequestModel>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$payRequestModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HighlightTransactionPayRequestModel invoke() {
                return new HighlightTransactionPayRequestModel(null, null, null, null, null, 31, null);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();
        this.PlaceComponentResult = "";
    }

    public static /* synthetic */ void PlaceComponentResult(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment, CustomDropdownView customDropdownView) {
        Intrinsics.checkNotNullParameter(electricityBillsBottomSheetFragment, "");
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        if ((!electricityBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) == true) {
            customDropdownView.showOptions(!customDropdownView.isOptionsVisible());
        }
    }

    public static /* synthetic */ void PlaceComponentResult(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(electricityBillsBottomSheetFragment, "");
        if (electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
            electricityBillsBottomSheetFragment.PlaceComponentResult(MyBillsPurposeAction.PAY);
            AddNewBillsViewModel addNewBillsViewModel = (AddNewBillsViewModel) electricityBillsBottomSheetFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
            HighlightTransactionPayRequestModel highlightTransactionPayRequestModel = (HighlightTransactionPayRequestModel) electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
            highlightTransactionPayRequestModel.setTransactionAmount(electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getPrice());
            highlightTransactionPayRequestModel.setPayMode("DIRECT");
            addNewBillsViewModel.MyBillsEntityDataFactory(highlightTransactionPayRequestModel);
            return;
        }
        ((AddNewBillsViewModel) electricityBillsBottomSheetFragment.FragmentBottomSheetPaymentSettingBinding.getValue()).BuiltInFictitiousFunctionClassFactory(electricityBillsBottomSheetFragment.initRecordTimeStamp(), true);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FragmentElectricityBottomSheetBinding fragmentElectricityBottomSheetBinding, NestedScrollView nestedScrollView, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragmentElectricityBottomSheetBinding, "");
        Intrinsics.checkNotNullParameter(nestedScrollView, "");
        if (i == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i < i2) {
            fragmentElectricityBottomSheetBinding.MyBillsEntityDataFactory.getDropDownPaymentType().closeDropDownButton();
        }
        fragmentElectricityBottomSheetBinding.moveToNextValue.BuiltInFictitiousFunctionClassFactory.closeDropDownButton();
        fragmentElectricityBottomSheetBinding.moveToNextValue.MyBillsEntityDataFactory.closeDropDownButton();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CustomDropdownView customDropdownView) {
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        customDropdownView.showOptions(!customDropdownView.isOptionsVisible());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(electricityBillsBottomSheetFragment, "");
        if (electricityBillsBottomSheetFragment.getNewProxyInstance()) {
            ((AddNewBillsViewModel) electricityBillsBottomSheetFragment.FragmentBottomSheetPaymentSettingBinding.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(((HighlightTransactionPayRequestModel) electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue()).getSubscriptionId());
        } else {
            ((AddNewBillsViewModel) electricityBillsBottomSheetFragment.FragmentBottomSheetPaymentSettingBinding.getValue()).BuiltInFictitiousFunctionClassFactory(electricityBillsBottomSheetFragment.initRecordTimeStamp(), false);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment, SaveMyBillsSubscriptionModel saveMyBillsSubscriptionModel) {
        String subscriptionId = saveMyBillsSubscriptionModel.getSubscriptionId();
        if (subscriptionId != null) {
            HighlightTransactionPayRequestModel highlightTransactionPayRequestModel = (HighlightTransactionPayRequestModel) electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
            highlightTransactionPayRequestModel.setTransactionAmount(electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getPrice());
            highlightTransactionPayRequestModel.setPayMode("DIRECT");
            highlightTransactionPayRequestModel.setSubscriptionId(subscriptionId);
            if (((HighlightTransactionPayRequestModel) electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue()).getTransactionAmount() != null) {
                ((AddNewBillsViewModel) electricityBillsBottomSheetFragment.FragmentBottomSheetPaymentSettingBinding.getValue()).MyBillsEntityDataFactory((HighlightTransactionPayRequestModel) electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue());
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        VB vb = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewFooterAddNewBillsBinding viewFooterAddNewBillsBinding = ((FragmentElectricityBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (electricityBillsBottomSheetFragment.getNewProxyInstance()) {
                DanaButtonSecondaryView danaButtonSecondaryView = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
                danaButtonSecondaryView.setVisibility(0);
                viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setEnabled(true);
                viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setActiveButton(electricityBillsBottomSheetFragment.getString(R.string.my_bills_label_view_bill), null);
                DanaButtonPrimaryView danaButtonPrimaryView = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
                danaButtonPrimaryView.setVisibility(8);
                return;
            } else if (electricityBillsBottomSheetFragment.PrepareContext()) {
                DanaButtonPrimaryView danaButtonPrimaryView2 = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView2, "");
                danaButtonPrimaryView2.setVisibility(0);
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(true);
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(electricityBillsBottomSheetFragment.getString(R.string.my_bills_label_pay), null);
                DanaButtonSecondaryView danaButtonSecondaryView2 = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
                danaButtonSecondaryView2.setVisibility(8);
                return;
            } else if (electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                DanaButtonPrimaryView danaButtonPrimaryView3 = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView3, "");
                danaButtonPrimaryView3.setVisibility(0);
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1);
                DanaButtonSecondaryView danaButtonSecondaryView3 = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView3, "");
                danaButtonSecondaryView3.setVisibility(electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 ? 0 : 8);
                viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setEnabled(electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1);
                boolean z = electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (z && electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(electricityBillsBottomSheetFragment.getString(R.string.my_bills_label_save_pay), null);
                    viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setActiveButton(electricityBillsBottomSheetFragment.getString(R.string.res_0x7f130f59_summaryvoucherview_externalsyntheticlambda0), null);
                    return;
                } else if (z && !electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(electricityBillsBottomSheetFragment.getString(R.string.my_bills_label_pay), null);
                    return;
                } else if (!z && electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(electricityBillsBottomSheetFragment.getString(R.string.my_bills_label_save_pay));
                    viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setDisabled(electricityBillsBottomSheetFragment.getString(R.string.res_0x7f130f59_summaryvoucherview_externalsyntheticlambda0));
                    return;
                } else {
                    viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(electricityBillsBottomSheetFragment.getString(R.string.my_bills_label_pay));
                    return;
                }
            } else if (electricityBillsBottomSheetFragment.newProxyInstance()) {
                DanaButtonPrimaryView danaButtonPrimaryView4 = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView4, "");
                danaButtonPrimaryView4.setVisibility(8);
                DanaButtonSecondaryView danaButtonSecondaryView4 = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                danaButtonSecondaryView4.setActiveButton(electricityBillsBottomSheetFragment.getString(R.string.my_bills_label_save_bill), null);
                danaButtonSecondaryView4.setEnabled(true);
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView4, "");
                danaButtonSecondaryView4.setVisibility(0);
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView4, "");
                return;
            } else {
                DanaButtonPrimaryView danaButtonPrimaryView5 = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView5, "");
                danaButtonPrimaryView5.setVisibility(0);
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(electricityBillsBottomSheetFragment.getString(R.string.my_bills_label_pay));
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(false);
                DanaButtonSecondaryView danaButtonSecondaryView5 = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView5, "");
                danaButtonSecondaryView5.setVisibility(8);
                return;
            }
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ FormModel BuiltInFictitiousFunctionClassFactory(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        String value;
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to(FormValidatorKey.DROPDOWN_SERVICE_TYPE, electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda5);
        VB vb = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            pairArr[1] = TuplesKt.to(FormValidatorKey.CUSTOMER_ID, ((FragmentElectricityBottomSheetBinding) vb).moveToNextValue.getAuthRequestContext.m2682getText());
            VB vb2 = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                pairArr[2] = TuplesKt.to(FormValidatorKey.CUSTOMER_NAME, ((FragmentElectricityBottomSheetBinding) vb2).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.getText());
                if (Intrinsics.areEqual(electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda5, "ELECTRICITY_POST")) {
                    MoneyViewModel price = electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getPrice();
                    value = String.valueOf(price != null ? price.getDisplayAmount() : null);
                } else {
                    value = electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
                    if (value == null) {
                        value = "";
                    }
                }
                pairArr[3] = TuplesKt.to(FormValidatorKey.AMOUNT, value);
                VB vb3 = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    pairArr[4] = TuplesKt.to(FormValidatorKey.BILLS_DATE, ((FragmentElectricityBottomSheetBinding) vb3).MyBillsEntityDataFactory.getSelectedDate());
                    VB vb4 = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        pairArr[5] = TuplesKt.to(FormValidatorKey.BILLS_PAYMENT_TYPE, ((FragmentElectricityBottomSheetBinding) vb4).MyBillsEntityDataFactory.getSelectedPaymentType());
                        return new FormModel(MapsKt.mapOf(pairArr), MapsKt.mapOf(TuplesKt.to(FormValidatorKey.DROPDOWN_SERVICE_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSaveBills$1
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(String str) {
                                Intrinsics.checkNotNullParameter(str, "");
                                return Boolean.valueOf(!StringsKt.isBlank(str));
                            }
                        })), TuplesKt.to(FormValidatorKey.CUSTOMER_ID, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSaveBills$2
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(String str) {
                                Intrinsics.checkNotNullParameter(str, "");
                                return Boolean.valueOf(!StringsKt.isBlank(str));
                            }
                        })), TuplesKt.to(FormValidatorKey.CUSTOMER_NAME, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSaveBills$3
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(String str) {
                                Intrinsics.checkNotNullParameter(str, "");
                                return Boolean.valueOf(!StringsKt.isBlank(str));
                            }
                        })), TuplesKt.to(FormValidatorKey.AMOUNT, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSaveBills$4
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(String str) {
                                Intrinsics.checkNotNullParameter(str, "");
                                return Boolean.valueOf(!StringsKt.isBlank(str));
                            }
                        })), TuplesKt.to(FormValidatorKey.BILLS_DATE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSaveBills$5
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(String str) {
                                Intrinsics.checkNotNullParameter(str, "");
                                return Boolean.valueOf(!StringsKt.isBlank(str));
                            }
                        })), TuplesKt.to(FormValidatorKey.BILLS_PAYMENT_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSaveBills$6
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(String str) {
                                Intrinsics.checkNotNullParameter(str, "");
                                return Boolean.valueOf(!StringsKt.isBlank(str));
                            }
                        }))));
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ FormModel getAuthRequestContext(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        String value;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(FormValidatorKey.DROPDOWN_SERVICE_TYPE, electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda5);
        VB vb = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            pairArr[1] = TuplesKt.to(FormValidatorKey.CUSTOMER_ID, ((FragmentElectricityBottomSheetBinding) vb).moveToNextValue.getAuthRequestContext.m2682getText());
            VB vb2 = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                pairArr[2] = TuplesKt.to(FormValidatorKey.CUSTOMER_NAME, ((FragmentElectricityBottomSheetBinding) vb2).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.getText());
                if (Intrinsics.areEqual(electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda5, "ELECTRICITY_POST")) {
                    MoneyViewModel price = electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getPrice();
                    value = String.valueOf(price != null ? price.getDisplayAmount() : null);
                } else {
                    value = electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
                    if (value == null) {
                        value = "";
                    }
                }
                pairArr[3] = TuplesKt.to(FormValidatorKey.AMOUNT, value);
                return new FormModel(MapsKt.mapOf(pairArr), MapsKt.mapOf(TuplesKt.to(FormValidatorKey.DROPDOWN_SERVICE_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSinglePay$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "");
                        return Boolean.valueOf(!StringsKt.isBlank(str));
                    }
                })), TuplesKt.to(FormValidatorKey.CUSTOMER_ID, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSinglePay$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "");
                        return Boolean.valueOf(!StringsKt.isBlank(str));
                    }
                })), TuplesKt.to(FormValidatorKey.CUSTOMER_NAME, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSinglePay$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "");
                        return Boolean.valueOf(!StringsKt.isBlank(str));
                    }
                })), TuplesKt.to(FormValidatorKey.AMOUNT, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment$constructFormValidatorSinglePay$4
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "");
                        return Boolean.valueOf(!StringsKt.isBlank(str));
                    }
                }))));
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ HighlightTransactionPayRequestModel initRecordTimeStamp(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        return (HighlightTransactionPayRequestModel) electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
    }

    public static final /* synthetic */ AddNewBillsViewModel DatabaseTableConfigUtil(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        return (AddNewBillsViewModel) electricityBillsBottomSheetFragment.FragmentBottomSheetPaymentSettingBinding.getValue();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment, BizProductDestination bizProductDestination) {
        MoneyView totalAmount;
        String customerName = bizProductDestination.getCustomerName();
        if (customerName != null) {
            VB vb = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb != 0) {
                CustomEditTextView customEditTextView = ((FragmentElectricityBottomSheetBinding) vb).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(customEditTextView, "");
                customEditTextView.setVisibility(0);
                customEditTextView.setDisabled();
                customEditTextView.setText(customerName);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb2 = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb2 != 0) {
            CustomDropdownView customDropdownView = ((FragmentElectricityBottomSheetBinding) vb2).moveToNextValue.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
            customDropdownView.setVisibility(Intrinsics.areEqual(electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda5, "ELECTRICITY_POST") ^ true ? 0 : 8);
            if (!Intrinsics.areEqual(electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda5, "ELECTRICITY_POST") || (totalAmount = bizProductDestination.getTotalAmount()) == null) {
                return;
            }
            VB vb3 = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb3 != 0) {
                CustomEditTextView customEditTextView2 = ((FragmentElectricityBottomSheetBinding) vb3).moveToNextValue.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(customEditTextView2, "");
                customEditTextView2.setVisibility(0);
                customEditTextView2.setDisabled();
                electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = new DropdownOptionsModel(null, null, null, BillPaymentStatusModelKt.toMoneyViewModel(totalAmount), null, 23, null);
                customEditTextView2.setText(BillPaymentStatusModelKt.toMoneyViewModel(totalAmount).getDisplayAmount());
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda1(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        FragmentActivity requireActivity = electricityBillsBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.hideBlockerLoading();
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment, CurrencyAmountModel currencyAmountModel) {
        VB vb = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((FragmentElectricityBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.setBalance(MoneyViewModel.INSTANCE.fromCurrencyAmountModel(currencyAmountModel));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void PlaceComponentResult(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment, List list) {
        electricityBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((ProductGoodsInfo) obj).getType(), "ELECTRICITY")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(DropdownOptionsModelKt.toDropdownOptionsModel((ProductGoodsInfo) it.next()));
        }
        ArrayList arrayList4 = arrayList3;
        if ((!arrayList4.isEmpty()) != false) {
            VB vb = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb != 0) {
                ((FragmentElectricityBottomSheetBinding) vb).moveToNextValue.MyBillsEntityDataFactory.setOptions(arrayList4);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            VB vb2 = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                CustomDropdownView customDropdownView = ((FragmentElectricityBottomSheetBinding) vb2).moveToNextValue.BuiltInFictitiousFunctionClassFactory;
                Context context = electricityBillsBottomSheetFragment.getContext();
                customDropdownView.setErrorMessage(true, context != null ? context.getString(R.string.res_0x7f130f30_networkuserentitydata_externalsyntheticlambda6) : null);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        if ((!electricityBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) == true) {
            electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 = electricityBillsBottomSheetFragment.DatabaseTableConfigUtil();
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda5(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        Unit unit;
        Object obj;
        MoneyViewModel denom;
        String displayAmount;
        BizProductModel bizProductModel = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
        boolean z = false;
        if (bizProductModel != null && (denom = bizProductModel.getDenom()) != null && (displayAmount = denom.getDisplayAmount()) != null) {
            if (displayAmount.length() > 0) {
                z = true;
            }
        }
        if (z) {
            VB vb = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb != 0) {
                ViewBodyElectricityMyBillsBinding viewBodyElectricityMyBillsBinding = ((FragmentElectricityBottomSheetBinding) vb).moveToNextValue;
                Iterator<T> it = viewBodyElectricityMyBillsBinding.MyBillsEntityDataFactory.getItemOptions().iterator();
                while (true) {
                    unit = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    String id2 = ((DropdownOptionsModel) obj).getId();
                    BizProductModel bizProductModel2 = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
                    String goodsId = bizProductModel2 != null ? bizProductModel2.getGoodsId() : null;
                    if (goodsId == null) {
                        goodsId = "";
                    }
                    if (Intrinsics.areEqual(id2, goodsId)) {
                        break;
                    }
                }
                DropdownOptionsModel dropdownOptionsModel = (DropdownOptionsModel) obj;
                if (dropdownOptionsModel != null) {
                    viewBodyElectricityMyBillsBinding.MyBillsEntityDataFactory.setSelected(dropdownOptionsModel);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    viewBodyElectricityMyBillsBinding.MyBillsEntityDataFactory.clearSelectedOption();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda4(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        VB vb = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            CustomerIDProviderView customerIDProviderView = ((FragmentElectricityBottomSheetBinding) vb).moveToNextValue.getAuthRequestContext;
            customerIDProviderView.setClearTextVisible(true);
            customerIDProviderView.setLoadingVisibility(false);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda6(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        int i = electricityBillsBottomSheetFragment.GetContactSyncConfig ? R.string.my_bills_label_electricity_bills_is_registered : 0;
        if (i != 0) {
            VB vb = electricityBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb != 0) {
                ((FragmentElectricityBottomSheetBinding) vb).moveToNextValue.getAuthRequestContext.setErrorMessage(true, electricityBillsBottomSheetFragment.getString(i));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final /* synthetic */ void FragmentBottomSheetPaymentSettingBinding(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        FragmentActivity requireActivity = electricityBillsBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.showBlockerLoading();
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment, boolean z, String str) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = electricityBillsBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
        myBillsAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsTrackerUtil.getAuthRequestContext(z, str), electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment, AddNewBillsUiState.OnSuccessSaveMyBills onSuccessSaveMyBills) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = electricityBillsBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        String NetworkUserEntityData$$ExternalSyntheticLambda2 = electricityBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2();
        MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
        myBillsAnalyticTracker.MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda2, MyBillsTrackerUtil.BuiltInFictitiousFunctionClassFactory(onSuccessSaveMyBills.MyBillsEntityDataFactory.getRecurringType()));
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda3(ElectricityBillsBottomSheetFragment electricityBillsBottomSheetFragment) {
        Job launch$default;
        Job job = electricityBillsBottomSheetFragment.PrepareContext;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(electricityBillsBottomSheetFragment), null, null, new ElectricityBillsBottomSheetFragment$validateForm$1(electricityBillsBottomSheetFragment, null), 3, null);
        electricityBillsBottomSheetFragment.PrepareContext = launch$default;
    }

    private final SaveSubscriptionRequestModel initRecordTimeStamp() {
        String str;
        Object obj;
        MoneyView denom;
        MoneyViewModel moneyViewModel;
        MoneyView price;
        MoneyView denom2;
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            String billsName = ((FragmentElectricityBottomSheetBinding) vb).MyBillsEntityDataFactory.getBillsName();
            if (billsName.length() == 0) {
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    billsName = ((FragmentElectricityBottomSheetBinding) vb2).getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2.getText().toString();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            String str2 = billsName;
            VB vb3 = this.MyBillsEntityDataFactory;
            if (vb3 != 0) {
                String selectedPaymentType = ((FragmentElectricityBottomSheetBinding) vb3).MyBillsEntityDataFactory.getSelectedPaymentType();
                VB vb4 = this.MyBillsEntityDataFactory;
                if (vb4 != 0) {
                    String id2 = ((FragmentElectricityBottomSheetBinding) vb4).moveToNextValue.BuiltInFictitiousFunctionClassFactory.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId();
                    VB vb5 = this.MyBillsEntityDataFactory;
                    if (vb5 != 0) {
                        Calendar kClassImpl$Data$declaredNonStaticMembers$2 = ((FragmentElectricityBottomSheetBinding) vb5).MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2();
                        VB vb6 = this.MyBillsEntityDataFactory;
                        if (vb6 != 0) {
                            String m2682getText = ((FragmentElectricityBottomSheetBinding) vb6).moveToNextValue.getAuthRequestContext.m2682getText();
                            VB vb7 = this.MyBillsEntityDataFactory;
                            if (vb7 != 0) {
                                String id3 = ((FragmentElectricityBottomSheetBinding) vb7).moveToNextValue.BuiltInFictitiousFunctionClassFactory.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId();
                                Iterator<T> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                                while (true) {
                                    str = null;
                                    if (!it.hasNext()) {
                                        obj = null;
                                        break;
                                    }
                                    obj = it.next();
                                    String goodsId = ((ProductGoodsInfo) obj).getGoodsId();
                                    VB vb8 = this.MyBillsEntityDataFactory;
                                    if (vb8 != 0) {
                                        if (Intrinsics.areEqual(goodsId, ((FragmentElectricityBottomSheetBinding) vb8).moveToNextValue.MyBillsEntityDataFactory.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId())) {
                                            break;
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                }
                                ProductGoodsInfo productGoodsInfo = (ProductGoodsInfo) obj;
                                SaveSubscriptionRequestModel saveSubscriptionRequestModel = new SaveSubscriptionRequestModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
                                saveSubscriptionRequestModel.setTitle(str2);
                                saveSubscriptionRequestModel.setGoodsId(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
                                saveSubscriptionRequestModel.setBillerId(m2682getText);
                                saveSubscriptionRequestModel.setRecurringType(selectedPaymentType);
                                saveSubscriptionRequestModel.setBizType(id3);
                                saveSubscriptionRequestModel.setMessage(str2);
                                saveSubscriptionRequestModel.setSubscriptionDayOfMonth(String.valueOf(kClassImpl$Data$declaredNonStaticMembers$2.get(5)));
                                saveSubscriptionRequestModel.setSubscriptionHourOfDay(String.valueOf(kClassImpl$Data$declaredNonStaticMembers$2.get(11)));
                                saveSubscriptionRequestModel.setSubscriptionMonthOfYear(String.valueOf(kClassImpl$Data$declaredNonStaticMembers$2.get(2)));
                                saveSubscriptionRequestModel.setSubscriptionIntervalType(SubscriptionIntervalType.MONTHLY);
                                saveSubscriptionRequestModel.setType(id2);
                                saveSubscriptionRequestModel.setTimezone(TimeZone.getDefault().getDisplayName(false, 0));
                                saveSubscriptionRequestModel.setPayMode(Intrinsics.areEqual(selectedPaymentType, RecurringType.REMINDER) ? "DIRECT" : "AUTO_DEBIT");
                                saveSubscriptionRequestModel.setPaymentMethod("BALANCE");
                                saveSubscriptionRequestModel.setDenom((productGoodsInfo == null || (denom2 = productGoodsInfo.getDenom()) == null) ? null : BillPaymentStatusModelKt.toMoneyViewModel(denom2));
                                saveSubscriptionRequestModel.setTotalAmount((productGoodsInfo == null || (price = productGoodsInfo.getPrice()) == null) ? null : BillPaymentStatusModelKt.toMoneyViewModel(price));
                                saveSubscriptionRequestModel.setProductTitle(productGoodsInfo != null ? productGoodsInfo.getGoodsTitle() : null);
                                if (productGoodsInfo != null && (denom = productGoodsInfo.getDenom()) != null && (moneyViewModel = BillPaymentStatusModelKt.toMoneyViewModel(denom)) != null) {
                                    str = moneyViewModel.getDisplayAmount();
                                }
                                saveSubscriptionRequestModel.setExtendInfoTitle(str);
                                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = saveSubscriptionRequestModel;
                                return saveSubscriptionRequestModel;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return (((HighlightTransactionPayRequestModel) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue()).getSubscriptionId().length() > 0) && !this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewBodyElectricityMyBillsBinding viewBodyElectricityMyBillsBinding = ((FragmentElectricityBottomSheetBinding) vb).moveToNextValue;
            if (z) {
                viewBodyElectricityMyBillsBinding.getAuthRequestContext.setText("");
            }
            CustomerIDProviderView customerIDProviderView = viewBodyElectricityMyBillsBinding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(customerIDProviderView, "");
            CustomerIDProviderView.setErrorMessage$default(customerIDProviderView, false, null, 2, null);
            CustomEditTextView customEditTextView = viewBodyElectricityMyBillsBinding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(customEditTextView, "");
            customEditTextView.setVisibility(8);
            CustomEditTextView customEditTextView2 = viewBodyElectricityMyBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(customEditTextView2, "");
            customEditTextView2.setVisibility(8);
            CustomDropdownView customDropdownView = viewBodyElectricityMyBillsBinding.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
            customDropdownView.setVisibility(8);
            viewBodyElectricityMyBillsBinding.MyBillsEntityDataFactory.clearSelectedOption();
            viewBodyElectricityMyBillsBinding.BuiltInFictitiousFunctionClassFactory.setLoadingVisibility(false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new DropdownOptionsModel(null, null, null, null, null, 31, null);
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                BodySaveToBillsView bodySaveToBillsView = ((FragmentElectricityBottomSheetBinding) vb2).MyBillsEntityDataFactory;
                bodySaveToBillsView.setIsSaveToMyBillsActive(false);
                bodySaveToBillsView.setSwitchAddToMyBillsChecked(false);
                this.initRecordTimeStamp = false;
                this.newProxyInstance = false;
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void PlaceComponentResult(String str) {
        MyBillsServiceModel serviceModel;
        String source;
        MyBillsAnalyticTracker myBillsAnalyticTracker = this.myBillsAnalyticTracker;
        String str2 = "";
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        String NetworkUserEntityData$$ExternalSyntheticLambda2 = NetworkUserEntityData$$ExternalSyntheticLambda2();
        BizProductModel bizProductModel = this.MyBillsEntityDataFactory;
        if (bizProductModel == null || (serviceModel = bizProductModel.getServiceModel()) == null || (source = serviceModel.getSource()) == null) {
            MyBillsServiceModel myBillsServiceModel = this.isLayoutRequested;
            String source2 = myBillsServiceModel != null ? myBillsServiceModel.getSource() : null;
            if (source2 != null) {
                str2 = source2;
            }
        } else {
            str2 = source;
        }
        myBillsAnalyticTracker.MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda2, str2, str);
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final ConstraintLayout scheduleImpl() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ConstraintLayout constraintLayout = ((FragmentElectricityBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        return constraintLayout;
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final ViewHeaderDetailBillsBinding NetworkUserEntityData$$ExternalSyntheticLambda0() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewHeaderDetailBillsBinding viewHeaderDetailBillsBinding = ((FragmentElectricityBottomSheetBinding) vb).getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(viewHeaderDetailBillsBinding, "");
            return viewHeaderDetailBillsBinding;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final NestedScrollView moveToNextValue() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            NestedScrollView nestedScrollView = ((FragmentElectricityBottomSheetBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
            return nestedScrollView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final MyBillsToolbarView GetContactSyncConfig() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            MyBillsToolbarView myBillsToolbarView = ((FragmentElectricityBottomSheetBinding) vb).getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(myBillsToolbarView, "");
            return myBillsToolbarView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            RelativeLayout relativeLayout = ((FragmentElectricityBottomSheetBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
            return relativeLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
