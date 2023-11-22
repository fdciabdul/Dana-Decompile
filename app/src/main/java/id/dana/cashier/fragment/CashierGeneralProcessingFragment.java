package id.dana.cashier.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.helper.CashierVariables;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierFaceAuthModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayChannelModelKt;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.OneKlikPhonesModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.ProcessingMilestoneModel;
import id.dana.cashier.model.RiskVerificationMethodModel;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.databinding.FragmentCashierGeneralProcessingBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.CashierComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005JC\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0015\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0016R\u0012\u0010\u0018\u001a\u00020\u0017X\u0087\"¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u00078\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0012\u0010!\u001a\u00020 X\u0087\"¢\u0006\u0006\n\u0004\b!\u0010\"R\u0013\u0010%\u001a\u00020\u0007X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b#\u0010$R\u0012\u0010'\u001a\u00020&X\u0087\"¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b)\u0010\u001f"}, d2 = {"Lid/dana/cashier/fragment/CashierGeneralProcessingFragment;", "Lid/dana/cashier/fragment/BaseCashierRiskFragment;", "Lid/dana/databinding/FragmentCashierGeneralProcessingBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", DiskFormatter.B, "", "p0", "p1", "p2", "p3", "p4", "", "p5", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "getCallingPid", "readMicros", "whenAvailable", "(Z)V", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "cashierAnalyticTracker", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "Lid/dana/di/component/CashierComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/di/component/CashierComponent;", "PlaceComponentResult", "GetContactSyncConfig", "Ljava/lang/String;", "Lid/dana/cashier/CashierContract$Presenter;", "cashierPresenter", "Lid/dana/cashier/CashierContract$Presenter;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "cashierRiskChallengePresenter", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "isLayoutRequested", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierGeneralProcessingFragment extends BaseCashierRiskFragment<FragmentCashierGeneralProcessingBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private CashierComponent PlaceComponentResult;
    @Inject
    public CashierAnalyticTracker cashierAnalyticTracker;
    @Inject
    public CashierContract.Presenter cashierPresenter;
    @Inject
    public CashierRiskChallengePresenter cashierRiskChallengePresenter;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String getAuthRequestContext;
    public Map<Integer, View> initRecordTimeStamp = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<String>() { // from class: id.dana.cashier.fragment.CashierGeneralProcessingFragment$cashierRequestId$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = CashierGeneralProcessingFragment.this.getArguments();
            String string = arguments != null ? arguments.getString("cashierRequestId") : null;
            return string == null ? "" : string;
        }
    });

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.initRecordTimeStamp;
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

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.initRecordTimeStamp.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ ViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCashierGeneralProcessingBinding BuiltInFictitiousFunctionClassFactory = FragmentCashierGeneralProcessingBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        String string = getString(R.string.cashier_general_processing_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        MyBillsEntityDataFactory(string);
        newProxyInstance();
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierGeneralProcessingFragment$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierGeneralProcessingFragment.getAuthRequestContext(CashierGeneralProcessingFragment.this, p0.KClassImpl$Data$declaredNonStaticMembers$2, Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE), p0.getAuthRequestContext);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierGeneralProcessingFragment.this.B();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierGeneralProcessingFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierGeneralProcessingFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                CashierGeneralProcessingFragment cashierGeneralProcessingFragment = CashierGeneralProcessingFragment.this;
                if (p0 == null) {
                    p0 = cashierGeneralProcessingFragment.getString(R.string.SchedulerPoolFactory);
                    Intrinsics.checkNotNullExpressionValue(p0, "");
                }
                FragmentActivity activity = cashierGeneralProcessingFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierGeneralProcessingFragment.this.getContext());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getErrorConfigVersion() {
                CashierGeneralProcessingFragment.this.getAuthRequestContext(true);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void scheduleImpl() {
                CashierGeneralProcessingFragment.MyBillsEntityDataFactory(CashierGeneralProcessingFragment.this);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getAuthRequestContext() {
                CashierGeneralProcessingFragment.MyBillsEntityDataFactory(CashierGeneralProcessingFragment.this);
            }
        }));
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierGeneralProcessingFragment$cashierRiskChallengeModule$1
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierGeneralProcessingFragment$topUpAndPayModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierGeneralProcessingFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.CashierGeneralProcessingFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.CashierGeneralProcessingFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.CashierGeneralProcessingFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.CashierGeneralProcessingFragment$cashierHighlightModule$1
        }));
        CashierComponent MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        this.PlaceComponentResult = MyBillsEntityDataFactory2;
        MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[2];
        CashierContract.Presenter presenter = this.cashierPresenter;
        CashierRiskChallengePresenter cashierRiskChallengePresenter = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        CashierRiskChallengePresenter cashierRiskChallengePresenter2 = this.cashierRiskChallengePresenter;
        if (cashierRiskChallengePresenter2 != null) {
            cashierRiskChallengePresenter = cashierRiskChallengePresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        abstractPresenterArr[1] = cashierRiskChallengePresenter;
        BuiltInFictitiousFunctionClassFactory(abstractPresenterArr);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        super.FragmentBottomSheetPaymentSettingBinding();
        FragmentActivity activity = getActivity();
        String str = null;
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.setDismissAllowed(false);
        }
        CashierVariables cashierVariables = CashierVariables.INSTANCE;
        CashierVariables.lookAheadTest();
        String str2 = this.getAuthRequestContext;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            str = str2;
        }
        if (Intrinsics.areEqual(str, "MIC_FACE")) {
            getMyBillsEntityDataFactory().check();
        } else {
            B();
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierGeneralProcessingBinding) vb).BuiltInFictitiousFunctionClassFactory.playAnimation();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void whenAvailable() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            KClassImpl$Data$declaredNonStaticMembers$2((RiskParamsFactory) arguments.getParcelable("riskParamFactory"));
            String string = arguments.getString(BioUtilityBridge.SECURITY_ID);
            if (string == null) {
                string = "";
            }
            BuiltInFictitiousFunctionClassFactory(string);
            String string2 = arguments.getString("riskType");
            if (string2 == null) {
                string2 = "";
            }
            this.getAuthRequestContext = string2;
            RiskParamsFactory NetworkUserEntityData$$ExternalSyntheticLambda1 = getNetworkUserEntityData$$ExternalSyntheticLambda1();
            String str = NetworkUserEntityData$$ExternalSyntheticLambda1 != null ? NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory : null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str != null ? str : "";
            RiskParamsFactory NetworkUserEntityData$$ExternalSyntheticLambda12 = getNetworkUserEntityData$$ExternalSyntheticLambda1();
            ((BaseCashierRiskFragment) this).NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda12 != null ? NetworkUserEntityData$$ExternalSyntheticLambda12.getAuthRequestContext : null;
            RiskParamsFactory NetworkUserEntityData$$ExternalSyntheticLambda13 = getNetworkUserEntityData$$ExternalSyntheticLambda1();
            MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda13 != null ? NetworkUserEntityData$$ExternalSyntheticLambda13.lookAheadTest : null);
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void getCallingPid() {
        CashierPayMethodModel cashierPayMethodModel;
        String str;
        FragmentActivity activity = getActivity();
        if (activity == null || (cashierPayMethodModel = ((BaseCashierRiskFragment) this).NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            return;
        }
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        CashierContract.Presenter presenter = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        } else {
            str = str2;
        }
        CashierFaceAuthModel cashierFaceAuthModel = new CashierFaceAuthModel(str, cashierPayMethodModel, getIsLayoutRequested(), "MIC_FACE", null, null, null, getNetworkUserEntityData$$ExternalSyntheticLambda6(), activity, 64, null);
        CashierContract.Presenter presenter2 = this.cashierPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.BuiltInFictitiousFunctionClassFactory(cashierFaceAuthModel);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void readMicros() {
        RiskParamsFactory NetworkUserEntityData$$ExternalSyntheticLambda1 = getNetworkUserEntityData$$ExternalSyntheticLambda1();
        if (NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
            String PlaceComponentResult = NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult();
            FragmentActivity activity = getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = "";
                }
                PayActivity.handleCashierRiskPhase$default(payActivity, PlaceComponentResult, NetworkUserEntityData$$ExternalSyntheticLambda1, null, null, 12, null);
            }
            KClassImpl$Data$declaredNonStaticMembers$2((RiskParamsFactory) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/fragment/CashierGeneralProcessingFragment$Companion;", "", "", "p0", "Lid/dana/cashier/RiskParamsFactory;", "p1", "Lid/dana/cashier/fragment/CashierGeneralProcessingFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lid/dana/cashier/RiskParamsFactory;)Lid/dana/cashier/fragment/CashierGeneralProcessingFragment;", "p2", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/RiskParamsFactory;)Lid/dana/cashier/fragment/CashierGeneralProcessingFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CashierGeneralProcessingFragment BuiltInFictitiousFunctionClassFactory(String p0, String p1, RiskParamsFactory p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            CashierGeneralProcessingFragment cashierGeneralProcessingFragment = new CashierGeneralProcessingFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BioUtilityBridge.SECURITY_ID, p0);
            bundle.putString("riskType", p1);
            bundle.putParcelable("riskParamFactory", p2);
            cashierGeneralProcessingFragment.setArguments(bundle);
            return cashierGeneralProcessingFragment;
        }

        @JvmStatic
        public static CashierGeneralProcessingFragment KClassImpl$Data$declaredNonStaticMembers$2(String p0, RiskParamsFactory p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            CashierGeneralProcessingFragment cashierGeneralProcessingFragment = new CashierGeneralProcessingFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("riskParamFactory", p1);
            bundle.putString("cashierRequestId", p0);
            cashierGeneralProcessingFragment.setArguments(bundle);
            return cashierGeneralProcessingFragment;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(CashierGeneralProcessingFragment cashierGeneralProcessingFragment, AttributeCashierPayModel attributeCashierPayModel, boolean z, String str) {
        String str2;
        List<OneKlikPhonesModel> list;
        RiskVerificationMethodModel riskVerificationMethodModel;
        List<OneKlikPhonesModel> list2;
        RiskVerificationMethodModel riskVerificationMethodModel2;
        RiskVerificationMethodModel riskVerificationMethodModel3;
        RiskVerificationMethodModel riskVerificationMethodModel4;
        String str3;
        String str4;
        String str5;
        CashierPayChannelModel PlaceComponentResult;
        String format;
        String format2;
        String format3;
        if (!z) {
            String str6 = str != null ? str : "";
            FragmentActivity activity = cashierGeneralProcessingFragment.getActivity();
            if (activity != null) {
                CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, str6, 72, true, null);
            }
        } else if (attributeCashierPayModel != null) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(cashierGeneralProcessingFragment.getActivity());
            PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierGeneralProcessingFragment).BuiltInFictitiousFunctionClassFactory;
            if (payResultModel != null) {
                String str7 = attributeCashierPayModel.SubSequence;
                if (str7 == null) {
                    RiskParamsFactory NetworkUserEntityData$$ExternalSyntheticLambda1 = cashierGeneralProcessingFragment.getNetworkUserEntityData$$ExternalSyntheticLambda1();
                    str7 = NetworkUserEntityData$$ExternalSyntheticLambda1 != null ? NetworkUserEntityData$$ExternalSyntheticLambda1.scheduleImpl : null;
                    if (str7 == null) {
                        str7 = "";
                    }
                }
                Intrinsics.checkNotNullParameter(str7, "");
                payResultModel.PrepareContext = str7;
                MoneyViewModel moneyViewModel = attributeCashierPayModel.getValueOfTouchPositionAbsolute;
                if (moneyViewModel != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                    format3 = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                    if (format3 == null) {
                        format3 = "";
                    }
                    sb.append(format3);
                    str3 = sb.toString();
                } else {
                    str3 = null;
                }
                if (str3 == null) {
                    str3 = "";
                }
                Intrinsics.checkNotNullParameter(str3, "");
                payResultModel.SubSequence = str3;
                MoneyViewModel moneyViewModel2 = attributeCashierPayModel.F;
                if (moneyViewModel2 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(moneyViewModel2.KClassImpl$Data$declaredNonStaticMembers$2);
                    format2 = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel2.MyBillsEntityDataFactory());
                    if (format2 == null) {
                        format2 = "";
                    }
                    sb2.append(format2);
                    str4 = sb2.toString();
                } else {
                    str4 = null;
                }
                if (str4 == null) {
                    str4 = "";
                }
                Intrinsics.checkNotNullParameter(str4, "");
                payResultModel.BottomSheetCardBindingView$watcherCardNumberView$1 = str4;
                String str8 = attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
                if (str8 == null) {
                    str8 = "";
                }
                Intrinsics.checkNotNullParameter(str8, "");
                payResultModel.BuiltInFictitiousFunctionClassFactory = str8;
                String str9 = attributeCashierPayModel.C;
                if (str9 == null) {
                    str9 = "";
                }
                Intrinsics.checkNotNullParameter(str9, "");
                payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = str9;
                String str10 = attributeCashierPayModel.E;
                if (str10 == null) {
                    str10 = "";
                }
                payResultModel.L = str10;
                payResultModel.getAuthRequestContext = attributeCashierPayModel.getAuthRequestContext();
                payResultModel.moveToNextValue = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                MoneyViewModel moneyViewModel3 = attributeCashierPayModel.X;
                if (moneyViewModel3 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(moneyViewModel3.KClassImpl$Data$declaredNonStaticMembers$2);
                    format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel3.MyBillsEntityDataFactory());
                    if (format == null) {
                        format = "";
                    }
                    sb3.append(format);
                    str5 = sb3.toString();
                } else {
                    str5 = null;
                }
                payResultModel.KClassImpl$Data$declaredNonStaticMembers$2(str5);
                ProcessingMilestoneModel processingMilestoneModel = attributeCashierPayModel.L;
                payResultModel.getCallingPid = processingMilestoneModel != null ? processingMilestoneModel.PlaceComponentResult : null;
                String str11 = attributeCashierPayModel.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                if (str11 == null) {
                    str11 = "";
                }
                payResultModel.VerifyPinStateManager$executeRiskChallenge$2$1 = str11;
                payResultModel.getSupportButtonTintMode = attributeCashierPayModel.getOnBoardingScenario;
                payResultModel.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel.getSupportButtonTintMode;
                payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda6;
                payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = attributeCashierPayModel.A;
                Boolean bool = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
                payResultModel.newProxyInstance = bool != null ? bool.booleanValue() : false;
                Boolean bool2 = attributeCashierPayModel.VerifyPinStateManager$executeRiskChallenge$2$1;
                payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = bool2 != null ? bool2.booleanValue() : false;
                payResultModel.getOnBoardingScenario = attributeCashierPayModel.J;
                List<CashierPayChannelModel> list3 = attributeCashierPayModel.I;
                payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = (list3 == null || (PlaceComponentResult = CashierPayChannelModelKt.PlaceComponentResult(list3)) == null) ? null : PlaceComponentResult.lookAheadTest;
                payResultModel.K = attributeCashierPayModel.V;
                String BuiltInFictitiousFunctionClassFactory = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory();
                Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
                payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory;
                payResultModel.C = attributeCashierPayModel.I;
                payResultModel.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String = attributeCashierPayModel.W;
                payResultModel.whenAvailable = attributeCashierPayModel.getValueOfTouchPositionAbsolute;
                payResultModel.MyBillsEntityDataFactory = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory;
            }
            if (!attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                CashierGeneralProcessingFragment cashierGeneralProcessingFragment2 = cashierGeneralProcessingFragment;
                String str12 = attributeCashierPayModel.O;
                if (str12 == null) {
                    str12 = "";
                }
                String str13 = attributeCashierPayModel.getAuthRequestContext;
                String str14 = attributeCashierPayModel.flip;
                BaseVBCashierFragment.getAuthRequestContext(cashierGeneralProcessingFragment2, str12, null, null, str13, str14 == null ? "" : str14, CashierPayChannelModelKt.KClassImpl$Data$declaredNonStaticMembers$2(attributeCashierPayModel.I), 6);
            } else if (cashierGeneralProcessingFragment.getActivity() instanceof PayActivity) {
                String str15 = (attributeCashierPayModel == null || (riskVerificationMethodModel4 = attributeCashierPayModel.P) == null) ? null : riskVerificationMethodModel4.scheduleImpl;
                String str16 = str15 == null ? "" : str15;
                List<String> list4 = (attributeCashierPayModel == null || (riskVerificationMethodModel3 = attributeCashierPayModel.P) == null) ? null : riskVerificationMethodModel3.lookAheadTest;
                String str17 = cashierGeneralProcessingFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                if (str17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str2 = null;
                } else {
                    str2 = str17;
                }
                RiskParamsFactory riskParamsFactory = new RiskParamsFactory(attributeCashierPayModel, str2, ((BaseCashierRiskFragment) cashierGeneralProcessingFragment).NetworkUserEntityData$$ExternalSyntheticLambda0, false, null, ((BaseCashierRiskFragment) cashierGeneralProcessingFragment).BuiltInFictitiousFunctionClassFactory, null, null, null, null, null, null, null, null, list4, 16344, null);
                FragmentActivity activity2 = cashierGeneralProcessingFragment.getActivity();
                if (activity2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.pay.PayActivity");
                }
                PayActivity payActivity = (PayActivity) activity2;
                if (attributeCashierPayModel == null || (riskVerificationMethodModel2 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String) == null || (list2 = riskVerificationMethodModel2.getAuthRequestContext) == null) {
                    if (attributeCashierPayModel == null || (riskVerificationMethodModel = attributeCashierPayModel.P) == null) {
                        list = null;
                        PayActivity.handleCashierRiskPhase$default(payActivity, str16, riskParamsFactory, list, null, 8, null);
                    }
                    list2 = riskVerificationMethodModel.getAuthRequestContext;
                }
                list = list2;
                PayActivity.handleCashierRiskPhase$default(payActivity, str16, riskParamsFactory, list, null, 8, null);
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierGeneralProcessingFragment cashierGeneralProcessingFragment) {
        cashierGeneralProcessingFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        cashierGeneralProcessingFragment.getSupportButtonTintMode();
        cashierGeneralProcessingFragment.getAuthRequestContext(false);
    }

    public final void B() {
        CashierContract.Presenter presenter;
        String str;
        CashierContract.Presenter presenter2;
        if (((String) this.MyBillsEntityDataFactory.getValue()).length() > 0) {
            CashierContract.Presenter presenter3 = this.cashierPresenter;
            if (presenter3 != null) {
                presenter2 = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter2 = null;
            }
            presenter2.KClassImpl$Data$declaredNonStaticMembers$2(null, null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : (String) this.MyBillsEntityDataFactory.getValue());
            return;
        }
        CashierContract.Presenter presenter4 = this.cashierPresenter;
        if (presenter4 != null) {
            presenter = presenter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        } else {
            str = str2;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2(str, null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void getAuthRequestContext(String p0, String p1, String p2, String p3, String p4, boolean p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        PayResultModel payResultModel = ((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel != null) {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            Intrinsics.checkNotNullParameter(str, "");
            payResultModel.getErrorConfigVersion = str;
            Intrinsics.checkNotNullParameter(p3, "");
            payResultModel.PlaceComponentResult = p3;
            Intrinsics.checkNotNullParameter(p4, "");
            payResultModel.J = p4;
            payResultModel.getValueOfTouchPositionAbsolute = p0;
            payResultModel.GetContactSyncConfig = p1;
            payResultModel.scheduleImpl = p2;
            FragmentActivity activity = getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                PaymentResultFragment.Companion companion = PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                payActivity.addFragment(PaymentResultFragment.Companion.BuiltInFictitiousFunctionClassFactory(payResultModel, p5));
            }
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.initRecordTimeStamp.clear();
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void getAuthRequestContext(boolean p0) {
        CashierAnalyticTracker cashierAnalyticTracker = this.cashierAnalyticTracker;
        String str = null;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            str = str2;
        }
        CashierAnalyticTracker.CC.BuiltInFictitiousFunctionClassFactory(cashierAnalyticTracker, str, TrackerKey.CashierRiskType.FACE_VERIFICATION_CASHIER, Boolean.valueOf(p0), 4);
    }
}
