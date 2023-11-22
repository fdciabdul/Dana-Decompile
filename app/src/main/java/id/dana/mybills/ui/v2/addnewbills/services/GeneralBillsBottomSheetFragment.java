package id.dana.mybills.ui.v2.addnewbills.services;

import android.app.Dialog;
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
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentGeneralBillsBottomSheetBinding;
import id.dana.mybills.databinding.ViewBodyGeneralBillsBinding;
import id.dana.mybills.databinding.ViewFooterAddNewBillsBinding;
import id.dana.mybills.databinding.ViewHeaderDetailBillsBinding;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.di.provider.MyBillsComponentProvider;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.FormModel;
import id.dana.mybills.domain.model.ProductGoodsInfo;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.ui.constant.BizProductCode;
import id.dana.mybills.ui.constant.FormValidatorKey;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.constant.SubscriptionIntervalType;
import id.dana.mybills.ui.customview.BodySaveToBillsView;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.CustomEditTextView;
import id.dana.mybills.ui.customview.CustomerIDProviderView;
import id.dana.mybills.ui.customview.MyBillsToolbarView;
import id.dana.mybills.ui.customview.PhoneNumberView;
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
import id.dana.mybills.ui.v2.addnewbills.AddToMyBillsState;
import id.dana.mybills.utils.MyBillsTrackerUtil;
import id.dana.mybills.utils.PhoneNumberValidation;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000200H\u0002J\u0010\u00104\u001a\u0002002\u0006\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\b\u00109\u001a\u000200H\u0002J\u0010\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020 H\u0002J\b\u0010<\u001a\u00020=H\u0014J\b\u0010>\u001a\u000200H\u0002J\b\u0010?\u001a\u00020@H\u0014J\b\u0010A\u001a\u00020\u0016H\u0002J\b\u0010B\u001a\u00020\u001cH\u0002J\b\u0010C\u001a\u00020DH\u0014J\b\u0010E\u001a\u00020 H\u0002J\b\u0010F\u001a\u00020GH\u0014J\b\u0010H\u001a\u00020IH\u0014J\u0010\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u000200H\u0002J\u001a\u0010N\u001a\u00020\u00022\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u000200H\u0014J\b\u0010T\u001a\u000200H\u0002J\b\u0010U\u001a\u000200H\u0002J\b\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u000200H\u0002J\b\u0010Y\u001a\u000200H\u0002J\b\u0010Z\u001a\u000200H\u0002J\b\u0010[\u001a\u000200H\u0002J\b\u0010\\\u001a\u000200H\u0002J\b\u0010]\u001a\u000200H\u0002J\b\u0010^\u001a\u00020\u0002H\u0002J\b\u0010_\u001a\u00020\u0007H\u0002J\b\u0010`\u001a\u00020\u0007H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\b\u0010b\u001a\u00020\u0007H\u0002J\b\u0010c\u001a\u00020\u0007H\u0002J\u0010\u0010d\u001a\u0002002\u0006\u0010e\u001a\u00020fH\u0002J\u0016\u0010g\u001a\u0002002\f\u0010h\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u0010i\u001a\u000200H\u0016J\u0012\u0010j\u001a\u0002002\b\b\u0002\u0010k\u001a\u00020\u0007H\u0002J\b\u0010l\u001a\u000200H\u0002J\u0010\u0010m\u001a\u0002002\u0006\u0010n\u001a\u00020oH\u0002J\b\u0010p\u001a\u000200H\u0002J\u001a\u0010q\u001a\u0002002\u0006\u0010r\u001a\u00020\u00072\b\b\u0002\u0010s\u001a\u00020 H\u0002J\u0010\u0010t\u001a\u0002002\u0006\u0010u\u001a\u00020 H\u0002J\u0010\u0010v\u001a\u0002002\u0006\u0010w\u001a\u00020 H\u0002J\b\u0010x\u001a\u000200H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b,\u0010-¨\u0006y"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/services/GeneralBillsBottomSheetFragment;", "Lid/dana/mybills/ui/v2/addnewbills/services/BaseMyBillsBottomSheet;", "Lid/dana/mybills/databinding/FragmentGeneralBillsBottomSheetBinding;", "()V", "bizProductModel", "Lid/dana/mybills/ui/model/BizProductModel;", "dropdownProviderHidden", "", "isAllRequiredValuesValid", "isHasActiveBills", "isHasBillsToPay", "isNoErrorBill", "isViewBillOnly", "myBillsAnalyticTracker", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "getMyBillsAnalyticTracker", "()Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "setMyBillsAnalyticTracker", "(Lid/dana/mybills/tracker/MyBillsAnalyticTracker;)V", "myBillsServiceModel", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "payRequestModel", "Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "getPayRequestModel", "()Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "payRequestModel$delegate", "Lkotlin/Lazy;", "saveRequestModel", "Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "selectedAmount", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "selectedGoodsId", "", "serviceProducts", "", "Lid/dana/mybills/domain/model/ProductGoodsInfo;", "viewModelFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/mybills/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/mybills/di/module/ViewModelFactory;)V", "vm", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "getVm", "()Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "vm$delegate", "actionPaySingleBill", "", "saveSubscriptionModel", "Lid/dana/mybills/ui/model/SaveMyBillsSubscriptionModel;", "checkPayButtonState", "checkUniqueValueAndCheckInquiry", "customerId", "constructFormValidatorSaveBills", "Lid/dana/mybills/domain/model/FormModel;", "constructFormValidatorSinglePay", "getBundleArgument", "getDateRangeBill", "goodType", "getFooterMyBills", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getGeneralProducts", "getHeader", "Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "getPaySingleRequestModel", "getSaveRequest", "getScrollContainer", "Landroidx/core/widget/NestedScrollView;", "getServiceName", "getToolbar", "Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "getViewBottomSheet", "Landroid/view/View;", "handleDataDetailInquiry", "data", "Lid/dana/mybills/domain/model/BizProductDestination;", "hideBlockerLoading", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", BranchLinkConstant.PathTarget.CONTAINER, "Landroid/view/ViewGroup;", IAPSyncCommand.COMMAND_INIT, "initClickListeners", "initCustomerDetailsView", "initCustomerIdView", "Lid/dana/mybills/ui/customview/CustomerIDProviderView;", "initDropdownView", "initInjector", "initLifecycleActivity", "initOnScrollBottomSheet", "initRecentTransactionView", "initSwitchButton", "initViews", "isCanPaySingleBill", "isUserCanOnlyPayBills", "isUserCanOnlySaveBills", "isUserCanOnlyViewBill", "isUserCanSaveAndPayBills", "mapDataUserBalance", "amount", "Lid/dana/core/ui/model/CurrencyAmountModel;", "mappingProducts", "products", "onStart", "resetUI", "isNeedToClearText", "setCustomerIDLoadingInvisible", "setErrorMessage", "state", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessCheckUniqueValueAndCheckInquiry;", "showBlockerLoading", "trackCheckStatusProductId", "isBillActive", "inquiryResultCode", "trackCreateDetailOpen", "action", "trackMyBillCreateSuccess", "recurringType", "validateForm", "feature-mybills_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class GeneralBillsBottomSheetFragment extends BaseMyBillsBottomSheet<FragmentGeneralBillsBottomSheetBinding> {
    private boolean DatabaseTableConfigUtil;
    private boolean GetContactSyncConfig;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private MyBillsServiceModel NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda4;
    private DropdownOptionsModel NetworkUserEntityData$$ExternalSyntheticLambda7;
    private List<ProductGoodsInfo> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private BizProductModel PlaceComponentResult;
    private SaveSubscriptionRequestModel PrepareContext;
    private boolean initRecordTimeStamp;
    private final Lazy isLayoutRequested;
    @Inject
    public MyBillsAnalyticTracker myBillsAnalyticTracker;
    private String newProxyInstance;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ ViewBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentGeneralBillsBottomSheetBinding PlaceComponentResult = FragmentGeneralBillsBottomSheetBinding.PlaceComponentResult(getLayoutInflater(), viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet, id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        Parcelable parcelable;
        Parcelable parcelable2;
        super.getAuthRequestContext();
        String string = getString(R.string.my_bills_label_add_new_bills);
        Intrinsics.checkNotNullExpressionValue(string, "");
        super.getAuthRequestContext(string, R.drawable.res_0x7f08086b_networkuserentitydata_externalsyntheticlambda2, new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$init$1
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
                FragmentKt.getAuthRequestContext(GeneralBillsBottomSheetFragment.this).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        super.getAuthRequestContext("BUNDLE_KEY_GENERAL_BILL");
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable("BUNDLE_KEY_GENERAL_BILL", MyBillsServiceModel.class);
            } else {
                Parcelable parcelable3 = arguments.getParcelable("BUNDLE_KEY_GENERAL_BILL");
                if (!(parcelable3 instanceof MyBillsServiceModel)) {
                    parcelable3 = null;
                }
                parcelable = (MyBillsServiceModel) parcelable3;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (MyBillsServiceModel) parcelable;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable2 = (Parcelable) arguments.getParcelable("BUNDLE_KEY_PRODUCT", BizProductModel.class);
            } else {
                Parcelable parcelable4 = arguments.getParcelable("BUNDLE_KEY_PRODUCT");
                if (!(parcelable4 instanceof BizProductModel)) {
                    parcelable4 = null;
                }
                parcelable2 = (BizProductModel) parcelable4;
            }
            this.PlaceComponentResult = (BizProductModel) parcelable2;
        }
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.mybills.di.provider.MyBillsComponentProvider");
        }
        ((MyBillsComponentProvider) applicationContext).provideMyBillsComponent().getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(this);
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FragmentGeneralBillsBottomSheetBinding fragmentGeneralBillsBottomSheetBinding = (FragmentGeneralBillsBottomSheetBinding) vb;
            MyBillsServiceModel myBillsServiceModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (myBillsServiceModel != null) {
                this.MyBillsEntityDataFactory = myBillsServiceModel.isTelkom() | myBillsServiceModel.isPgn() | myBillsServiceModel.isBpjs() | myBillsServiceModel.isMobilePostpaid();
                PhoneNumberView phoneNumberView = fragmentGeneralBillsBottomSheetBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(phoneNumberView, "");
                phoneNumberView.setVisibility(myBillsServiceModel.isMobilePostpaid() ? 0 : 8);
                CustomerIDProviderView customerIDProviderView = fragmentGeneralBillsBottomSheetBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(customerIDProviderView, "");
                customerIDProviderView.setVisibility(myBillsServiceModel.isMobilePostpaid() ^ true ? 0 : 8);
            }
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                CustomerIDProviderView customerIDProviderView2 = ((FragmentGeneralBillsBottomSheetBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
                MyBillsServiceModel myBillsServiceModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (myBillsServiceModel2 != null) {
                    customerIDProviderView2.getLabelText().setText(getString(myBillsServiceModel2.isBpjs() ? R.string.res_0x7f130f44_bottomsheetcardbindingview_watchercardnumberview_1 : R.string.my_bills_label_customer_id));
                    customerIDProviderView2.getLoadingText().setText(getString(myBillsServiceModel2.isBpjs() ? R.string.my_bills_checking_number : R.string.res_0x7f130f1d_networkuserentitydata_externalsyntheticlambda0));
                    customerIDProviderView2.getText().setHint(myBillsServiceModel2.isBpjs() ? R.string.my_bills_hint_card_number : R.string.my_bills_hint_customer_id);
                }
                customerIDProviderView2.setCustomerIDEnable(false);
                customerIDProviderView2.setListenerTextChanged(new CustomerIDProviderView.OnTextChangedListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$initCustomerIdView$1$2
                    @Override // id.dana.mybills.ui.customview.CustomerIDProviderView.OnTextChangedListener
                    public final void MyBillsEntityDataFactory(String p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (!(p0.length() > 0)) {
                            GeneralBillsBottomSheetFragment.this.BuiltInFictitiousFunctionClassFactory(false);
                            GeneralBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda4();
                            return;
                        }
                        GeneralBillsBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(GeneralBillsBottomSheetFragment.this, p0);
                        GeneralBillsBottomSheetFragment.this.BuiltInFictitiousFunctionClassFactory(false);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(customerIDProviderView2, "");
                MyBillsServiceModel myBillsServiceModel3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String bizType = myBillsServiceModel3 != null ? myBillsServiceModel3.getBizType() : null;
                if (bizType == null) {
                    bizType = "";
                }
                ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).BuiltInFictitiousFunctionClassFactory(bizType);
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
                    VB vb3 = this.MyBillsEntityDataFactory;
                    if (vb3 != 0) {
                        CustomDropdownView customDropdownView = ((FragmentGeneralBillsBottomSheetBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
                        Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
                        customDropdownView.setVisibility(this.MyBillsEntityDataFactory ? 8 : 0);
                        VB vb4 = this.MyBillsEntityDataFactory;
                        if (vb4 != 0) {
                            ((FragmentGeneralBillsBottomSheetBinding) vb4).NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.setCustomerIDEnable(this.MyBillsEntityDataFactory);
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                VB vb5 = this.MyBillsEntityDataFactory;
                if (vb5 != 0) {
                    final CustomDropdownView customDropdownView2 = ((FragmentGeneralBillsBottomSheetBinding) vb5).NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
                    String string2 = getString(R.string.my_bills_label_provider);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    customDropdownView2.setTitle(string2);
                    String string3 = getString(R.string.my_bills_hint_choose_provider);
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    customDropdownView2.setHintDropdown(string3);
                    customDropdownView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GeneralBillsBottomSheetFragment.MyBillsEntityDataFactory(GeneralBillsBottomSheetFragment.this, customDropdownView2);
                        }
                    });
                    customDropdownView2.setListenerItemSelected(new CustomDropdownView.OnItemSelectedListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$initDropdownView$2$2
                        @Override // id.dana.mybills.ui.customview.CustomDropdownView.OnItemSelectedListener
                        public final void BuiltInFictitiousFunctionClassFactory(DropdownOptionsModel p0) {
                            String str;
                            Intrinsics.checkNotNullParameter(p0, "");
                            str = GeneralBillsBottomSheetFragment.this.newProxyInstance;
                            if (Intrinsics.areEqual(str, p0.getId())) {
                                return;
                            }
                            VB vb6 = GeneralBillsBottomSheetFragment.this.MyBillsEntityDataFactory;
                            if (vb6 != 0) {
                                ((FragmentGeneralBillsBottomSheetBinding) vb6).NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.setCustomerIDEnable(true);
                                customDropdownView2.setTvDropdownSelectedValueVisible(false);
                                String id2 = p0.getId();
                                if (id2 != null) {
                                    GeneralBillsBottomSheetFragment.this.newProxyInstance = id2;
                                }
                                GeneralBillsBottomSheetFragment.this.BuiltInFictitiousFunctionClassFactory(true);
                                GeneralBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda4();
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    });
                    VB vb6 = this.MyBillsEntityDataFactory;
                    if (vb6 != 0) {
                        ViewBodyGeneralBillsBinding viewBodyGeneralBillsBinding = ((FragmentGeneralBillsBottomSheetBinding) vb6).NetworkUserEntityData$$ExternalSyntheticLambda0;
                        CustomEditTextView customEditTextView = viewBodyGeneralBillsBinding.MyBillsEntityDataFactory;
                        String string4 = getString(R.string.my_bills_label_customer_name);
                        Intrinsics.checkNotNullExpressionValue(string4, "");
                        customEditTextView.setLabelText(string4);
                        CustomEditTextView customEditTextView2 = viewBodyGeneralBillsBinding.BuiltInFictitiousFunctionClassFactory;
                        String string5 = getString(R.string.my_bills_label_amount);
                        Intrinsics.checkNotNullExpressionValue(string5, "");
                        customEditTextView2.setLabelText(string5);
                        VB vb7 = this.MyBillsEntityDataFactory;
                        if (vb7 != 0) {
                            BodySaveToBillsView bodySaveToBillsView = ((FragmentGeneralBillsBottomSheetBinding) vb7).KClassImpl$Data$declaredNonStaticMembers$2;
                            bodySaveToBillsView.setToggleSaveToMyBillsVisible(false);
                            bodySaveToBillsView.setIsSaveToMyBillsActive(false);
                            bodySaveToBillsView.setOnToggleCheckedChanged(new BodySaveToBillsView.OnToggleAddToMyBillsChecked() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$initSwitchButton$1$1
                                @Override // id.dana.mybills.ui.customview.BodySaveToBillsView.OnToggleAddToMyBillsChecked
                                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                                    GeneralBillsBottomSheetFragment.getErrorConfigVersion(GeneralBillsBottomSheetFragment.this).KClassImpl$Data$declaredNonStaticMembers$2(AddToMyBillsState.getAuthRequestContext(GeneralBillsBottomSheetFragment.getErrorConfigVersion(GeneralBillsBottomSheetFragment.this).MyBillsEntityDataFactory.getValue(), p0));
                                    GeneralBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda4();
                                }
                            });
                            bodySaveToBillsView.setSwitchAddToMyBillsChecked(false);
                            StateFlow<AddNewBillsUiState> stateFlow = ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda8;
                            Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
                            Intrinsics.checkNotNullExpressionValue(lifecycle, "");
                            Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new GeneralBillsBottomSheetFragment$initLifecycleActivity$1(this, null));
                            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
                            FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
                            StateFlow<AddToMyBillsState> stateFlow2 = ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory;
                            Lifecycle lifecycle2 = getViewLifecycleOwner().getLifecycle();
                            Intrinsics.checkNotNullExpressionValue(lifecycle2, "");
                            Flow onEach2 = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow2, lifecycle2)), new GeneralBillsBottomSheetFragment$initLifecycleActivity$2(this, null));
                            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "");
                            FlowKt.launchIn(onEach2, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner2));
                            VB vb8 = this.MyBillsEntityDataFactory;
                            if (vb8 != 0) {
                                final FragmentGeneralBillsBottomSheetBinding fragmentGeneralBillsBottomSheetBinding2 = (FragmentGeneralBillsBottomSheetBinding) vb8;
                                fragmentGeneralBillsBottomSheetBinding2.PlaceComponentResult.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$$ExternalSyntheticLambda3
                                    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                                    public final void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                                        GeneralBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(GeneralBillsBottomSheetFragment.this, fragmentGeneralBillsBottomSheetBinding2, nestedScrollView, i2, i4);
                                    }
                                });
                                VB vb9 = this.MyBillsEntityDataFactory;
                                if (vb9 != 0) {
                                    DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentGeneralBillsBottomSheetBinding) vb9).scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2;
                                    danaButtonPrimaryView.setEnabled(false);
                                    danaButtonPrimaryView.setDisabled(getString(R.string.my_bills_label_pay));
                                    danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$$ExternalSyntheticLambda1
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            GeneralBillsBottomSheetFragment.getAuthRequestContext(GeneralBillsBottomSheetFragment.this);
                                        }
                                    });
                                    VB vb10 = this.MyBillsEntityDataFactory;
                                    if (vb10 != 0) {
                                        ((FragmentGeneralBillsBottomSheetBinding) vb10).scheduleImpl.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$$ExternalSyntheticLambda2
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                GeneralBillsBottomSheetFragment.MyBillsEntityDataFactory(GeneralBillsBottomSheetFragment.this);
                                            }
                                        });
                                        VB vb11 = this.MyBillsEntityDataFactory;
                                        if (vb11 != 0) {
                                            PhoneNumberView phoneNumberView2 = ((FragmentGeneralBillsBottomSheetBinding) vb11).NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
                                            LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
                                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "");
                                            phoneNumberView2.setOnChangeListener(LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner3), new Function2<String, String, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$initClickListeners$3
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                                                    invoke2(str, str2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(String str, String str2) {
                                                    List list;
                                                    Object obj;
                                                    String goodsId;
                                                    String str3 = "";
                                                    Intrinsics.checkNotNullParameter(str, "");
                                                    Intrinsics.checkNotNullParameter(str2, "");
                                                    if (str.length() >= 10) {
                                                        GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment = GeneralBillsBottomSheetFragment.this;
                                                        list = generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda8;
                                                        Iterator it = list.iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                obj = null;
                                                                break;
                                                            }
                                                            obj = it.next();
                                                            if (Intrinsics.areEqual(((ProductGoodsInfo) obj).getProvider(), str2)) {
                                                                break;
                                                            }
                                                        }
                                                        ProductGoodsInfo productGoodsInfo = (ProductGoodsInfo) obj;
                                                        if (productGoodsInfo != null && (goodsId = productGoodsInfo.getGoodsId()) != null) {
                                                            str3 = goodsId;
                                                        }
                                                        generalBillsBottomSheetFragment.newProxyInstance = str3;
                                                        GeneralBillsBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(GeneralBillsBottomSheetFragment.this, str);
                                                    }
                                                    if (!(str.length() == 0)) {
                                                        GeneralBillsBottomSheetFragment.this.BuiltInFictitiousFunctionClassFactory(false);
                                                        return;
                                                    }
                                                    GeneralBillsBottomSheetFragment.this.BuiltInFictitiousFunctionClassFactory(true);
                                                    GeneralBillsBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda4();
                                                }
                                            });
                                            MyBillsServiceModel myBillsServiceModel4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                            if (myBillsServiceModel4 != null) {
                                                ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).PlaceComponentResult(myBillsServiceModel4.getBizProductCode());
                                            }
                                            ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory();
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

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                getAuthRequestContext.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(getAuthRequestContext, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    private final FormModel initRecordTimeStamp() {
        String str;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(FormValidatorKey.DROPDOWN_PROVIDER_TYPE, this.newProxyInstance);
        MyBillsServiceModel myBillsServiceModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (myBillsServiceModel == null) {
            str = null;
        } else if (myBillsServiceModel.isMobilePostpaid()) {
            VB vb = this.MyBillsEntityDataFactory;
            if (vb != 0) {
                str = ((FragmentGeneralBillsBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getPhoneNumber();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                str = ((FragmentGeneralBillsBottomSheetBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.m2682getText();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        pairArr[1] = TuplesKt.to(FormValidatorKey.CUSTOMER_ID, String.valueOf(str));
        VB vb3 = this.MyBillsEntityDataFactory;
        if (vb3 != 0) {
            pairArr[2] = TuplesKt.to(FormValidatorKey.CUSTOMER_NAME, ((FragmentGeneralBillsBottomSheetBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.getText());
            MoneyViewModel price = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getPrice();
            String displayAmount = price != null ? price.getDisplayAmount() : null;
            if (displayAmount == null) {
                displayAmount = "";
            }
            pairArr[3] = TuplesKt.to(FormValidatorKey.AMOUNT, displayAmount);
            return new FormModel(MapsKt.mapOf(pairArr), MapsKt.mapOf(TuplesKt.to(FormValidatorKey.DROPDOWN_PROVIDER_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSinglePay$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String str2) {
                    Intrinsics.checkNotNullParameter(str2, "");
                    return Boolean.valueOf(!StringsKt.isBlank(str2));
                }
            })), TuplesKt.to(FormValidatorKey.CUSTOMER_ID, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSinglePay$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String str2) {
                    Intrinsics.checkNotNullParameter(str2, "");
                    return Boolean.valueOf(!StringsKt.isBlank(str2));
                }
            })), TuplesKt.to(FormValidatorKey.CUSTOMER_NAME, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSinglePay$4
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String str2) {
                    Intrinsics.checkNotNullParameter(str2, "");
                    return Boolean.valueOf(!StringsKt.isBlank(str2));
                }
            })), TuplesKt.to(FormValidatorKey.AMOUNT, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSinglePay$5
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String str2) {
                    Intrinsics.checkNotNullParameter(str2, "");
                    return Boolean.valueOf(!StringsKt.isBlank(str2));
                }
            }))));
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final FormModel NetworkUserEntityData$$ExternalSyntheticLambda1() {
        String str;
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to(FormValidatorKey.DROPDOWN_PROVIDER_TYPE, this.newProxyInstance);
        MyBillsServiceModel myBillsServiceModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (myBillsServiceModel == null) {
            str = null;
        } else if (myBillsServiceModel.isMobilePostpaid()) {
            VB vb = this.MyBillsEntityDataFactory;
            if (vb != 0) {
                str = ((FragmentGeneralBillsBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getPhoneNumber();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                str = ((FragmentGeneralBillsBottomSheetBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.m2682getText();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        pairArr[1] = TuplesKt.to(FormValidatorKey.CUSTOMER_ID, String.valueOf(str));
        VB vb3 = this.MyBillsEntityDataFactory;
        if (vb3 != 0) {
            pairArr[2] = TuplesKt.to(FormValidatorKey.CUSTOMER_NAME, ((FragmentGeneralBillsBottomSheetBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.getText());
            MoneyViewModel price = this.NetworkUserEntityData$$ExternalSyntheticLambda7.getPrice();
            String displayAmount = price != null ? price.getDisplayAmount() : null;
            if (displayAmount == null) {
                displayAmount = "";
            }
            pairArr[3] = TuplesKt.to(FormValidatorKey.AMOUNT, displayAmount);
            VB vb4 = this.MyBillsEntityDataFactory;
            if (vb4 != 0) {
                pairArr[4] = TuplesKt.to(FormValidatorKey.BILLS_DATE, ((FragmentGeneralBillsBottomSheetBinding) vb4).KClassImpl$Data$declaredNonStaticMembers$2.getSelectedDate());
                VB vb5 = this.MyBillsEntityDataFactory;
                if (vb5 != 0) {
                    pairArr[5] = TuplesKt.to(FormValidatorKey.BILLS_PAYMENT_TYPE, ((FragmentGeneralBillsBottomSheetBinding) vb5).KClassImpl$Data$declaredNonStaticMembers$2.getSelectedPaymentType());
                    return new FormModel(MapsKt.mapOf(pairArr), MapsKt.mapOf(TuplesKt.to(FormValidatorKey.DROPDOWN_PROVIDER_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSaveBills$2
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str2) {
                            Intrinsics.checkNotNullParameter(str2, "");
                            return Boolean.valueOf(!StringsKt.isBlank(str2));
                        }
                    })), TuplesKt.to(FormValidatorKey.CUSTOMER_ID, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSaveBills$3
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str2) {
                            Intrinsics.checkNotNullParameter(str2, "");
                            return Boolean.valueOf(!StringsKt.isBlank(str2));
                        }
                    })), TuplesKt.to(FormValidatorKey.CUSTOMER_NAME, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSaveBills$4
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str2) {
                            Intrinsics.checkNotNullParameter(str2, "");
                            return Boolean.valueOf(!StringsKt.isBlank(str2));
                        }
                    })), TuplesKt.to(FormValidatorKey.AMOUNT, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSaveBills$5
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str2) {
                            Intrinsics.checkNotNullParameter(str2, "");
                            return Boolean.valueOf(!StringsKt.isBlank(str2));
                        }
                    })), TuplesKt.to(FormValidatorKey.BILLS_DATE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSaveBills$6
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str2) {
                            Intrinsics.checkNotNullParameter(str2, "");
                            return Boolean.valueOf(!StringsKt.isBlank(str2));
                        }
                    })), TuplesKt.to(FormValidatorKey.BILLS_PAYMENT_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$constructFormValidatorSaveBills$7
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str2) {
                            Intrinsics.checkNotNullParameter(str2, "");
                            return Boolean.valueOf(!StringsKt.isBlank(str2));
                        }
                    }))));
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        String str;
        MyBillsServiceModel myBillsServiceModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (myBillsServiceModel != null) {
            String bizProductCode = myBillsServiceModel.getBizProductCode();
            int hashCode = bizProductCode.hashCode();
            if (hashCode == 79159) {
                if (bizProductCode.equals("PGN")) {
                    str = "dana_pgn_2";
                    this.newProxyInstance = str;
                }
                str = this.newProxyInstance;
                this.newProxyInstance = str;
            } else if (hashCode != 2045463) {
                if (hashCode == 197254559 && bizProductCode.equals(BizProductCode.TELKOM)) {
                    str = "dana_telkom_phone_1";
                    this.newProxyInstance = str;
                }
                str = this.newProxyInstance;
                this.newProxyInstance = str;
            } else {
                if (bizProductCode.equals("BPJS")) {
                    str = "dana_bpjs_kesehatan_1";
                    this.newProxyInstance = str;
                }
                str = this.newProxyInstance;
                this.newProxyInstance = str;
            }
        }
        if (((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory.getValue().getKClassImpl$Data$declaredNonStaticMembers$2()) {
            ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda1());
        } else {
            ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).BuiltInFictitiousFunctionClassFactory(initRecordTimeStamp());
        }
    }

    private final String NetworkUserEntityData$$ExternalSyntheticLambda2() {
        MyBillsServiceModel serviceModel;
        String name;
        BizProductModel bizProductModel = this.PlaceComponentResult;
        if (bizProductModel == null || (serviceModel = bizProductModel.getServiceModel()) == null || (name = serviceModel.getName()) == null) {
            MyBillsServiceModel myBillsServiceModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String name2 = myBillsServiceModel != null ? myBillsServiceModel.getName() : null;
            return name2 == null ? "" : name2;
        }
        return name;
    }

    private final boolean isLayoutRequested() {
        return !this.NetworkUserEntityData$$ExternalSyntheticLambda2 && this.initRecordTimeStamp && this.DatabaseTableConfigUtil;
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2 && this.initRecordTimeStamp && !((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory.getValue().getKClassImpl$Data$declaredNonStaticMembers$2() && this.DatabaseTableConfigUtil;
    }

    /* renamed from: newProxyInstance  reason: from getter */
    private final boolean getGetContactSyncConfig() {
        return this.GetContactSyncConfig;
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return (this.NetworkUserEntityData$$ExternalSyntheticLambda2 || this.initRecordTimeStamp || !this.DatabaseTableConfigUtil) ? false : true;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.jvm.functions.Function0, java.lang.Integer] */
    public GeneralBillsBottomSheetFragment() {
        final GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = GeneralBillsBottomSheetFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$special$$inlined$viewModels$default$2
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
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(generalBillsBottomSheetFragment, Reflection.getOrCreateKotlinClass(AddNewBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$special$$inlined$viewModels$default$4
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
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = CollectionsKt.emptyList();
        this.newProxyInstance = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new DropdownOptionsModel(null, null, null, null, r6, 31, null);
        this.isLayoutRequested = LazyKt.lazy(new Function0<HighlightTransactionPayRequestModel>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment$payRequestModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HighlightTransactionPayRequestModel invoke() {
                return new HighlightTransactionPayRequestModel(null, null, null, null, null, 31, null);
            }
        });
        this.MyBillsEntityDataFactory = true;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(generalBillsBottomSheetFragment, "");
        if (generalBillsBottomSheetFragment.getGetContactSyncConfig()) {
            ((AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(((HighlightTransactionPayRequestModel) generalBillsBottomSheetFragment.isLayoutRequested.getValue()).getSubscriptionId());
        } else {
            ((AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).BuiltInFictitiousFunctionClassFactory(generalBillsBottomSheetFragment.DatabaseTableConfigUtil(), false);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, CustomDropdownView customDropdownView) {
        Intrinsics.checkNotNullParameter(generalBillsBottomSheetFragment, "");
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        if ((!generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda8.isEmpty()) == true) {
            customDropdownView.showOptions(!customDropdownView.isOptionsVisible());
            customDropdownView.setIsNeedToShowSearchText(customDropdownView.isOptionsVisible());
        }
    }

    public static /* synthetic */ void getAuthRequestContext(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(generalBillsBottomSheetFragment, "");
        if (generalBillsBottomSheetFragment.PrepareContext()) {
            generalBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsPurposeAction.PAY);
            AddNewBillsViewModel addNewBillsViewModel = (AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
            HighlightTransactionPayRequestModel highlightTransactionPayRequestModel = (HighlightTransactionPayRequestModel) generalBillsBottomSheetFragment.isLayoutRequested.getValue();
            highlightTransactionPayRequestModel.setTransactionAmount(generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getPrice());
            highlightTransactionPayRequestModel.setPayMode("DIRECT");
            addNewBillsViewModel.MyBillsEntityDataFactory(highlightTransactionPayRequestModel);
            return;
        }
        ((AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).BuiltInFictitiousFunctionClassFactory(generalBillsBottomSheetFragment.DatabaseTableConfigUtil(), true);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, FragmentGeneralBillsBottomSheetBinding fragmentGeneralBillsBottomSheetBinding, NestedScrollView nestedScrollView, int i, int i2) {
        Intrinsics.checkNotNullParameter(generalBillsBottomSheetFragment, "");
        Intrinsics.checkNotNullParameter(fragmentGeneralBillsBottomSheetBinding, "");
        Intrinsics.checkNotNullParameter(nestedScrollView, "");
        VB vb = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            if (((FragmentGeneralBillsBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.isOnFocusSearchBar()) {
                return;
            }
            if (i == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i < i2) {
                fragmentGeneralBillsBottomSheetBinding.KClassImpl$Data$declaredNonStaticMembers$2.getDropDownPaymentType().closeDropDownButton();
            }
            fragmentGeneralBillsBottomSheetBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.closeDropDownButton();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, SaveMyBillsSubscriptionModel saveMyBillsSubscriptionModel) {
        String subscriptionId = saveMyBillsSubscriptionModel.getSubscriptionId();
        if (subscriptionId != null) {
            HighlightTransactionPayRequestModel highlightTransactionPayRequestModel = (HighlightTransactionPayRequestModel) generalBillsBottomSheetFragment.isLayoutRequested.getValue();
            highlightTransactionPayRequestModel.setTransactionAmount(generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getPrice());
            highlightTransactionPayRequestModel.setPayMode("DIRECT");
            highlightTransactionPayRequestModel.setSubscriptionId(subscriptionId);
            if (((HighlightTransactionPayRequestModel) generalBillsBottomSheetFragment.isLayoutRequested.getValue()).getTransactionAmount() != null) {
                ((AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory((HighlightTransactionPayRequestModel) generalBillsBottomSheetFragment.isLayoutRequested.getValue());
            }
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment) {
        VB vb = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewFooterAddNewBillsBinding viewFooterAddNewBillsBinding = ((FragmentGeneralBillsBottomSheetBinding) vb).scheduleImpl;
            if (generalBillsBottomSheetFragment.getGetContactSyncConfig()) {
                DanaButtonSecondaryView danaButtonSecondaryView = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
                danaButtonSecondaryView.setVisibility(0);
                viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setEnabled(true);
                viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setActiveButton(generalBillsBottomSheetFragment.getString(R.string.my_bills_label_view_bill), null);
                DanaButtonPrimaryView danaButtonPrimaryView = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
                danaButtonPrimaryView.setVisibility(8);
                return;
            } else if (generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda8()) {
                DanaButtonPrimaryView danaButtonPrimaryView2 = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView2, "");
                danaButtonPrimaryView2.setVisibility(0);
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(true);
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(generalBillsBottomSheetFragment.getString(R.string.my_bills_label_pay), null);
                DanaButtonSecondaryView danaButtonSecondaryView2 = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
                danaButtonSecondaryView2.setVisibility(8);
                return;
            } else if (generalBillsBottomSheetFragment.isLayoutRequested()) {
                DanaButtonPrimaryView danaButtonPrimaryView3 = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView3, "");
                danaButtonPrimaryView3.setVisibility(0);
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(generalBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2);
                DanaButtonSecondaryView danaButtonSecondaryView3 = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView3, "");
                danaButtonSecondaryView3.setVisibility(((AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory.getValue().getKClassImpl$Data$declaredNonStaticMembers$2() ? 0 : 8);
                viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setEnabled(generalBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2);
                if (generalBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2 && ((AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory.getValue().getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(generalBillsBottomSheetFragment.getString(R.string.my_bills_label_save_pay), null);
                    viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setActiveButton(generalBillsBottomSheetFragment.getString(R.string.res_0x7f130f59_summaryvoucherview_externalsyntheticlambda0), null);
                    return;
                } else if (generalBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2 && !((AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory.getValue().getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(generalBillsBottomSheetFragment.getString(R.string.my_bills_label_pay), null);
                    return;
                } else if (!generalBillsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2 && ((AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory.getValue().getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(generalBillsBottomSheetFragment.getString(R.string.my_bills_label_save_pay));
                    viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory.setDisabled(generalBillsBottomSheetFragment.getString(R.string.res_0x7f130f59_summaryvoucherview_externalsyntheticlambda0));
                    return;
                } else {
                    viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(generalBillsBottomSheetFragment.getString(R.string.my_bills_label_pay));
                    return;
                }
            } else if (generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7()) {
                DanaButtonPrimaryView danaButtonPrimaryView4 = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView4, "");
                danaButtonPrimaryView4.setVisibility(8);
                DanaButtonSecondaryView danaButtonSecondaryView4 = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                danaButtonSecondaryView4.setActiveButton(generalBillsBottomSheetFragment.getString(R.string.my_bills_label_save_bill), null);
                danaButtonSecondaryView4.setEnabled(true);
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView4, "");
                danaButtonSecondaryView4.setVisibility(0);
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView4, "");
                return;
            } else {
                DanaButtonPrimaryView danaButtonPrimaryView5 = viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView5, "");
                danaButtonPrimaryView5.setVisibility(0);
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(generalBillsBottomSheetFragment.getString(R.string.my_bills_label_pay));
                viewFooterAddNewBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(false);
                DanaButtonSecondaryView danaButtonSecondaryView5 = viewFooterAddNewBillsBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView5, "");
                danaButtonSecondaryView5.setVisibility(8);
                return;
            }
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, String str) {
        MyBillsServiceModel myBillsServiceModel = generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (myBillsServiceModel != null) {
            ((AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory(generalBillsBottomSheetFragment.newProxyInstance, str, myBillsServiceModel.getBizType());
        }
    }

    public static final /* synthetic */ HighlightTransactionPayRequestModel scheduleImpl(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment) {
        return (HighlightTransactionPayRequestModel) generalBillsBottomSheetFragment.isLayoutRequested.getValue();
    }

    public static final /* synthetic */ AddNewBillsViewModel getErrorConfigVersion(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment) {
        return (AddNewBillsViewModel) generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue();
    }

    public static final /* synthetic */ void PlaceComponentResult(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, BizProductDestination bizProductDestination) {
        String customerName = bizProductDestination.getCustomerName();
        if (customerName != null) {
            VB vb = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb != 0) {
                CustomEditTextView customEditTextView = ((FragmentGeneralBillsBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(customEditTextView, "");
                customEditTextView.setVisibility(0);
                customEditTextView.setDisabled();
                customEditTextView.setText(customerName);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        MoneyView totalAmount = bizProductDestination.getTotalAmount();
        if (totalAmount != null) {
            VB vb2 = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                CustomEditTextView customEditTextView2 = ((FragmentGeneralBillsBottomSheetBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(customEditTextView2, "");
                customEditTextView2.setVisibility(0);
                customEditTextView2.setDisabled();
                generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7 = new DropdownOptionsModel(null, null, null, BillPaymentStatusModelKt.toMoneyViewModel(totalAmount), null, 23, null);
                customEditTextView2.setText(BillPaymentStatusModelKt.toMoneyViewModel(totalAmount).getDisplayAmount());
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda4();
    }

    public static final /* synthetic */ void moveToNextValue(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment) {
        FragmentActivity requireActivity = generalBillsBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.hideBlockerLoading();
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, CurrencyAmountModel currencyAmountModel) {
        VB vb = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((FragmentGeneralBillsBottomSheetBinding) vb).scheduleImpl.PlaceComponentResult.setBalance(MoneyViewModel.INSTANCE.fromCurrencyAmountModel(currencyAmountModel));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, List list) {
        generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda8 = list;
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(DropdownOptionsModelKt.toDropdownOptionsModel((ProductGoodsInfo) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        VB vb = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            CustomDropdownView customDropdownView = ((FragmentGeneralBillsBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
            customDropdownView.hasToShowDropdownSelectedValue(false);
            customDropdownView.setOptions(arrayList2);
            BizProductModel bizProductModel = generalBillsBottomSheetFragment.PlaceComponentResult;
            if (bizProductModel != null) {
                if (!generalBillsBottomSheetFragment.MyBillsEntityDataFactory) {
                    VB vb2 = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
                    if (vb2 != 0) {
                        CustomDropdownView customDropdownView2 = ((FragmentGeneralBillsBottomSheetBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
                        BizProductModel bizProductModel2 = generalBillsBottomSheetFragment.PlaceComponentResult;
                        Object obj = null;
                        String goodsId = bizProductModel2 != null ? bizProductModel2.getGoodsId() : null;
                        if (!(goodsId == null || goodsId.length() == 0)) {
                            Iterator<T> it2 = customDropdownView2.getItemOptions().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Object next = it2.next();
                                String id2 = ((DropdownOptionsModel) next).getId();
                                BizProductModel bizProductModel3 = generalBillsBottomSheetFragment.PlaceComponentResult;
                                if (Intrinsics.areEqual(id2, bizProductModel3 != null ? bizProductModel3.getGoodsId() : null)) {
                                    obj = next;
                                    break;
                                }
                            }
                            DropdownOptionsModel dropdownOptionsModel = (DropdownOptionsModel) obj;
                            if (dropdownOptionsModel != null) {
                                customDropdownView2.setSelected(dropdownOptionsModel);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                VB vb3 = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    ViewBodyGeneralBillsBinding viewBodyGeneralBillsBinding = ((FragmentGeneralBillsBottomSheetBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    CustomerIDProviderView customerIDProviderView = viewBodyGeneralBillsBinding.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(customerIDProviderView, "");
                    if (customerIDProviderView.getVisibility() == 0) {
                        viewBodyGeneralBillsBinding.PlaceComponentResult.getText().setText(bizProductModel.getBizId());
                    }
                    VB vb4 = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        PhoneNumberView phoneNumberView = ((FragmentGeneralBillsBottomSheetBinding) vb4).NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
                        Intrinsics.checkNotNullExpressionValue(phoneNumberView, "");
                        if (phoneNumberView.getVisibility() == 0) {
                            VB vb5 = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
                            if (vb5 != 0) {
                                ((FragmentGeneralBillsBottomSheetBinding) vb5).NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.setPhoneNumber(new PhoneNumberValidation(bizProductModel.getBizId(), bizProductModel.getGoodsIconUrl(), bizProductModel.getProviderName()));
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment) {
        VB vb = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            CustomerIDProviderView customerIDProviderView = ((FragmentGeneralBillsBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
            customerIDProviderView.setClearTextVisible(true);
            customerIDProviderView.setLoadingVisibility(false);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, AddNewBillsUiState.OnSuccessCheckUniqueValueAndCheckInquiry onSuccessCheckUniqueValueAndCheckInquiry) {
        int i = onSuccessCheckUniqueValueAndCheckInquiry.getKClassImpl$Data$declaredNonStaticMembers$2() ? R.string.my_bills_label_electricity_bills_is_registered : 0;
        if (i != 0) {
            VB vb = generalBillsBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb != 0) {
                ViewBodyGeneralBillsBinding viewBodyGeneralBillsBinding = ((FragmentGeneralBillsBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0;
                CustomerIDProviderView customerIDProviderView = viewBodyGeneralBillsBinding.PlaceComponentResult;
                CustomerIDProviderView customerIDProviderView2 = viewBodyGeneralBillsBinding.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(customerIDProviderView2, "");
                customerIDProviderView.setErrorMessage(customerIDProviderView2.getVisibility() == 0, generalBillsBottomSheetFragment.getString(i));
                PhoneNumberView phoneNumberView = viewBodyGeneralBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                PhoneNumberView phoneNumberView2 = viewBodyGeneralBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(phoneNumberView2, "");
                phoneNumberView.setErrorMessage(phoneNumberView2.getVisibility() == 0, generalBillsBottomSheetFragment.getString(i));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda8(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment) {
        FragmentActivity requireActivity = generalBillsBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.showBlockerLoading();
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, boolean z, String str) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = generalBillsBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
        myBillsAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsTrackerUtil.getAuthRequestContext(z, str), generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GeneralBillsBottomSheetFragment generalBillsBottomSheetFragment, String str) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = generalBillsBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        String NetworkUserEntityData$$ExternalSyntheticLambda2 = generalBillsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2();
        MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
        myBillsAnalyticTracker.MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda2, MyBillsTrackerUtil.BuiltInFictitiousFunctionClassFactory(str));
    }

    private final SaveSubscriptionRequestModel DatabaseTableConfigUtil() {
        String str;
        Object obj;
        MoneyView denom;
        MoneyViewModel moneyViewModel;
        MoneyView price;
        MoneyView denom2;
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            String billsName = ((FragmentGeneralBillsBottomSheetBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.getBillsName();
            if (billsName.length() == 0) {
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    billsName = ((FragmentGeneralBillsBottomSheetBinding) vb2).getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2.getText().toString();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            String str2 = billsName;
            VB vb3 = this.MyBillsEntityDataFactory;
            if (vb3 != 0) {
                String selectedPaymentType = ((FragmentGeneralBillsBottomSheetBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2.getSelectedPaymentType();
                VB vb4 = this.MyBillsEntityDataFactory;
                if (vb4 != 0) {
                    String id2 = ((FragmentGeneralBillsBottomSheetBinding) vb4).NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId();
                    VB vb5 = this.MyBillsEntityDataFactory;
                    if (vb5 != 0) {
                        Calendar kClassImpl$Data$declaredNonStaticMembers$2 = ((FragmentGeneralBillsBottomSheetBinding) vb5).KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2();
                        MyBillsServiceModel myBillsServiceModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        String str3 = null;
                        if (myBillsServiceModel == null) {
                            str = null;
                        } else if (myBillsServiceModel.isMobilePostpaid()) {
                            VB vb6 = this.MyBillsEntityDataFactory;
                            if (vb6 != 0) {
                                str = ((FragmentGeneralBillsBottomSheetBinding) vb6).NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getPhoneNumber().toString();
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            VB vb7 = this.MyBillsEntityDataFactory;
                            if (vb7 != 0) {
                                str = ((FragmentGeneralBillsBottomSheetBinding) vb7).NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.m2682getText();
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                        Iterator<T> it = this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (Intrinsics.areEqual(((ProductGoodsInfo) obj).getGoodsId(), this.newProxyInstance)) {
                                break;
                            }
                        }
                        ProductGoodsInfo productGoodsInfo = (ProductGoodsInfo) obj;
                        SaveSubscriptionRequestModel saveSubscriptionRequestModel = new SaveSubscriptionRequestModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
                        saveSubscriptionRequestModel.setTitle(str2);
                        saveSubscriptionRequestModel.setGoodsId(this.newProxyInstance);
                        saveSubscriptionRequestModel.setBillerId(str);
                        saveSubscriptionRequestModel.setRecurringType(selectedPaymentType);
                        MyBillsServiceModel myBillsServiceModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        saveSubscriptionRequestModel.setBizType(myBillsServiceModel2 != null ? myBillsServiceModel2.getBizType() : null);
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
                        if (productGoodsInfo != null && (denom = productGoodsInfo.getDenom()) != null && (moneyViewModel = BillPaymentStatusModelKt.toMoneyViewModel(denom)) != null) {
                            str3 = moneyViewModel.getDisplayAmount();
                        }
                        saveSubscriptionRequestModel.setExtendInfoTitle(str3);
                        this.PrepareContext = saveSubscriptionRequestModel;
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

    private final boolean PrepareContext() {
        return (((HighlightTransactionPayRequestModel) this.isLayoutRequested.getValue()).getSubscriptionId().length() > 0) && !((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).MyBillsEntityDataFactory.getValue().getKClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewBodyGeneralBillsBinding viewBodyGeneralBillsBinding = ((FragmentGeneralBillsBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (z) {
                viewBodyGeneralBillsBinding.PlaceComponentResult.setText("");
            }
            CustomerIDProviderView customerIDProviderView = viewBodyGeneralBillsBinding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(customerIDProviderView, "");
            CustomerIDProviderView.setErrorMessage$default(customerIDProviderView, false, null, 2, null);
            CustomEditTextView customEditTextView = viewBodyGeneralBillsBinding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(customEditTextView, "");
            customEditTextView.setVisibility(8);
            CustomEditTextView customEditTextView2 = viewBodyGeneralBillsBinding.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(customEditTextView2, "");
            customEditTextView2.setVisibility(8);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new DropdownOptionsModel(null, null, null, null, null, 31, null);
            CustomDropdownView customDropdownView = viewBodyGeneralBillsBinding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
            CustomDropdownView.setErrorMessage$default(customDropdownView, false, null, 2, null);
            this.DatabaseTableConfigUtil = false;
            this.GetContactSyncConfig = false;
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                BodySaveToBillsView bodySaveToBillsView = ((FragmentGeneralBillsBottomSheetBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2;
                bodySaveToBillsView.setIsSaveToMyBillsActive(false);
                bodySaveToBillsView.setSwitchAddToMyBillsChecked(false);
                ((AddNewBillsViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(new AddToMyBillsState(false, null, null, null, 15, null));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        MyBillsServiceModel serviceModel;
        String source;
        MyBillsAnalyticTracker myBillsAnalyticTracker = this.myBillsAnalyticTracker;
        String str2 = "";
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        String NetworkUserEntityData$$ExternalSyntheticLambda2 = NetworkUserEntityData$$ExternalSyntheticLambda2();
        BizProductModel bizProductModel = this.PlaceComponentResult;
        if (bizProductModel == null || (serviceModel = bizProductModel.getServiceModel()) == null || (source = serviceModel.getSource()) == null) {
            MyBillsServiceModel myBillsServiceModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
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
        ConstraintLayout constraintLayout = ((FragmentGeneralBillsBottomSheetBinding) vb).scheduleImpl.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        return constraintLayout;
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final ViewHeaderDetailBillsBinding NetworkUserEntityData$$ExternalSyntheticLambda0() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewHeaderDetailBillsBinding viewHeaderDetailBillsBinding = ((FragmentGeneralBillsBottomSheetBinding) vb).getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(viewHeaderDetailBillsBinding, "");
            return viewHeaderDetailBillsBinding;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final NestedScrollView moveToNextValue() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            NestedScrollView nestedScrollView = ((FragmentGeneralBillsBottomSheetBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
            return nestedScrollView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final MyBillsToolbarView GetContactSyncConfig() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            MyBillsToolbarView myBillsToolbarView = ((FragmentGeneralBillsBottomSheetBinding) vb).getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(myBillsToolbarView, "");
            return myBillsToolbarView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            RelativeLayout relativeLayout = ((FragmentGeneralBillsBottomSheetBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
            return relativeLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
