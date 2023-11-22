package id.dana.cashier.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierPromoListener;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.adapter.CashierPromoSelectionAdapter;
import id.dana.cashier.fragment.CashierPromoDetailFragment;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.databinding.FragmentCashierPromoSelectionBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.CashierComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.pay.PayActivity;
import id.dana.utils.LocationUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000b\u0010\u0005J\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\tR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0016\u0010\f\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0012\u0010\u0015\u001a\u00020\u0014X\u0087\"¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\u00020\u001a8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lid/dana/cashier/fragment/CashierPromoSelectionFragment;", "Lid/dana/cashier/fragment/BaseVBCashierFragment;", "Lid/dana/databinding/FragmentCashierPromoSelectionBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Lid/dana/cashier/model/VoucherCashierModel;", "p0", "PlaceComponentResult", "(Lid/dana/cashier/model/VoucherCashierModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "getAuthRequestContext", "", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/di/component/CashierComponent;", "scheduleImpl", "Lid/dana/di/component/CashierComponent;", "moveToNextValue", "Lid/dana/cashier/CashierContract$Presenter;", "cashierPresenter", "Lid/dana/cashier/CashierContract$Presenter;", "Lid/dana/cashier/CashierPromoListener;", "MyBillsEntityDataFactory", "Lid/dana/cashier/CashierPromoListener;", "Lid/dana/cashier/adapter/CashierPromoSelectionAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/cashier/adapter/CashierPromoSelectionAdapter;", "", "GetContactSyncConfig", "Z", "lookAheadTest", "initRecordTimeStamp", "getErrorConfigVersion", "", "isLayoutRequested", "J", "NetworkUserEntityData$$ExternalSyntheticLambda0", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPromoSelectionFragment extends BaseVBCashierFragment<FragmentCashierPromoSelectionBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean lookAheadTest;
    CashierPromoListener MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private CashierPromoSelectionAdapter PlaceComponentResult;
    @Inject
    public CashierContract.Presenter cashierPresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private long NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private CashierComponent getAuthRequestContext;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2 = "";

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory = "";

    public static /* synthetic */ void PlaceComponentResult() {
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
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

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ ViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCashierPromoSelectionBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentCashierPromoSelectionBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(VoucherCashierModel p0, boolean p1) {
                CashierPromoListener cashierPromoListener;
                FragmentActivity activity;
                FragmentManager supportFragmentManager;
                cashierPromoListener = CashierPromoSelectionFragment.this.MyBillsEntityDataFactory;
                if (cashierPromoListener != null) {
                    cashierPromoListener.MyBillsEntityDataFactory(p0, p1);
                }
                CashierPromoSelectionFragment cashierPromoSelectionFragment = CashierPromoSelectionFragment.this;
                if (!cashierPromoSelectionFragment.isVisible() || (activity = cashierPromoSelectionFragment.getActivity()) == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
                    return;
                }
                supportFragmentManager.popBackStack();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                CashierPromoSelectionFragment cashierPromoSelectionFragment = CashierPromoSelectionFragment.this;
                if (p0 == null) {
                    p0 = cashierPromoSelectionFragment.getString(R.string.SchedulerPoolFactory);
                    Intrinsics.checkNotNullExpressionValue(p0, "");
                }
                FragmentActivity activity = cashierPromoSelectionFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                CashierPromoSelectionFragment.this.SubSequence();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierPromoSelectionFragment.this.GetContactSyncConfig();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierPromoSelectionFragment.this.getContext());
            }
        }));
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$cashierRiskChallengeModule$1
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$topUpAndPayModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$cashierHighlightModule$1
        }));
        CashierComponent MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        this.getAuthRequestContext = MyBillsEntityDataFactory2;
        MyBillsEntityDataFactory2.getAuthRequestContext(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        CashierContract.Presenter presenter = this.cashierPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        BuiltInFictitiousFunctionClassFactory(abstractPresenterArr);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        String string = getString(R.string.promo_list);
        Intrinsics.checkNotNullExpressionValue(string, "");
        MyBillsEntityDataFactory(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(VoucherCashierModel p0) {
        FragmentActivity activity;
        FragmentManager supportFragmentManager;
        if (this.lookAheadTest) {
            PlaceComponentResult(p0);
            return;
        }
        CashierPromoListener cashierPromoListener = this.MyBillsEntityDataFactory;
        if (cashierPromoListener != null) {
            cashierPromoListener.MyBillsEntityDataFactory(p0, false);
        }
        if (!isVisible() || (activity = getActivity()) == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.popBackStack();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J[\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/cashier/fragment/CashierPromoSelectionFragment$Companion;", "", "Lid/dana/cashier/model/VoucherCashierModel;", "p0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "p1", "", "p2", "p3", "", "p4", "", "p5", "p6", "Lid/dana/cashier/fragment/CashierPromoSelectionFragment;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/VoucherCashierModel;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;ZJZ)Lid/dana/cashier/fragment/CashierPromoSelectionFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CashierPromoSelectionFragment MyBillsEntityDataFactory(VoucherCashierModel p0, ArrayList<VoucherCashierModel> p1, String p2, String p3, boolean p4, long p5, boolean p6) {
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            CashierPromoSelectionFragment cashierPromoSelectionFragment = new CashierPromoSelectionFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("cashier_promo", p0);
            bundle.putParcelableArrayList("cashier_promo_list", p1);
            bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, p2);
            bundle.putString("card_bin", p3);
            bundle.putBoolean("is_checkbox_mixpay_balance", p4);
            bundle.putLong("remaining_amount", p5);
            bundle.putBoolean("isOneKlik", p6);
            cashierPromoSelectionFragment.setArguments(bundle);
            return cashierPromoSelectionFragment;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(CashierPromoSelectionFragment cashierPromoSelectionFragment) {
        Intrinsics.checkNotNullParameter(cashierPromoSelectionFragment, "");
        cashierPromoSelectionFragment.getAuthRequestContext((VoucherCashierModel) null);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierPromoSelectionFragment cashierPromoSelectionFragment, CashierCheckoutRequestModel cashierCheckoutRequestModel, VoucherCashierModel voucherCashierModel) {
        Intrinsics.checkNotNullParameter(cashierPromoSelectionFragment, "");
        Intrinsics.checkNotNullParameter(cashierCheckoutRequestModel, "");
        CashierContract.Presenter presenter = cashierPromoSelectionFragment.cashierPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2(cashierCheckoutRequestModel, voucherCashierModel, true);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierPromoSelectionFragment cashierPromoSelectionFragment, VoucherCashierModel voucherCashierModel) {
        CashierPromoDetailFragment.Companion companion = CashierPromoDetailFragment.INSTANCE;
        CashierPromoDetailFragment authRequestContext = CashierPromoDetailFragment.Companion.getAuthRequestContext(voucherCashierModel);
        FragmentActivity activity = cashierPromoSelectionFragment.getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.addFragment(authRequestContext);
        }
    }

    private final void PlaceComponentResult(final VoucherCashierModel p0) {
        List emptyList;
        String str;
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (p0 == null || (str = p0.BuiltInFictitiousFunctionClassFactory) == null || (emptyList = CollectionsKt.listOf(str)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        final CashierCheckoutRequestModel cashierCheckoutRequestModel = new CashierCheckoutRequestModel(str2, null, null, null, null, null, null, Boolean.TRUE, emptyList, 0, null, false, null, 7294, null);
        CashierContract.Presenter presenter = null;
        if (this.getErrorConfigVersion) {
            if (p0 != null && p0.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getActivity());
                builder.FragmentBottomSheetPaymentSettingBinding = getString(R.string.mix_pay_promo_not_available_dialog_title);
                builder.getErrorConfigVersion = getString(R.string.mix_pay_promo_not_available_dialog_description);
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_promo_alert;
                builder.getAuthRequestContext = R.color.f27072131100488;
                TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
                Context context = getContext();
                String string = context != null ? context.getString(R.string.btn_continue) : null;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CashierPromoSelectionFragment.BuiltInFictitiousFunctionClassFactory(CashierPromoSelectionFragment.this, cashierCheckoutRequestModel, p0);
                    }
                };
                MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
                MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
                Context context2 = getContext();
                String string2 = context2 != null ? context2.getString(R.string.cancel_action) : null;
                View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CashierPromoSelectionFragment.PlaceComponentResult();
                    }
                };
                MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
                MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener2;
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
                return;
            }
        }
        CashierContract.Presenter presenter2 = this.cashierPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2(cashierCheckoutRequestModel, p0, false);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ConstraintLayout constraintLayout = ((FragmentCashierPromoSelectionBinding) vb).PlaceComponentResult.getAuthRequestContext;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            CashierPromoSelectionAdapter cashierPromoSelectionAdapter = new CashierPromoSelectionAdapter(new CashierPromoSelectionFragment$initCashierPromoSelectionAdapter$1(this), new CashierPromoSelectionFragment$initCashierPromoSelectionAdapter$2(this));
            this.PlaceComponentResult = cashierPromoSelectionAdapter;
            cashierPromoSelectionAdapter.getItems().clear();
            CashierPromoSelectionAdapter cashierPromoSelectionAdapter2 = this.PlaceComponentResult;
            CashierPromoSelectionAdapter cashierPromoSelectionAdapter3 = null;
            if (cashierPromoSelectionAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierPromoSelectionAdapter2 = null;
            }
            Bundle arguments = getArguments();
            String string = arguments != null ? arguments.getString(CashierKeyParams.CASHIER_ORDER_ID) : null;
            if (string == null) {
                string = "";
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = string;
            Bundle arguments2 = getArguments();
            String string2 = arguments2 != null ? arguments2.getString("card_bin") : null;
            if (string2 == null) {
                string2 = "";
            }
            this.BuiltInFictitiousFunctionClassFactory = string2;
            Bundle arguments3 = getArguments();
            this.lookAheadTest = arguments3 != null ? arguments3.getBoolean("is_checkbox_mixpay_balance") : false;
            Bundle arguments4 = getArguments();
            this.getErrorConfigVersion = arguments4 != null ? arguments4.getBoolean("isOneKlik") : false;
            Bundle arguments5 = getArguments();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = arguments5 != null ? arguments5.getLong("remaining_amount") : 0L;
            Bundle arguments6 = getArguments();
            ArrayList parcelableArrayList = arguments6 != null ? arguments6.getParcelableArrayList("cashier_promo_list") : null;
            Bundle arguments7 = getArguments();
            VoucherCashierModel voucherCashierModel = arguments7 != null ? (VoucherCashierModel) arguments7.getParcelable("cashier_promo") : null;
            ArrayList arrayList = new ArrayList();
            if (voucherCashierModel != null) {
                arrayList.add(voucherCashierModel);
            }
            if (parcelableArrayList != null) {
                arrayList.addAll(CollectionsKt.sortedWith(parcelableArrayList, new Comparator() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$prepareBundleData$lambda-3$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Boolean.valueOf(((VoucherCashierModel) t2).getNetworkUserEntityData$$ExternalSyntheticLambda1()), Boolean.valueOf(((VoucherCashierModel) t).getNetworkUserEntityData$$ExternalSyntheticLambda1()));
                    }
                }));
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                VoucherCashierModel voucherCashierModel2 = (VoucherCashierModel) obj;
                voucherCashierModel2.DatabaseTableConfigUtil = Intrinsics.areEqual(voucherCashierModel2.BuiltInFictitiousFunctionClassFactory, voucherCashierModel != null ? voucherCashierModel.BuiltInFictitiousFunctionClassFactory : null);
                if (hashSet.add(voucherCashierModel2.BuiltInFictitiousFunctionClassFactory)) {
                    arrayList2.add(obj);
                }
            }
            cashierPromoSelectionAdapter2.setItems(arrayList2);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                RecyclerView recyclerView = ((FragmentCashierPromoSelectionBinding) vb2).scheduleImpl;
                CashierPromoSelectionAdapter cashierPromoSelectionAdapter4 = this.PlaceComponentResult;
                if (cashierPromoSelectionAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    cashierPromoSelectionAdapter3 = cashierPromoSelectionAdapter4;
                }
                recyclerView.setAdapter(cashierPromoSelectionAdapter3);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentCashierPromoSelectionBinding) vb3).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierPromoSelectionFragment$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CashierPromoSelectionFragment.PlaceComponentResult(CashierPromoSelectionFragment.this);
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
