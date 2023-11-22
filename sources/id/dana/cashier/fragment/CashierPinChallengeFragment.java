package id.dana.cashier.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import com.jakewharton.rxbinding2.widget.RxTextView;
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
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.helper.CashierErrorType;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.TopUpPayModel;
import id.dana.cashier.model.TopUpVerifyRequestModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.danah5.DanaH5;
import id.dana.databinding.FragmentCashierPinChallengeBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.CashierComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.extension.view.InputExtKt;
import id.dana.pay.PayActivity;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import id.dana.utils.danah5.DanaH5Listener;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b>\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0012\u0010 \u001a\u00020\u001fX\u0087\"¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u0012\u001a\u00020\"8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b%\u0010&R\u0012\u0010)\u001a\u00020(X\u0087\"¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010&R*\u00101\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8\u0015@UX\u0095\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b-\u00103R\u0018\u00105\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u0010&R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0018\u00109R\u0012\u0010<\u001a\u00020;X\u0087\"¢\u0006\u0006\n\u0004\b<\u0010="}, d2 = {"Lid/dana/cashier/fragment/CashierPinChallengeFragment;", "Lid/dana/cashier/fragment/BaseCashierRiskFragment;", "Lid/dana/databinding/FragmentCashierPinChallengeBinding;", "Lid/dana/cashier/helper/CashierErrorState;", "p0", "", "PlaceComponentResult", "(Lid/dana/cashier/helper/CashierErrorState;)V", "", "p1", "p2", "p3", "p4", "", "p5", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Lid/dana/cashier/model/AttributeCashierPayModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/AttributeCashierPayModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda6", "()V", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "whenAvailable", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/domain/useragreement/model/AgreementInfo;", "GetContactSyncConfig", "Lid/dana/domain/useragreement/model/AgreementInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/cashier/model/AttributeCashierPayModel;", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "cashierAnalyticTracker", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "Lid/dana/di/component/CashierComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/di/component/CashierComponent;", "isLayoutRequested", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/cashier/CashierContract$Presenter;", "cashierPresenter", "Lid/dana/cashier/CashierContract$Presenter;", "", "Ljava/lang/Integer;", "KClassImpl$Data$declaredNonStaticMembers$2", "scheduleImpl", "FragmentBottomSheetPaymentSettingBinding", "Z", "moveToNextValue", "()Z", "(Z)V", "Ljava/lang/Boolean;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda5", "lookAheadTest", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "getErrorConfigVersion", "Lid/dana/cashier/TopUpAndPayContract$Presenter;", "topUpAndPayPresenter", "Lid/dana/cashier/TopUpAndPayContract$Presenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPinChallengeFragment extends BaseCashierRiskFragment<FragmentCashierPinChallengeBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private AgreementInfo PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private AttributeCashierPayModel getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private Integer KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private CashierComponent BuiltInFictitiousFunctionClassFactory;
    @Inject
    public CashierAnalyticTracker cashierAnalyticTracker;
    @Inject
    public CashierContract.Presenter cashierPresenter;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;
    @Inject
    public TopUpAndPayContract.Presenter topUpAndPayPresenter;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private CashierPayMethodModel getErrorConfigVersion;
    public Map<Integer, View> initRecordTimeStamp = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private Boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = Boolean.FALSE;

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
        FragmentCashierPinChallengeBinding MyBillsEntityDataFactory = FragmentCashierPinChallengeBinding.MyBillsEntityDataFactory(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment
    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    protected final boolean getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.moveToNextValue = z;
        if (getMoveToNextValue()) {
            FragmentActivity activity = getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                payActivity.expandBottomSheet();
            }
            if (((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory != null) {
                NetworkUserEntityData$$ExternalSyntheticLambda0();
                VB vb = this.PlaceComponentResult;
                if (vb != 0) {
                    Group group = ((FragmentCashierPinChallengeBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(group, "");
                    group.setVisibility(0);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierPinChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierPinChallengeFragment.this, p0.KClassImpl$Data$declaredNonStaticMembers$2, Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE), p0.PlaceComponentResult, p0.getAuthRequestContext);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierPinChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierPinChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                CashierPinChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierPinChallengeFragment.this, true);
                CashierPinChallengeFragment.this.SubSequence();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierPinChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierPinChallengeFragment.this, false);
                CashierPinChallengeFragment.this.GetContactSyncConfig();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                CashierPinChallengeFragment cashierPinChallengeFragment = CashierPinChallengeFragment.this;
                if (p0 == null) {
                    p0 = "";
                }
                FragmentActivity activity = cashierPinChallengeFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
                VB vb = CashierPinChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    PinEntryEditText pinEntryEditText = ((FragmentCashierPinChallengeBinding) vb).PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                    InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
                    CashierPinChallengeFragment.this.VerifyPinStateManager$executeRiskChallenge$2$1();
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.CashierRiskChallengeContract.View
            public final void MyBillsEntityDataFactory(String p0, String p1, Throwable p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                CashierPinChallengeFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayModel p0) {
                CashierContract.Presenter presenter;
                Intrinsics.checkNotNullParameter(p0, "");
                if (!Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE)) {
                    CashierPinChallengeFragment.MyBillsEntityDataFactory(CashierPinChallengeFragment.this, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.PlaceComponentResult, p0.getAuthRequestContext);
                    return;
                }
                PayResultModel payResultModel = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                if (payResultModel != null) {
                    AttributeCashierPayModel attributeCashierPayModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    String str = attributeCashierPayModel != null ? attributeCashierPayModel.T : null;
                    if (str == null) {
                        str = "";
                    }
                    payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String = str;
                }
                PayResultModel payResultModel2 = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                if (payResultModel2 != null) {
                    payResultModel2.I = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).NetworkUserEntityData$$ExternalSyntheticLambda0;
                }
                PayResultModel payResultModel3 = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                if (payResultModel3 != null) {
                    AttributeCashierPayModel attributeCashierPayModel2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    payResultModel3.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel2 != null ? attributeCashierPayModel2.SummaryVoucherView$$ExternalSyntheticLambda0 : null;
                }
                PayResultModel payResultModel4 = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                if (payResultModel4 != null) {
                    AttributeCashierPayModel attributeCashierPayModel3 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    payResultModel4.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel3 != null ? attributeCashierPayModel3.getSupportButtonTintMode : null;
                }
                CashierContract.Presenter presenter2 = CashierPinChallengeFragment.this.cashierPresenter;
                if (presenter2 != null) {
                    presenter = presenter2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                String str2 = p0.MyBillsEntityDataFactory;
                presenter.KClassImpl$Data$declaredNonStaticMembers$2(str2 == null ? "" : str2, null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
            }
        }));
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$cashierRiskChallengeModule$1
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$topUpAndPayModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierPinChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierPinChallengeFragment.this, p0.KClassImpl$Data$declaredNonStaticMembers$2, Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE), p0.PlaceComponentResult, p0.getAuthRequestContext);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                CashierPinChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierPinChallengeFragment.this, true);
                CashierPinChallengeFragment.this.SubSequence();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierPinChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierPinChallengeFragment.this, false);
                CashierPinChallengeFragment.this.GetContactSyncConfig();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void lookAheadTest(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierPinChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierPinChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                CashierPinChallengeFragment cashierPinChallengeFragment = CashierPinChallengeFragment.this;
                if (p0 == null) {
                    p0 = "";
                }
                FragmentActivity activity = cashierPinChallengeFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
                VB vb = CashierPinChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    PinEntryEditText pinEntryEditText = ((FragmentCashierPinChallengeBinding) vb).PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                    InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
                    CashierPinChallengeFragment.this.VerifyPinStateManager$executeRiskChallenge$2$1();
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierPinChallengeFragment.this.getContext());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(TopUpPayModel p0) {
                String str;
                Boolean bool;
                Intrinsics.checkNotNullParameter(p0, "");
                if (!Intrinsics.areEqual(p0.lookAheadTest, Boolean.TRUE)) {
                    CashierPinChallengeFragment.MyBillsEntityDataFactory(CashierPinChallengeFragment.this, p0.BuiltInFictitiousFunctionClassFactory, p0.MyBillsEntityDataFactory, p0.KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                PayResultModel payResultModel = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                if (payResultModel != null) {
                    AttributeCashierPayModel attributeCashierPayModel = p0.BuiltInFictitiousFunctionClassFactory;
                    String str2 = attributeCashierPayModel != null ? attributeCashierPayModel.T : null;
                    if (str2 == null) {
                        str2 = "";
                    }
                    payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String = str2;
                }
                PayResultModel payResultModel2 = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                if (payResultModel2 != null) {
                    AttributeCashierPayModel attributeCashierPayModel2 = p0.BuiltInFictitiousFunctionClassFactory;
                    if (attributeCashierPayModel2 == null || (bool = attributeCashierPayModel2.NetworkUserEntityData$$ExternalSyntheticLambda8) == null) {
                        bool = Boolean.FALSE;
                    }
                    payResultModel2.isLayoutRequested = bool;
                }
                PayResultModel payResultModel3 = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                if (payResultModel3 != null) {
                    AttributeCashierPayModel attributeCashierPayModel3 = p0.BuiltInFictitiousFunctionClassFactory;
                    payResultModel3.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel3 != null ? attributeCashierPayModel3.SummaryVoucherView$$ExternalSyntheticLambda0 : null;
                }
                PayResultModel payResultModel4 = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).BuiltInFictitiousFunctionClassFactory;
                if (payResultModel4 != null) {
                    AttributeCashierPayModel attributeCashierPayModel4 = p0.BuiltInFictitiousFunctionClassFactory;
                    payResultModel4.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel4 != null ? attributeCashierPayModel4.getSupportButtonTintMode : null;
                }
                TopUpAndPayContract.Presenter presenter = CashierPinChallengeFragment.this.topUpAndPayPresenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                str = CashierPinChallengeFragment.this.MyBillsEntityDataFactory;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    str = null;
                }
                String str3 = p0.getAuthRequestContext;
                presenter.PlaceComponentResult(str, str3 != null ? str3 : "", null, CashierPinChallengeFragment.this.getErrorConfigVersion);
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$cashierHighlightModule$1
        }));
        CashierComponent MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory2;
        MyBillsEntityDataFactory2.PlaceComponentResult(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[2];
        CashierContract.Presenter presenter = this.cashierPresenter;
        TopUpAndPayContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        TopUpAndPayContract.Presenter presenter3 = this.topUpAndPayPresenter;
        if (presenter3 != null) {
            presenter2 = presenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        abstractPresenterArr[1] = presenter2;
        BuiltInFictitiousFunctionClassFactory(abstractPresenterArr);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void whenAvailable() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(CashierKeyParams.CASHIER_ORDER_ID);
            if (string == null) {
                string = "";
            }
            this.MyBillsEntityDataFactory = string;
            AttributeCashierPayModel attributeCashierPayModel = (AttributeCashierPayModel) arguments.getParcelable(CashierKeyParams.ATTRIBUTE_CASHIER_PAY);
            this.getAuthRequestContext = attributeCashierPayModel;
            String str = attributeCashierPayModel != null ? attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (str == null) {
                str = "";
            }
            Intrinsics.checkNotNullParameter(str, "");
            this.getErrorConfigVersion = str;
            ((BaseCashierRiskFragment) this).NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierPayMethodModel) arguments.getParcelable(CashierKeyParams.CASHIER_PAY_METHOD);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Boolean.valueOf(arguments.getBoolean(CashierKeyParams.RISK_PHASE_2, false));
            MyBillsEntityDataFactory((PayResultModel) arguments.getParcelable(CashierKeyParams.PAY_RESULT_MODEL));
            KClassImpl$Data$declaredNonStaticMembers$2(arguments.getBoolean(CashierKeyParams.IS_BINDING_PAY, false));
            MyBillsEntityDataFactory((VoucherCashierModel) arguments.getParcelable(CashierKeyParams.VOUCHER_PROMO));
            String[] stringArray = arguments.getStringArray(CashierKeyParams.CASHIER_ORDER_GOODS);
            BuiltInFictitiousFunctionClassFactory(stringArray != null ? ArraysKt.toList(stringArray) : null);
            MyBillsEntityDataFactory((TopUpVerifyRequestModel) arguments.getParcelable(CashierKeyParams.TOP_UP_VERIFY_REQUEST_MODEL));
            BuiltInFictitiousFunctionClassFactory(((BaseCashierRiskFragment) this).moveToNextValue != null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.valueOf(arguments.getInt(CashierKeyParams.INSTALLMENT_PERIOD));
            this.PlaceComponentResult = (AgreementInfo) arguments.getParcelable(CashierKeyParams.AGREEMENT_INFO);
            this.scheduleImpl = arguments.getString(CashierKeyParams.INSTALLMENT_PLAN_ID);
            this.lookAheadTest = arguments.getString(CashierKeyParams.LOAN_AGREEMENT_URL);
            CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) arguments.getParcelable(CashierKeyParams.BALANCE_MIX_PAY_MODEL);
            if (cashierPayMethodModel != null) {
                Intrinsics.checkNotNullExpressionValue(cashierPayMethodModel, "");
                this.getErrorConfigVersion = cashierPayMethodModel;
            }
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.setCashierRiskListener(new PayActivity.CashierRiskListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$initCashierListener$1
                @Override // id.dana.pay.PayActivity.CashierRiskListener
                public final void MyBillsEntityDataFactory(String p0) {
                    CashierContract.Presenter presenter;
                    String str;
                    String str2;
                    String str3;
                    CashierPinChallengeFragment.this.SubSequence();
                    if (CashierPinChallengeFragment.this.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                        TopUpAndPayContract.Presenter presenter2 = CashierPinChallengeFragment.this.topUpAndPayPresenter;
                        if (presenter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            presenter2 = null;
                        }
                        str3 = CashierPinChallengeFragment.this.MyBillsEntityDataFactory;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            str3 = null;
                        }
                        TopUpVerifyRequestModel topUpVerifyRequestModel = ((BaseCashierRiskFragment) CashierPinChallengeFragment.this).moveToNextValue;
                        String str4 = topUpVerifyRequestModel != null ? topUpVerifyRequestModel.getAuthRequestContext : null;
                        presenter2.PlaceComponentResult(str3, str4 != null ? str4 : "", p0, CashierPinChallengeFragment.this.getErrorConfigVersion);
                        return;
                    }
                    CashierContract.Presenter presenter3 = CashierPinChallengeFragment.this.cashierPresenter;
                    if (presenter3 != null) {
                        presenter = presenter3;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    str = CashierPinChallengeFragment.this.MyBillsEntityDataFactory;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        str2 = null;
                    } else {
                        str2 = str;
                    }
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(str2, p0, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
                }
            });
        }
    }

    public final void VerifyPinStateManager$executeRiskChallenge$2$1() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            PinEntryEditText pinEntryEditText = ((FragmentCashierPinChallengeBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(requireContext, pinEntryEditText);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final boolean getAuthRequestContext(CashierPinChallengeFragment cashierPinChallengeFragment, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(cashierPinChallengeFragment, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        int length = charSequence.length();
        VB vb = cashierPinChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            return length == ((FragmentCashierPinChallengeBinding) vb).PlaceComponentResult.getMaxLength();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/fragment/CashierPinChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/cashier/fragment/CashierPinChallengeFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/os/Bundle;)Lid/dana/cashier/fragment/CashierPinChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CashierPinChallengeFragment KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            CashierPinChallengeFragment cashierPinChallengeFragment = new CashierPinChallengeFragment();
            cashierPinChallengeFragment.setArguments(p0);
            return cashierPinChallengeFragment;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x004a, code lost:
    
        if (r3 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0076, code lost:
    
        if (r3 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0079, code lost:
    
        r6 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void PlaceComponentResult(id.dana.cashier.fragment.CashierPinChallengeFragment r19, java.lang.CharSequence r20) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierPinChallengeFragment.PlaceComponentResult(id.dana.cashier.fragment.CashierPinChallengeFragment, java.lang.CharSequence):void");
    }

    public static /* synthetic */ void getAuthRequestContext(CashierPinChallengeFragment cashierPinChallengeFragment) {
        Intrinsics.checkNotNullParameter(cashierPinChallengeFragment, "");
        DanaH5.startContainerFullUrl("https://m.dana.id/m/portal/security/resetPin?mode=reset", new DanaH5Listener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$onClickForgotPassword$1$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(CashierPinChallengeFragment.this.getActivity());
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierPinChallengeFragment cashierPinChallengeFragment) {
        FragmentActivity activity;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(cashierPinChallengeFragment, "");
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(cashierPinChallengeFragment.getActivity());
        if (!cashierPinChallengeFragment.isVisible() || (activity = cashierPinChallengeFragment.getActivity()) == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.popBackStack();
    }

    /* JADX WARN: Code restructure failed: missing block: B:350:0x012c, code lost:
    
        if (r2 == null) goto L351;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.CashierPinChallengeFragment r24, id.dana.cashier.model.AttributeCashierPayModel r25, boolean r26, java.lang.String r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 815
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierPinChallengeFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.CashierPinChallengeFragment, id.dana.cashier.model.AttributeCashierPayModel, boolean, java.lang.String, java.lang.String):void");
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierPinChallengeFragment cashierPinChallengeFragment, AttributeCashierPayModel attributeCashierPayModel, String str, String str2) {
        if (Intrinsics.areEqual(str, "AE15002058020050")) {
            cashierPinChallengeFragment.BuiltInFictitiousFunctionClassFactory(attributeCashierPayModel);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        FragmentActivity activity = cashierPinChallengeFragment.getActivity();
        if (activity != null) {
            CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, str2, 72, true, null);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierPinChallengeFragment cashierPinChallengeFragment, boolean z) {
        if (z) {
            VB vb = cashierPinChallengeFragment.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentCashierPinChallengeBinding) vb).lookAheadTest.setEnabled(false);
                VB vb2 = cashierPinChallengeFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    ((FragmentCashierPinChallengeBinding) vb2).moveToNextValue.setEnabled(false);
                    VB vb3 = cashierPinChallengeFragment.PlaceComponentResult;
                    if (vb3 != 0) {
                        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(((FragmentCashierPinChallengeBinding) vb3).lookAheadTest, (int) R.style.f54182132017914);
                        VB vb4 = cashierPinChallengeFragment.PlaceComponentResult;
                        if (vb4 != 0) {
                            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(((FragmentCashierPinChallengeBinding) vb4).moveToNextValue, (int) R.style.f54182132017914);
                            VB vb5 = cashierPinChallengeFragment.PlaceComponentResult;
                            if (vb5 != 0) {
                                ((FragmentCashierPinChallengeBinding) vb5).getErrorConfigVersion.setVisibility(8);
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
        VB vb6 = cashierPinChallengeFragment.PlaceComponentResult;
        if (vb6 != 0) {
            ((FragmentCashierPinChallengeBinding) vb6).lookAheadTest.setEnabled(true);
            VB vb7 = cashierPinChallengeFragment.PlaceComponentResult;
            if (vb7 != 0) {
                ((FragmentCashierPinChallengeBinding) vb7).moveToNextValue.setEnabled(true);
                VB vb8 = cashierPinChallengeFragment.PlaceComponentResult;
                if (vb8 != 0) {
                    TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(((FragmentCashierPinChallengeBinding) vb8).lookAheadTest, (int) R.style.f54152132017911);
                    VB vb9 = cashierPinChallengeFragment.PlaceComponentResult;
                    if (vb9 != 0) {
                        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(((FragmentCashierPinChallengeBinding) vb9).moveToNextValue, (int) R.style.f54152132017911);
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

    /* JADX WARN: Removed duplicated region for block: B:56:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(id.dana.cashier.model.AttributeCashierPayModel r5) {
        /*
            r4 = this;
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            boolean r1 = r0 instanceof id.dana.pay.PayActivity
            r2 = 0
            if (r1 == 0) goto Lc
            id.dana.pay.PayActivity r0 = (id.dana.pay.PayActivity) r0
            goto Ld
        Lc:
            r0 = r2
        Ld:
            if (r0 == 0) goto L12
            r0.expandBottomSheet()
        L12:
            r0 = 0
            if (r5 == 0) goto L33
            java.lang.Integer r1 = r5.readMicros
            if (r1 == 0) goto L2c
            int r1 = r1.intValue()
            java.lang.Integer r5 = r5.NetworkUserEntityData$$ExternalSyntheticLambda1
            if (r5 == 0) goto L26
            int r5 = r5.intValue()
            goto L27
        L26:
            r5 = 0
        L27:
            int r1 = r1 - r5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
        L2c:
            if (r2 == 0) goto L33
            int r5 = r2.intValue()
            goto L34
        L33:
            r5 = 0
        L34:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1[r0] = r5
            r5 = 2131954470(0x7f130b26, float:1.954544E38)
            java.lang.String r5 = r4.getString(r5, r1)
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            VB extends androidx.viewbinding.ViewBinding r2 = r4.PlaceComponentResult
            java.lang.String r3 = "Required value was null."
            if (r2 == 0) goto L8b
            id.dana.databinding.FragmentCashierPinChallengeBinding r2 = (id.dana.databinding.FragmentCashierPinChallengeBinding) r2
            androidx.appcompat.widget.AppCompatTextView r2 = r2.getErrorConfigVersion
            r2.setVisibility(r0)
            VB extends androidx.viewbinding.ViewBinding r0 = r4.PlaceComponentResult
            if (r0 == 0) goto L81
            id.dana.databinding.FragmentCashierPinChallengeBinding r0 = (id.dana.databinding.FragmentCashierPinChallengeBinding) r0
            androidx.appcompat.widget.AppCompatTextView r0 = r0.getErrorConfigVersion
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            VB extends androidx.viewbinding.ViewBinding r5 = r4.PlaceComponentResult
            if (r5 == 0) goto L77
            id.dana.databinding.FragmentCashierPinChallengeBinding r5 = (id.dana.databinding.FragmentCashierPinChallengeBinding) r5
            id.dana.core.ui.richview.PinEntryEditText r5 = r5.PlaceComponentResult
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            android.widget.TextView r5 = (android.widget.TextView) r5
            id.dana.extension.view.InputExtKt.MyBillsEntityDataFactory(r5)
            r4.VerifyPinStateManager$executeRiskChallenge$2$1()
            return
        L77:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r3.toString()
            r5.<init>(r0)
            throw r5
        L81:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r3.toString()
            r5.<init>(r0)
            throw r5
        L8b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r3.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierPinChallengeFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.model.AttributeCashierPayModel):void");
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    public final void PlaceComponentResult(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.MyBillsEntityDataFactory;
        int hashCode = str.hashCode();
        if (hashCode == -2080396080) {
            if (str.equals(CashierErrorType.RETRYABLE_RISK_CHALLENGE)) {
                String asString = p0.getAuthRequestContext.asString(getContext());
                VB vb = this.PlaceComponentResult;
                if (vb != 0) {
                    AppCompatTextView appCompatTextView = ((FragmentCashierPinChallengeBinding) vb).getErrorConfigVersion;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                    appCompatTextView.setVisibility(0);
                    appCompatTextView.setText(asString);
                    DatabaseTableConfigUtil();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            BaseVBCashierFragment.getAuthRequestContext(this, "fail", p0.getAuthRequestContext.asString(getContext()), p0.KClassImpl$Data$declaredNonStaticMembers$2, null, null, false, 56);
        } else if (hashCode == -1464512787) {
            if (str.equals(CashierErrorType.ACCOUNT_ON_HOLD)) {
                BuiltInFictitiousFunctionClassFactory(p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.getAuthRequestContext.asString(getContext()));
            }
            BaseVBCashierFragment.getAuthRequestContext(this, "fail", p0.getAuthRequestContext.asString(getContext()), p0.KClassImpl$Data$declaredNonStaticMembers$2, null, null, false, 56);
        } else {
            if (hashCode == 646849033 && str.equals("SYSTEM_BUSY")) {
                String asString2 = p0.getAuthRequestContext.asString(getContext());
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, asString2, 72, true, null);
                }
            }
            BaseVBCashierFragment.getAuthRequestContext(this, "fail", p0.getAuthRequestContext.asString(getContext()), p0.KClassImpl$Data$declaredNonStaticMembers$2, null, null, false, 56);
        }
        VB vb2 = this.PlaceComponentResult;
        if (vb2 != 0) {
            PinEntryEditText pinEntryEditText = ((FragmentCashierPinChallengeBinding) vb2).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
            InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void getAuthRequestContext(String p0, String p1, String p2, String p3, String p4, boolean p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        PayResultModel payResultModel = ((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel != null) {
            String str = this.MyBillsEntityDataFactory;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            Intrinsics.checkNotNullParameter(str, "");
            payResultModel.getErrorConfigVersion = str;
            payResultModel.getValueOfTouchPositionAbsolute = p0;
            payResultModel.GetContactSyncConfig = p1;
            payResultModel.scheduleImpl = p2;
            Intrinsics.checkNotNullParameter(p3, "");
            payResultModel.PlaceComponentResult = p3;
            Intrinsics.checkNotNullParameter(p4, "");
            payResultModel.J = p4;
            payResultModel.G = BuiltInFictitiousFunctionClassFactory();
            FragmentActivity activity = getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                PaymentResultFragment.Companion companion = PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                payActivity.addFragment(PaymentResultFragment.Companion.BuiltInFictitiousFunctionClassFactory(payResultModel, p5));
            }
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        Window window;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierPinChallengeBinding) vb).lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierPinChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierPinChallengeFragment.this);
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCashierPinChallengeBinding) vb2).moveToNextValue.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CashierPinChallengeFragment.getAuthRequestContext(CashierPinChallengeFragment.this);
                    }
                });
                FragmentActivity activity = getActivity();
                KeyboardHelper.PlaceComponentResult((activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$setupKeyboardListener$1
                    @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                        FragmentActivity activity2 = CashierPinChallengeFragment.this.getActivity();
                        PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
                        if (payActivity != null) {
                            payActivity.expandBottomSheet();
                        }
                    }

                    @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                    public final void MyBillsEntityDataFactory() {
                        FragmentActivity activity2 = CashierPinChallengeFragment.this.getActivity();
                        PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
                        if (payActivity != null) {
                            payActivity.setHalfScreenBottomSheet();
                        }
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    PlaceComponentResult(RxTextView.textChanges(((FragmentCashierPinChallengeBinding) vb3).PlaceComponentResult).filter(new Predicate() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$$ExternalSyntheticLambda2
                        @Override // io.reactivex.functions.Predicate
                        public final boolean test(Object obj) {
                            boolean authRequestContext;
                            authRequestContext = CashierPinChallengeFragment.getAuthRequestContext(CashierPinChallengeFragment.this, (CharSequence) obj);
                            return authRequestContext;
                        }
                    }).subscribe(new Consumer() { // from class: id.dana.cashier.fragment.CashierPinChallengeFragment$$ExternalSyntheticLambda3
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            CashierPinChallengeFragment.PlaceComponentResult(CashierPinChallengeFragment.this, (CharSequence) obj);
                        }
                    }));
                    VerifyPinStateManager$executeRiskChallenge$2$1();
                    DatabaseTableConfigUtil();
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.initRecordTimeStamp.clear();
    }
}
