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
import androidx.view.C0207ViewKt;
import androidx.view.FlowExtKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.fragment.FragmentKt;
import androidx.view.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentMobileRechargeBottomSheetBinding;
import id.dana.mybills.databinding.ViewBodyMobileRechargeBillsBinding;
import id.dana.mybills.databinding.ViewHeaderDetailBillsBinding;
import id.dana.mybills.di.component.MyBillsComponent;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.di.provider.MyBillsComponentProvider;
import id.dana.mybills.domain.model.FormModel;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.ui.constant.FormValidatorKey;
import id.dana.mybills.ui.constant.GoodsType;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.constant.SubscriptionIntervalType;
import id.dana.mybills.ui.customview.BodySaveToBillsView;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.MyBillsToolbarView;
import id.dana.mybills.ui.customview.PhoneNumberView;
import id.dana.mybills.ui.model.BizProductModel;
import id.dana.mybills.ui.model.DropdownOptionsModel;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModel;
import id.dana.mybills.ui.model.MobileRechargeProductModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.model.MyBillsServiceModel;
import id.dana.mybills.ui.model.ProductGoodsModel;
import id.dana.mybills.ui.model.ProviderPackageModel;
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
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\bH\u0010#J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020!H\u0014¢\u0006\u0004\b$\u0010#J\u000f\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020%H\u0002¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020%H\u0002¢\u0006\u0004\b)\u0010'J\u000f\u0010*\u001a\u00020!H\u0002¢\u0006\u0004\b*\u0010#J\u0017\u0010+\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u0010\u0019\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010.R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010/R\u0016\u0010+\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u00100R\u0014\u0010\u001f\u001a\u00020%8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\r\u00100R\u0016\u00101\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00100R\u0014\u00102\u001a\u00020%8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u0016\u00100R\u0016\u00103\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u00100R\u0016\u0010\u0007\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00100R\u0016\u0010\u0004\u001a\u0004\u0018\u0001048\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b&\u00105R\u0012\u00107\u001a\u000206X\u0087\"¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\u0010\u001a\u0002098\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b*\u0010:R\u0018\u0010\u0016\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010<R\u0013\u0010\u001c\u001a\u00020\tX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u0010=R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b(\u0010>R\u0018\u0010\r\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010\n\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bB\u0010/R\u0012\u0010D\u001a\u00020CX\u0087\"¢\u0006\u0006\n\u0004\bD\u0010ER\u0013\u0010)\u001a\u00020FX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bG\u0010="}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/services/MobileRechargeBottomSheetFragment;", "Lid/dana/mybills/ui/v2/addnewbills/services/BaseMyBillsBottomSheet;", "Lid/dana/mybills/databinding/FragmentMobileRechargeBottomSheetBinding;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "scheduleImpl", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "DatabaseTableConfigUtil", "()Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "initRecordTimeStamp", "()Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "Landroidx/core/widget/NestedScrollView;", "moveToNextValue", "()Landroidx/core/widget/NestedScrollView;", "Lid/dana/mybills/ui/model/ProductGoodsModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Lid/dana/mybills/ui/model/ProductGoodsModel;", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "()Ljava/lang/String;", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "GetContactSyncConfig", "()Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "NetworkUserEntityData$$ExternalSyntheticLambda8", "()V", "getAuthRequestContext", "", "isLayoutRequested", "()Z", "newProxyInstance", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "PlaceComponentResult", "(Ljava/lang/String;)V", "Lid/dana/mybills/ui/model/BizProductModel;", "Lid/dana/mybills/ui/model/BizProductModel;", "Ljava/lang/String;", "Z", "BuiltInFictitiousFunctionClassFactory", "lookAheadTest", "getErrorConfigVersion", "Lid/dana/mybills/ui/model/MobileRechargeProductModel;", "Lid/dana/mybills/ui/model/MobileRechargeProductModel;", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "myBillsAnalyticTracker", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "Lid/dana/mybills/di/component/MyBillsComponent;", "Lid/dana/mybills/di/component/MyBillsComponent;", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "Lkotlin/Lazy;", "Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "Lkotlinx/coroutines/Job;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lkotlinx/coroutines/Job;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/mybills/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MobileRechargeBottomSheetFragment extends BaseMyBillsBottomSheet<FragmentMobileRechargeBottomSheetBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String getAuthRequestContext;
    private BizProductModel MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private Job initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final Lazy PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private String DatabaseTableConfigUtil = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private MyBillsComponent moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy GetContactSyncConfig;
    private boolean PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private MyBillsServiceModel NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private MobileRechargeProductModel scheduleImpl;
    @Inject
    public MyBillsAnalyticTracker myBillsAnalyticTracker;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private SaveSubscriptionRequestModel NetworkUserEntityData$$ExternalSyntheticLambda2;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ ViewBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentMobileRechargeBottomSheetBinding BuiltInFictitiousFunctionClassFactory = FragmentMobileRechargeBottomSheetBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater(), viewGroup);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet, id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        Parcelable parcelable;
        Parcelable parcelable2;
        super.getAuthRequestContext();
        String string = getString(R.string.my_bills_label_add_new_bills);
        Intrinsics.checkNotNullExpressionValue(string, "");
        super.getAuthRequestContext(string, R.drawable.res_0x7f08086b_networkuserentitydata_externalsyntheticlambda2, new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$init$1
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
                FragmentKt.getAuthRequestContext(MobileRechargeBottomSheetFragment.this).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        super.getAuthRequestContext("BUNDLE_KEY_MOBILE_RECHARGE");
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) arguments.getParcelable("BUNDLE_KEY_MOBILE_RECHARGE", MyBillsServiceModel.class);
            } else {
                Parcelable parcelable3 = arguments.getParcelable("BUNDLE_KEY_MOBILE_RECHARGE");
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
            BizProductModel bizProductModel = (BizProductModel) parcelable2;
            this.MyBillsEntityDataFactory = bizProductModel;
            this.PlaceComponentResult = bizProductModel != null;
        }
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.mybills.di.provider.MyBillsComponentProvider");
        }
        MyBillsComponent authRequestContext = ((MyBillsComponentProvider) applicationContext).provideMyBillsComponent().getAuthRequestContext();
        this.moveToNextValue = authRequestContext;
        authRequestContext.getAuthRequestContext(this);
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            final ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding = ((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue;
            final CustomDropdownView customDropdownView = viewBodyMobileRechargeBillsBinding.getAuthRequestContext;
            String string2 = getString(R.string.my_bills_label_service_type);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            customDropdownView.setTitle(string2);
            String string3 = getString(R.string.res_0x7f130f47_verifypinstatemanager_executeriskchallenge_2_2);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            customDropdownView.setHintDropdown(string3);
            customDropdownView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRechargeBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(MobileRechargeBottomSheetFragment.this, customDropdownView);
                }
            });
            customDropdownView.setListenerItemSelected(new CustomDropdownView.OnItemSelectedListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initDropdown$1$1$2
                @Override // id.dana.mybills.ui.customview.CustomDropdownView.OnItemSelectedListener
                public final void BuiltInFictitiousFunctionClassFactory(DropdownOptionsModel p0) {
                    String str;
                    boolean z;
                    Intrinsics.checkNotNullParameter(p0, "");
                    str = MobileRechargeBottomSheetFragment.this.DatabaseTableConfigUtil;
                    if (Intrinsics.areEqual(str, p0.getId())) {
                        return;
                    }
                    MobileRechargeBottomSheetFragment.this.DatabaseTableConfigUtil = String.valueOf(p0.getId());
                    z = MobileRechargeBottomSheetFragment.this.PlaceComponentResult;
                    if (!z) {
                        viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.clearSelectedOption();
                    }
                    viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setOptions(MobileRechargeBottomSheetFragment.getAuthRequestContext(MobileRechargeBottomSheetFragment.this));
                    BuildersKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(r3), null, null, new MobileRechargeBottomSheetFragment$checkPayButtonState$1(MobileRechargeBottomSheetFragment.this, null), 3, null);
                    ((AddNewBillsViewModel) MobileRechargeBottomSheetFragment.this.PrepareContext.getValue()).BuiltInFictitiousFunctionClassFactory("PULSA_PREPAID");
                }
            });
            final CustomDropdownView customDropdownView2 = viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            String string4 = getString(R.string.my_bills_label_product_type);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            customDropdownView2.setTitle(string4);
            String string5 = getString(R.string.my_bills_label_choose_product);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            customDropdownView2.setHintDropdown(string5);
            customDropdownView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRechargeBottomSheetFragment.PlaceComponentResult(ViewBodyMobileRechargeBillsBinding.this, this, customDropdownView2);
                }
            });
            customDropdownView2.setListenerItemSelected(new CustomDropdownView.OnItemSelectedListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initDropdown$1$2$2
                @Override // id.dana.mybills.ui.customview.CustomDropdownView.OnItemSelectedListener
                public final void BuiltInFictitiousFunctionClassFactory(DropdownOptionsModel p0) {
                    boolean z;
                    boolean z2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    VB vb2 = MobileRechargeBottomSheetFragment.this.MyBillsEntityDataFactory;
                    if (vb2 != 0) {
                        BodySaveToBillsView bodySaveToBillsView = ((FragmentMobileRechargeBottomSheetBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2;
                        MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment = MobileRechargeBottomSheetFragment.this;
                        z = mobileRechargeBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                        bodySaveToBillsView.setIsSaveToMyBillsActive(!z);
                        z2 = mobileRechargeBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                        bodySaveToBillsView.setSwitchAddToMyBillsChecked(!z2);
                        BuildersKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(r3), null, null, new MobileRechargeBottomSheetFragment$checkPayButtonState$1(MobileRechargeBottomSheetFragment.this, null), 3, null);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            });
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((FragmentMobileRechargeBottomSheetBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setDatePickerRangeListener(new Function1<IntRange, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initDropdown$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(IntRange intRange) {
                        invoke2(intRange);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(IntRange intRange) {
                        Intrinsics.checkNotNullParameter(intRange, "");
                        MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment = MobileRechargeBottomSheetFragment.this;
                        String string6 = mobileRechargeBottomSheetFragment.getString(R.string.res_0x7f130f2f_networkuserentitydata_externalsyntheticlambda4, String.valueOf(intRange.getFirst()), String.valueOf(intRange.getLast()));
                        Intrinsics.checkNotNullExpressionValue(string6, "");
                        mobileRechargeBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(string6);
                    }
                });
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    final ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding2 = ((FragmentMobileRechargeBottomSheetBinding) vb3).moveToNextValue;
                    PhoneNumberView phoneNumberView = viewBodyMobileRechargeBillsBinding2.BuiltInFictitiousFunctionClassFactory;
                    LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
                    phoneNumberView.setOnChangeListener(LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner), new Function2<String, String, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initBodyPart$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            boolean z;
                            Job job;
                            LifecycleCoroutineScope PlaceComponentResult;
                            Intrinsics.checkNotNullParameter(str, "");
                            Intrinsics.checkNotNullParameter(str2, "");
                            MobileRechargeBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(MobileRechargeBottomSheetFragment.this, str2);
                            MobileRechargeBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(MobileRechargeBottomSheetFragment.this, str.length() > 10);
                            z = MobileRechargeBottomSheetFragment.this.lookAheadTest;
                            if (z) {
                                job = MobileRechargeBottomSheetFragment.this.initRecordTimeStamp;
                                Job job2 = null;
                                if (job != null) {
                                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                                }
                                MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment = MobileRechargeBottomSheetFragment.this;
                                PhoneNumberView phoneNumberView2 = viewBodyMobileRechargeBillsBinding2.BuiltInFictitiousFunctionClassFactory;
                                Intrinsics.checkNotNullExpressionValue(phoneNumberView2, "");
                                LifecycleOwner PlaceComponentResult2 = C0207ViewKt.PlaceComponentResult(phoneNumberView2);
                                if (PlaceComponentResult2 != null && (PlaceComponentResult = LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult2)) != null) {
                                    job2 = BuildersKt__Builders_commonKt.launch$default(PlaceComponentResult, null, null, new AnonymousClass1(MobileRechargeBottomSheetFragment.this, str, null), 3, null);
                                }
                                mobileRechargeBottomSheetFragment.initRecordTimeStamp = job2;
                            }
                            if ((str.length() == 0) || str.length() < 5) {
                                MobileRechargeBottomSheetFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
                                MobileRechargeBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(MobileRechargeBottomSheetFragment.this, false);
                                MobileRechargeBottomSheetFragment.getAuthRequestContext(MobileRechargeBottomSheetFragment.this, false);
                                MobileRechargeBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(MobileRechargeBottomSheetFragment.this).setSubscriptionId("");
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                        @DebugMetadata(c = "id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initBodyPart$1$1$1", f = "MobileRechargeBottomSheetFragment.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initBodyPart$1$1$1  reason: invalid class name */
                        /* loaded from: classes9.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ String $phoneNumber;
                            int label;
                            final /* synthetic */ MobileRechargeBottomSheetFragment this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, String str, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.this$0 = mobileRechargeBottomSheetFragment;
                                this.$phoneNumber = str;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.this$0, this.$phoneNumber, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                }
                                MobileRechargeBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(this.this$0, this.$phoneNumber);
                                return Unit.INSTANCE;
                            }
                        }
                    });
                    VB vb4 = this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        BodySaveToBillsView bodySaveToBillsView = ((FragmentMobileRechargeBottomSheetBinding) vb4).KClassImpl$Data$declaredNonStaticMembers$2;
                        bodySaveToBillsView.setToggleSaveToMyBillsVisible(false);
                        bodySaveToBillsView.setIsSaveToMyBillsActive(false);
                        bodySaveToBillsView.setOnToggleCheckedChanged(new BodySaveToBillsView.OnToggleAddToMyBillsChecked() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initSwitchButton$1$1
                            @Override // id.dana.mybills.ui.customview.BodySaveToBillsView.OnToggleAddToMyBillsChecked
                            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                                MobileRechargeBottomSheetFragment.scheduleImpl(MobileRechargeBottomSheetFragment.this).KClassImpl$Data$declaredNonStaticMembers$2(AddToMyBillsState.getAuthRequestContext(MobileRechargeBottomSheetFragment.scheduleImpl(MobileRechargeBottomSheetFragment.this).MyBillsEntityDataFactory.getValue(), p0));
                                MobileRechargeBottomSheetFragment.PrepareContext(MobileRechargeBottomSheetFragment.this);
                            }
                        });
                        bodySaveToBillsView.setSwitchAddToMyBillsChecked(false);
                        StateFlow<AddNewBillsUiState> stateFlow = ((AddNewBillsViewModel) this.PrepareContext.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda8;
                        Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
                        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
                        Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new MobileRechargeBottomSheetFragment$initLifecycleActivity$1(this, null));
                        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
                        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "");
                        FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner2));
                        StateFlow<AddToMyBillsState> stateFlow2 = ((AddNewBillsViewModel) this.PrepareContext.getValue()).MyBillsEntityDataFactory;
                        Lifecycle lifecycle2 = getViewLifecycleOwner().getLifecycle();
                        Intrinsics.checkNotNullExpressionValue(lifecycle2, "");
                        Flow onEach2 = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow2, lifecycle2)), new MobileRechargeBottomSheetFragment$initLifecycleActivity$2(this, null));
                        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
                        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "");
                        FlowKt.launchIn(onEach2, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner3));
                        VB vb5 = this.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding3 = ((FragmentMobileRechargeBottomSheetBinding) vb5).moveToNextValue;
                            BizProductModel bizProductModel2 = this.MyBillsEntityDataFactory;
                            if (bizProductModel2 != null) {
                                if (bizProductModel2.getBizId().length() > 0) {
                                    viewBodyMobileRechargeBillsBinding3.BuiltInFictitiousFunctionClassFactory.setPhoneNumber(new PhoneNumberValidation(bizProductModel2.getBizId(), bizProductModel2.getGoodsIconUrl(), bizProductModel2.getProviderName()));
                                    viewBodyMobileRechargeBillsBinding3.getAuthRequestContext.setSelected(new DropdownOptionsModel(MyBillsEntityDataFactory(bizProductModel2.getGoodsType()), null, bizProductModel2.getGoodsType(), null, null, 24, null));
                                    viewBodyMobileRechargeBillsBinding3.KClassImpl$Data$declaredNonStaticMembers$2.setSelected(new DropdownOptionsModel(PrepareContext() ? bizProductModel2.getGoodsTitle() : bizProductModel2.getDenom().getDisplayAmount(), null, bizProductModel2.getGoodsId(), bizProductModel2.getDenom(), null, 16, null));
                                }
                            }
                            VB vb6 = this.MyBillsEntityDataFactory;
                            if (vb6 != 0) {
                                final FragmentMobileRechargeBottomSheetBinding fragmentMobileRechargeBottomSheetBinding = (FragmentMobileRechargeBottomSheetBinding) vb6;
                                fragmentMobileRechargeBottomSheetBinding.MyBillsEntityDataFactory.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$$ExternalSyntheticLambda3
                                    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                                    public final void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                                        MobileRechargeBottomSheetFragment.MyBillsEntityDataFactory(FragmentMobileRechargeBottomSheetBinding.this, nestedScrollView, i2, i4);
                                    }
                                });
                                VB vb7 = this.MyBillsEntityDataFactory;
                                if (vb7 != 0) {
                                    ((FragmentMobileRechargeBottomSheetBinding) vb7).scheduleImpl.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$$ExternalSyntheticLambda4
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            MobileRechargeBottomSheetFragment.PlaceComponentResult(MobileRechargeBottomSheetFragment.this);
                                        }
                                    });
                                    VB vb8 = this.MyBillsEntityDataFactory;
                                    if (vb8 != 0) {
                                        DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentMobileRechargeBottomSheetBinding) vb8).scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2;
                                        danaButtonPrimaryView.setEnabled(false);
                                        danaButtonPrimaryView.setDisabled(getString(R.string.my_bills_label_pay));
                                        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$$ExternalSyntheticLambda5
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                MobileRechargeBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(MobileRechargeBottomSheetFragment.this);
                                            }
                                        });
                                        VB vb9 = this.MyBillsEntityDataFactory;
                                        if (vb9 != 0) {
                                            ((FragmentMobileRechargeBottomSheetBinding) vb9).KClassImpl$Data$declaredNonStaticMembers$2.setOnIconInfoClick(new Function1<View, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initClickListeners$3
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
                                            ((AddNewBillsViewModel) this.PrepareContext.getValue()).MyBillsEntityDataFactory();
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

    private final ProductGoodsModel NetworkUserEntityData$$ExternalSyntheticLambda2() {
        Object obj;
        List<ProviderPackageModel> packages;
        ArrayList arrayList = new ArrayList();
        MobileRechargeProductModel mobileRechargeProductModel = this.scheduleImpl;
        if (mobileRechargeProductModel != null && (packages = mobileRechargeProductModel.getPackages()) != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : packages) {
                String type = ((ProviderPackageModel) obj2).getType();
                VB vb = this.MyBillsEntityDataFactory;
                if (vb != 0) {
                    if (Intrinsics.areEqual(type, ((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId())) {
                        arrayList2.add(obj2);
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                List<ProductGoodsModel> goods = ((ProviderPackageModel) it.next()).getGoods();
                if (goods != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj3 : goods) {
                        if (Intrinsics.areEqual(((ProductGoodsModel) obj3).getAvailable(), Boolean.TRUE)) {
                            arrayList3.add(obj3);
                        }
                    }
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it2 = arrayList3.iterator();
                    while (it2.hasNext()) {
                        arrayList.add((ProductGoodsModel) it2.next());
                        CollectionsKt.addAll(arrayList4, arrayList);
                    }
                }
            }
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj = null;
                break;
            }
            obj = it3.next();
            String goodsId = ((ProductGoodsModel) obj).getGoodsId();
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                if (Intrinsics.areEqual(goodsId, ((FragmentMobileRechargeBottomSheetBinding) vb2).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId())) {
                    break;
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        return (ProductGoodsModel) obj;
    }

    private final String MyBillsEntityDataFactory(String p0) {
        if (Intrinsics.areEqual(p0, GoodsType.MOBILE_DATA)) {
            String string = getString(R.string.my_bills_label_service_goods_mobile_data);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        } else if (Intrinsics.areEqual(p0, GoodsType.MOBILE_CREDIT)) {
            String string2 = getString(R.string.my_bills_label_service_goods_mobile_credit);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            return string2;
        } else {
            return p0;
        }
    }

    private final String NetworkUserEntityData$$ExternalSyntheticLambda1() {
        MyBillsServiceModel serviceModel;
        String name;
        BizProductModel bizProductModel = this.MyBillsEntityDataFactory;
        if (bizProductModel == null || (serviceModel = bizProductModel.getServiceModel()) == null || (name = serviceModel.getName()) == null) {
            MyBillsServiceModel myBillsServiceModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String name2 = myBillsServiceModel != null ? myBillsServiceModel.getName() : null;
            return name2 == null ? "" : name2;
        }
        return name;
    }

    public MobileRechargeBottomSheetFragment() {
        final MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = MobileRechargeBottomSheetFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$special$$inlined$viewModels$default$2
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
        this.PrepareContext = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(mobileRechargeBottomSheetFragment, Reflection.getOrCreateKotlinClass(AddNewBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$special$$inlined$viewModels$default$4
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
        this.GetContactSyncConfig = LazyKt.lazy(new Function0<HighlightTransactionPayRequestModel>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$payRequestModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HighlightTransactionPayRequestModel invoke() {
                return new HighlightTransactionPayRequestModel(null, null, null, null, null, 31, null);
            }
        });
        this.getAuthRequestContext = "";
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FragmentMobileRechargeBottomSheetBinding fragmentMobileRechargeBottomSheetBinding, NestedScrollView nestedScrollView, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragmentMobileRechargeBottomSheetBinding, "");
        Intrinsics.checkNotNullParameter(nestedScrollView, "");
        if (i == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i < i2) {
            fragmentMobileRechargeBottomSheetBinding.KClassImpl$Data$declaredNonStaticMembers$2.getDropDownPaymentType().closeDropDownButton();
        }
        fragmentMobileRechargeBottomSheetBinding.moveToNextValue.getAuthRequestContext.closeDropDownButton();
        fragmentMobileRechargeBottomSheetBinding.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.closeDropDownButton();
    }

    public static /* synthetic */ void PlaceComponentResult(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(mobileRechargeBottomSheetFragment, "");
        ((AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue()).BuiltInFictitiousFunctionClassFactory(mobileRechargeBottomSheetFragment.initRecordTimeStamp(), false);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(mobileRechargeBottomSheetFragment, "");
        if (mobileRechargeBottomSheetFragment.newProxyInstance()) {
            mobileRechargeBottomSheetFragment.PlaceComponentResult(MyBillsPurposeAction.PAY);
            ((AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue()).MyBillsEntityDataFactory(mobileRechargeBottomSheetFragment.DatabaseTableConfigUtil());
            return;
        }
        ((AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue()).BuiltInFictitiousFunctionClassFactory(mobileRechargeBottomSheetFragment.initRecordTimeStamp(), true);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CustomDropdownView customDropdownView) {
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        customDropdownView.showOptions(!customDropdownView.isOptionsVisible());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, CustomDropdownView customDropdownView) {
        Intrinsics.checkNotNullParameter(mobileRechargeBottomSheetFragment, "");
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        if (!mobileRechargeBottomSheetFragment.lookAheadTest || mobileRechargeBottomSheetFragment.scheduleImpl == null) {
            return;
        }
        mobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = !customDropdownView.isOptionsVisible();
        mobileRechargeBottomSheetFragment.getErrorConfigVersion = false;
        mobileRechargeBottomSheetFragment.BuiltInFictitiousFunctionClassFactory = false;
        mobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda8();
    }

    public static /* synthetic */ void PlaceComponentResult(ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding, MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, CustomDropdownView customDropdownView) {
        Intrinsics.checkNotNullParameter(viewBodyMobileRechargeBillsBinding, "");
        Intrinsics.checkNotNullParameter(mobileRechargeBottomSheetFragment, "");
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        if (Intrinsics.areEqual(viewBodyMobileRechargeBillsBinding.getAuthRequestContext.isOptionHasSelected(), Boolean.TRUE)) {
            mobileRechargeBottomSheetFragment.getErrorConfigVersion = !customDropdownView.isOptionsVisible();
            mobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            mobileRechargeBottomSheetFragment.BuiltInFictitiousFunctionClassFactory = false;
            mobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda8();
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, SaveMyBillsSubscriptionModel saveMyBillsSubscriptionModel) {
        String subscriptionId = saveMyBillsSubscriptionModel.getSubscriptionId();
        if (subscriptionId != null) {
            mobileRechargeBottomSheetFragment.DatabaseTableConfigUtil().setSubscriptionId(subscriptionId);
            if (((HighlightTransactionPayRequestModel) mobileRechargeBottomSheetFragment.GetContactSyncConfig.getValue()).getTransactionAmount() != null) {
                ((AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue()).MyBillsEntityDataFactory((HighlightTransactionPayRequestModel) mobileRechargeBottomSheetFragment.GetContactSyncConfig.getValue());
            }
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, String str) {
        String str2;
        if (str.length() > 10) {
            ((HighlightTransactionPayRequestModel) mobileRechargeBottomSheetFragment.GetContactSyncConfig.getValue()).setSubscriptionId("");
            AddNewBillsViewModel addNewBillsViewModel = (AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue();
            MyBillsServiceModel myBillsServiceModel = mobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (myBillsServiceModel == null || (str2 = myBillsServiceModel.getBizType()) == null) {
                str2 = "PULSA_PREPAID";
            }
            addNewBillsViewModel.BuiltInFictitiousFunctionClassFactory(str, str2);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, String str) {
        if ((mobileRechargeBottomSheetFragment.getAuthRequestContext.length() == 0) || !Intrinsics.areEqual(mobileRechargeBottomSheetFragment.getAuthRequestContext, str)) {
            mobileRechargeBottomSheetFragment.getAuthRequestContext = str;
            mobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda7();
            ((AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue()).MyBillsEntityDataFactory(str);
        }
    }

    public static final /* synthetic */ HighlightTransactionPayRequestModel BuiltInFictitiousFunctionClassFactory(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment) {
        return (HighlightTransactionPayRequestModel) mobileRechargeBottomSheetFragment.GetContactSyncConfig.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.util.List getAuthRequestContext(id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment r17) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment.getAuthRequestContext(id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment):java.util.List");
    }

    public static final /* synthetic */ AddNewBillsViewModel scheduleImpl(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment) {
        return (AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue();
    }

    public static final /* synthetic */ void getErrorConfigVersion(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment) {
        FragmentActivity requireActivity = mobileRechargeBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.hideBlockerLoading();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, CurrencyAmountModel currencyAmountModel) {
        VB vb = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((FragmentMobileRechargeBottomSheetBinding) vb).scheduleImpl.PlaceComponentResult.setBalance(MoneyViewModel.INSTANCE.fromCurrencyAmountModel(currencyAmountModel));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void getAuthRequestContext(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, boolean z) {
        mobileRechargeBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(mobileRechargeBottomSheetFragment), null, null, new MobileRechargeBottomSheetFragment$checkPayButtonState$1(mobileRechargeBottomSheetFragment, null), 3, null);
    }

    public static final /* synthetic */ void PlaceComponentResult(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, MobileRechargeProductModel mobileRechargeProductModel) {
        Object obj;
        Object obj2;
        List<ProviderPackageModel> packages;
        mobileRechargeBottomSheetFragment.scheduleImpl = mobileRechargeProductModel;
        VB vb = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            CustomDropdownView customDropdownView = ((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue.getAuthRequestContext;
            ArrayList arrayList = new ArrayList();
            MobileRechargeProductModel mobileRechargeProductModel2 = mobileRechargeBottomSheetFragment.scheduleImpl;
            if (mobileRechargeProductModel2 != null && (packages = mobileRechargeProductModel2.getPackages()) != null) {
                for (ProviderPackageModel providerPackageModel : packages) {
                    String type = providerPackageModel.getType();
                    if (type == null) {
                        type = "";
                    }
                    String MyBillsEntityDataFactory = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory(type);
                    if (MyBillsEntityDataFactory.length() > 0) {
                        arrayList.add(new DropdownOptionsModel(MyBillsEntityDataFactory, null, providerPackageModel.getType(), null, null, 24, null));
                    }
                }
            }
            customDropdownView.setOptions(arrayList);
            BizProductModel bizProductModel = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
            if (mobileRechargeBottomSheetFragment.PlaceComponentResult) {
                VB vb2 = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding = ((FragmentMobileRechargeBottomSheetBinding) vb2).moveToNextValue;
                    Iterator<T> it = viewBodyMobileRechargeBillsBinding.getAuthRequestContext.getItemOptions().iterator();
                    while (true) {
                        obj = null;
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        if (Intrinsics.areEqual(((DropdownOptionsModel) obj2).getId(), bizProductModel != null ? bizProductModel.getGoodsType() : null)) {
                            break;
                        }
                    }
                    DropdownOptionsModel dropdownOptionsModel = (DropdownOptionsModel) obj2;
                    if (dropdownOptionsModel != null) {
                        viewBodyMobileRechargeBillsBinding.getAuthRequestContext.setSelected(dropdownOptionsModel);
                    }
                    Iterator<T> it2 = viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.getItemOptions().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next = it2.next();
                        if (Intrinsics.areEqual(((DropdownOptionsModel) next).getId(), bizProductModel != null ? bizProductModel.getGoodsId() : null)) {
                            obj = next;
                            break;
                        }
                    }
                    DropdownOptionsModel dropdownOptionsModel2 = (DropdownOptionsModel) obj;
                    if (dropdownOptionsModel2 != null) {
                        viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setSelected(dropdownOptionsModel2);
                    } else {
                        viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.clearSelectedOption();
                    }
                    mobileRechargeBottomSheetFragment.PlaceComponentResult = false;
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, boolean z) {
        mobileRechargeBottomSheetFragment.lookAheadTest = z;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(mobileRechargeBottomSheetFragment), null, null, new MobileRechargeBottomSheetFragment$checkPayButtonState$1(mobileRechargeBottomSheetFragment, null), 3, null);
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment) {
        FragmentActivity requireActivity = mobileRechargeBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.showBlockerLoading();
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, boolean z) {
        String authRequestContext;
        MyBillsAnalyticTracker myBillsAnalyticTracker = mobileRechargeBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
        authRequestContext = MyBillsTrackerUtil.getAuthRequestContext(z, "");
        myBillsAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, mobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, String str) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = mobileRechargeBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        String NetworkUserEntityData$$ExternalSyntheticLambda1 = mobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1();
        MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
        myBillsAnalyticTracker.MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsTrackerUtil.BuiltInFictitiousFunctionClassFactory(str));
    }

    public static final /* synthetic */ void PrepareContext(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment) {
        if (((AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue()).MyBillsEntityDataFactory.getValue().getKClassImpl$Data$declaredNonStaticMembers$2()) {
            AddNewBillsViewModel addNewBillsViewModel = (AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue();
            Pair[] pairArr = new Pair[5];
            VB vb = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb != 0) {
                pairArr[0] = TuplesKt.to(FormValidatorKey.CUSTOMER_ID, ((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue.BuiltInFictitiousFunctionClassFactory.getPhoneNumber().toString());
                VB vb2 = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    String id2 = ((FragmentMobileRechargeBottomSheetBinding) vb2).moveToNextValue.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId();
                    if (id2 == null) {
                        id2 = "";
                    }
                    pairArr[1] = TuplesKt.to(FormValidatorKey.DROPDOWN_SERVICE_TYPE, id2);
                    VB vb3 = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
                    if (vb3 != 0) {
                        String name = ((FragmentMobileRechargeBottomSheetBinding) vb3).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.getNetworkUserEntityData$$ExternalSyntheticLambda0().getName();
                        pairArr[2] = TuplesKt.to(FormValidatorKey.DROPDOWN_PROVIDER_TYPE, name != null ? name : "");
                        VB vb4 = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
                        if (vb4 != 0) {
                            pairArr[3] = TuplesKt.to(FormValidatorKey.BILLS_DATE, ((FragmentMobileRechargeBottomSheetBinding) vb4).KClassImpl$Data$declaredNonStaticMembers$2.getSelectedDate());
                            VB vb5 = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
                            if (vb5 != 0) {
                                pairArr[4] = TuplesKt.to(FormValidatorKey.BILLS_PAYMENT_TYPE, ((FragmentMobileRechargeBottomSheetBinding) vb5).KClassImpl$Data$declaredNonStaticMembers$2.getSelectedPaymentType());
                                addNewBillsViewModel.BuiltInFictitiousFunctionClassFactory(new FormModel(MapsKt.mapOf(pairArr), MapsKt.mapOf(TuplesKt.to(FormValidatorKey.CUSTOMER_ID, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$constructFormValidatorSaveBills$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(String str) {
                                        Intrinsics.checkNotNullParameter(str, "");
                                        return Boolean.valueOf(!StringsKt.isBlank(str));
                                    }
                                })), TuplesKt.to(FormValidatorKey.DROPDOWN_SERVICE_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$constructFormValidatorSaveBills$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(String str) {
                                        Intrinsics.checkNotNullParameter(str, "");
                                        return Boolean.valueOf(!StringsKt.isBlank(str));
                                    }
                                })), TuplesKt.to(FormValidatorKey.DROPDOWN_PROVIDER_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$constructFormValidatorSaveBills$3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(String str) {
                                        Intrinsics.checkNotNullParameter(str, "");
                                        return Boolean.valueOf(!StringsKt.isBlank(str));
                                    }
                                })), TuplesKt.to(FormValidatorKey.BILLS_DATE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$constructFormValidatorSaveBills$4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(String str) {
                                        Intrinsics.checkNotNullParameter(str, "");
                                        return Boolean.valueOf(!StringsKt.isBlank(str));
                                    }
                                })), TuplesKt.to(FormValidatorKey.BILLS_PAYMENT_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$constructFormValidatorSaveBills$5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(String str) {
                                        Intrinsics.checkNotNullParameter(str, "");
                                        return Boolean.valueOf(!StringsKt.isBlank(str));
                                    }
                                })))));
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
        AddNewBillsViewModel addNewBillsViewModel2 = (AddNewBillsViewModel) mobileRechargeBottomSheetFragment.PrepareContext.getValue();
        Pair[] pairArr2 = new Pair[3];
        VB vb6 = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb6 != 0) {
            pairArr2[0] = TuplesKt.to(FormValidatorKey.CUSTOMER_ID, ((FragmentMobileRechargeBottomSheetBinding) vb6).moveToNextValue.BuiltInFictitiousFunctionClassFactory.getPhoneNumber().toString());
            VB vb7 = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
            if (vb7 != 0) {
                String id3 = ((FragmentMobileRechargeBottomSheetBinding) vb7).moveToNextValue.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId();
                if (id3 == null) {
                    id3 = "";
                }
                pairArr2[1] = TuplesKt.to(FormValidatorKey.DROPDOWN_SERVICE_TYPE, id3);
                VB vb8 = mobileRechargeBottomSheetFragment.MyBillsEntityDataFactory;
                if (vb8 != 0) {
                    String name2 = ((FragmentMobileRechargeBottomSheetBinding) vb8).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.getNetworkUserEntityData$$ExternalSyntheticLambda0().getName();
                    pairArr2[2] = TuplesKt.to(FormValidatorKey.DROPDOWN_PROVIDER_TYPE, name2 != null ? name2 : "");
                    addNewBillsViewModel2.BuiltInFictitiousFunctionClassFactory(new FormModel(MapsKt.mapOf(pairArr2), MapsKt.mapOf(TuplesKt.to(FormValidatorKey.CUSTOMER_ID, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$constructFormValidatorSinglePay$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str) {
                            Intrinsics.checkNotNullParameter(str, "");
                            return Boolean.valueOf(!StringsKt.isBlank(str));
                        }
                    })), TuplesKt.to(FormValidatorKey.DROPDOWN_SERVICE_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$constructFormValidatorSinglePay$2
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str) {
                            Intrinsics.checkNotNullParameter(str, "");
                            return Boolean.valueOf(!StringsKt.isBlank(str));
                        }
                    })), TuplesKt.to(FormValidatorKey.DROPDOWN_PROVIDER_TYPE, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$constructFormValidatorSinglePay$3
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String str) {
                            Intrinsics.checkNotNullParameter(str, "");
                            return Boolean.valueOf(!StringsKt.isBlank(str));
                        }
                    })))));
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final HighlightTransactionPayRequestModel DatabaseTableConfigUtil() {
        HighlightTransactionPayRequestModel highlightTransactionPayRequestModel = (HighlightTransactionPayRequestModel) this.GetContactSyncConfig.getValue();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            highlightTransactionPayRequestModel.setTransactionAmount(((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.getNetworkUserEntityData$$ExternalSyntheticLambda0().getPrice());
            highlightTransactionPayRequestModel.setPayMode("DIRECT");
            return highlightTransactionPayRequestModel;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final SaveSubscriptionRequestModel initRecordTimeStamp() {
        MoneyViewModel denom;
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            String billsName = ((FragmentMobileRechargeBottomSheetBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.getBillsName();
            if (billsName.length() == 0) {
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    billsName = ((FragmentMobileRechargeBottomSheetBinding) vb2).lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2.getText().toString();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            String str = billsName;
            VB vb3 = this.MyBillsEntityDataFactory;
            if (vb3 != 0) {
                DropdownOptionsModel networkUserEntityData$$ExternalSyntheticLambda0 = ((FragmentMobileRechargeBottomSheetBinding) vb3).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.getNetworkUserEntityData$$ExternalSyntheticLambda0();
                VB vb4 = this.MyBillsEntityDataFactory;
                if (vb4 != 0) {
                    String selectedPaymentType = ((FragmentMobileRechargeBottomSheetBinding) vb4).KClassImpl$Data$declaredNonStaticMembers$2.getSelectedPaymentType();
                    VB vb5 = this.MyBillsEntityDataFactory;
                    if (vb5 != 0) {
                        String id2 = ((FragmentMobileRechargeBottomSheetBinding) vb5).moveToNextValue.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId();
                        VB vb6 = this.MyBillsEntityDataFactory;
                        if (vb6 != 0) {
                            Calendar kClassImpl$Data$declaredNonStaticMembers$2 = ((FragmentMobileRechargeBottomSheetBinding) vb6).KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2();
                            String str2 = null;
                            SaveSubscriptionRequestModel saveSubscriptionRequestModel = new SaveSubscriptionRequestModel(null, null, null, null, null, null, str2, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
                            saveSubscriptionRequestModel.setTitle(str);
                            saveSubscriptionRequestModel.setGoodsId(networkUserEntityData$$ExternalSyntheticLambda0.getId());
                            VB vb7 = this.MyBillsEntityDataFactory;
                            if (vb7 != 0) {
                                saveSubscriptionRequestModel.setBillerId(((FragmentMobileRechargeBottomSheetBinding) vb7).moveToNextValue.BuiltInFictitiousFunctionClassFactory.getPhoneNumber().toString());
                                saveSubscriptionRequestModel.setRecurringType(selectedPaymentType);
                                saveSubscriptionRequestModel.setBizType("PULSA_PREPAID");
                                saveSubscriptionRequestModel.setMessage(str);
                                saveSubscriptionRequestModel.setSubscriptionDayOfMonth(String.valueOf(kClassImpl$Data$declaredNonStaticMembers$2.get(5)));
                                saveSubscriptionRequestModel.setSubscriptionHourOfDay(String.valueOf(kClassImpl$Data$declaredNonStaticMembers$2.get(11)));
                                saveSubscriptionRequestModel.setSubscriptionMonthOfYear(String.valueOf(kClassImpl$Data$declaredNonStaticMembers$2.get(2)));
                                saveSubscriptionRequestModel.setSubscriptionIntervalType(SubscriptionIntervalType.MONTHLY);
                                saveSubscriptionRequestModel.setProvider(this.getAuthRequestContext);
                                saveSubscriptionRequestModel.setType(id2);
                                saveSubscriptionRequestModel.setTimezone(TimeZone.getDefault().getDisplayName(false, 0));
                                saveSubscriptionRequestModel.setPaymentMethod("BALANCE");
                                saveSubscriptionRequestModel.setPayMode(Intrinsics.areEqual(selectedPaymentType, RecurringType.REMINDER) ? "DIRECT" : "AUTO_DEBIT");
                                ProductGoodsModel NetworkUserEntityData$$ExternalSyntheticLambda2 = NetworkUserEntityData$$ExternalSyntheticLambda2();
                                String str3 = null;
                                saveSubscriptionRequestModel.setDenom(NetworkUserEntityData$$ExternalSyntheticLambda2 != null ? NetworkUserEntityData$$ExternalSyntheticLambda2.getDenom() : null);
                                ProductGoodsModel NetworkUserEntityData$$ExternalSyntheticLambda22 = NetworkUserEntityData$$ExternalSyntheticLambda2();
                                saveSubscriptionRequestModel.setTotalAmount(NetworkUserEntityData$$ExternalSyntheticLambda22 != null ? NetworkUserEntityData$$ExternalSyntheticLambda22.getPrice() : null);
                                ProductGoodsModel NetworkUserEntityData$$ExternalSyntheticLambda23 = NetworkUserEntityData$$ExternalSyntheticLambda2();
                                saveSubscriptionRequestModel.setProductTitle(NetworkUserEntityData$$ExternalSyntheticLambda23 != null ? NetworkUserEntityData$$ExternalSyntheticLambda23.getGoodsTitle() : null);
                                ProductGoodsModel NetworkUserEntityData$$ExternalSyntheticLambda24 = NetworkUserEntityData$$ExternalSyntheticLambda2();
                                if (NetworkUserEntityData$$ExternalSyntheticLambda24 != null && (denom = NetworkUserEntityData$$ExternalSyntheticLambda24.getDenom()) != null) {
                                    str3 = denom.getDisplayAmount();
                                }
                                saveSubscriptionRequestModel.setExtendInfoTitle(str3);
                                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = saveSubscriptionRequestModel;
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

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding = ((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue;
            viewBodyMobileRechargeBillsBinding.getAuthRequestContext.showOptions(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            final CustomDropdownView customDropdownView = viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            customDropdownView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileRechargeBottomSheetFragment.MyBillsEntityDataFactory(CustomDropdownView.this);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final boolean isLayoutRequested() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            Boolean isOptionHasSelected = ((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue.getAuthRequestContext.isOptionHasSelected();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(isOptionHasSelected, bool)) {
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    if (Intrinsics.areEqual(((FragmentMobileRechargeBottomSheetBinding) vb2).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.isOptionHasSelected(), bool)) {
                        return true;
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final boolean newProxyInstance() {
        return (((HighlightTransactionPayRequestModel) this.GetContactSyncConfig.getValue()).getSubscriptionId().length() > 0) && !((AddNewBillsViewModel) this.PrepareContext.getValue()).MyBillsEntityDataFactory.getValue().getKClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final boolean PrepareContext() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            return Intrinsics.areEqual(((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId(), GoodsType.MOBILE_DATA);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding = ((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue;
            if (!this.PlaceComponentResult) {
                viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.resetDropdown();
                viewBodyMobileRechargeBillsBinding.getAuthRequestContext.clearSelectedOption();
            }
            CustomDropdownView customDropdownView = viewBodyMobileRechargeBillsBinding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
            CustomDropdownView.setErrorMessage$default(customDropdownView, false, null, 2, null);
            viewBodyMobileRechargeBillsBinding.getAuthRequestContext.setLoadingVisibility(false);
            CustomDropdownView customDropdownView2 = viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(customDropdownView2, "");
            CustomDropdownView.setErrorMessage$default(customDropdownView2, false, null, 2, null);
            viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setLoadingVisibility(false);
            ((AddNewBillsViewModel) this.PrepareContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(new AddToMyBillsState(false, null, null, null, 15, null));
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                BodySaveToBillsView bodySaveToBillsView = ((FragmentMobileRechargeBottomSheetBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2;
                bodySaveToBillsView.setSwitchAddToMyBillsChecked(false);
                bodySaveToBillsView.setIsSaveToMyBillsActive(false);
                this.BuiltInFictitiousFunctionClassFactory = false;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                this.getErrorConfigVersion = false;
                NetworkUserEntityData$$ExternalSyntheticLambda8();
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void PlaceComponentResult(String p0) {
        MyBillsServiceModel serviceModel;
        String source;
        MyBillsAnalyticTracker myBillsAnalyticTracker = this.myBillsAnalyticTracker;
        String str = "";
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        String NetworkUserEntityData$$ExternalSyntheticLambda1 = NetworkUserEntityData$$ExternalSyntheticLambda1();
        BizProductModel bizProductModel = this.MyBillsEntityDataFactory;
        if (bizProductModel == null || (serviceModel = bizProductModel.getServiceModel()) == null || (source = serviceModel.getSource()) == null) {
            MyBillsServiceModel myBillsServiceModel = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String source2 = myBillsServiceModel != null ? myBillsServiceModel.getSource() : null;
            if (source2 != null) {
                str = source2;
            }
        } else {
            str = source;
        }
        myBillsAnalyticTracker.MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda1, str, p0);
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final ConstraintLayout scheduleImpl() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ConstraintLayout constraintLayout = ((FragmentMobileRechargeBottomSheetBinding) vb).scheduleImpl.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        return constraintLayout;
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final ViewHeaderDetailBillsBinding NetworkUserEntityData$$ExternalSyntheticLambda0() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ViewHeaderDetailBillsBinding viewHeaderDetailBillsBinding = ((FragmentMobileRechargeBottomSheetBinding) vb).lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(viewHeaderDetailBillsBinding, "");
            return viewHeaderDetailBillsBinding;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final NestedScrollView moveToNextValue() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            NestedScrollView nestedScrollView = ((FragmentMobileRechargeBottomSheetBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
            return nestedScrollView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    protected final MyBillsToolbarView GetContactSyncConfig() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            MyBillsToolbarView myBillsToolbarView = ((FragmentMobileRechargeBottomSheetBinding) vb).getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(myBillsToolbarView, "");
            return myBillsToolbarView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            RelativeLayout relativeLayout = ((FragmentMobileRechargeBottomSheetBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
            return relativeLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
