package id.dana.cashier.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.BaseActivity;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierPaylaterTnCActivity;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.OnlineCreditType;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierFaceAuthModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayChannelModelKt;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.ConsultAgreementModel;
import id.dana.cashier.model.ExtendCashierModel;
import id.dana.cashier.model.OneKlikPhonesModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.PaylaterCashierRequestCheckoutModel;
import id.dana.cashier.model.ProcessingMilestoneModel;
import id.dana.cashier.model.QueryInstallmentModel;
import id.dana.cashier.model.RepaymentPlanModel;
import id.dana.cashier.model.RiskVerificationMethodModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.cashier.model.tracker.PaymentExecutionTrackerParams;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.tracker.PaylaterAnalyticTracker;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.view.PaylaterInstallmentView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.CashierComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.model.CurrencyAmountModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.utils.LocationUtil;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\bE\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\b\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\b\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001d\u001a\u00020\u001cX\u0087\"¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\r\u001a\u00020\u001f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\b\u0010 R\u0016\u0010\u000e\u001a\u00020!8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0012\u0010$\u001a\u00020#X\u0087\"¢\u0006\u0006\n\u0004\b$\u0010%R\u0012\u0010'\u001a\u00020&X\u0087\"¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0003\u001a\u0004\u0018\u00010!8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\"R\u0018\u0010\u001a\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u000f\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u0010\u0013\u001a\u0004\u0018\u0001028\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u0017\u001a\u0004\u0018\u0001058\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b6\u00107R\u0012\u00109\u001a\u000208X\u0087\"¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\u0016\u001a\u0004\u0018\u00010;8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b<\u0010=R*\u0010.\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010>j\n\u0012\u0004\u0012\u00020!\u0018\u0001`?8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010*\u001a\u0004\u0018\u00010B8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\bC\u0010D"}, d2 = {"Lid/dana/cashier/fragment/PaylaterInstallmentFragment;", "Lid/dana/cashier/fragment/BaseCashierFragment;", "", "getAuthRequestContext", "()V", "getCallingPid", "Lid/dana/cashier/helper/CashierErrorState;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/helper/CashierErrorState;)V", "", "getLayout", "()I", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "getErrorConfigVersion", "", "C", "()Z", "lookAheadTest", "Lid/dana/cashier/RiskParamsFactory;", "(Lid/dana/cashier/RiskParamsFactory;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "Lid/dana/cashier/model/CashierPayMethodModel;", "(Lid/dana/cashier/model/CashierPayMethodModel;)V", "MyBillsEntityDataFactory", "(Z)V", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "cashierAnalyticTracker", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "Lid/dana/di/component/CashierComponent;", "Lid/dana/di/component/CashierComponent;", "", "Ljava/lang/String;", "Lid/dana/cashier/CashierContract$Presenter;", "cashierPresenter", "Lid/dana/cashier/CashierContract$Presenter;", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "cashierRiskChallengePresenter", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "GetContactSyncConfig", "Ljava/lang/Integer;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Z", "scheduleImpl", "initRecordTimeStamp", "Lid/dana/cashier/model/CashierPayMethodModel$PaylaterPayMethod;", "DatabaseTableConfigUtil", "Lid/dana/cashier/model/CashierPayMethodModel$PaylaterPayMethod;", "Lid/dana/cashier/model/PayResultModel;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/cashier/model/PayResultModel;", "Lid/dana/cashier/tracker/PaylaterAnalyticTracker;", "paylaterAnalyticTracker", "Lid/dana/cashier/tracker/PaylaterAnalyticTracker;", "Lid/dana/cashier/model/QueryInstallmentModel;", "PrepareContext", "Lid/dana/cashier/model/QueryInstallmentModel;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/util/ArrayList;", "Lid/dana/model/CurrencyAmountModel;", "newProxyInstance", "Lid/dana/model/CurrencyAmountModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterInstallmentFragment extends BaseCashierFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private CashierPayMethodModel.PaylaterPayMethod lookAheadTest;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Integer KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private CashierComponent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private CheckoutExternalInfo MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private ArrayList<String> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private PayResultModel moveToNextValue;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private QueryInstallmentModel NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public CashierAnalyticTracker cashierAnalyticTracker;
    @Inject
    public CashierContract.Presenter cashierPresenter;
    @Inject
    public CashierRiskChallengePresenter cashierRiskChallengePresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private CurrencyAmountModel NetworkUserEntityData$$ExternalSyntheticLambda1;
    @Inject
    public PaylaterAnalyticTracker paylaterAnalyticTracker;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String getAuthRequestContext = "";

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final View BuiltInFictitiousFunctionClassFactory(int i) {
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

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_paylater_installment;
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void getAuthRequestContext() {
        String string = getString(R.string.choose_installment_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        getAuthRequestContext(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0060, code lost:
    
        if (((r4 == null || (r4 = r4.PlaceComponentResult) == null || !r4.getMyBillsEntityDataFactory()) ? false : true) != false) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010a  */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getErrorConfigVersion() {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.PaylaterInstallmentFragment.getErrorConfigVersion():void");
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void PlaceComponentResult() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayModel p0) {
                PayResultModel payResultModel;
                PayResultModel payResultModel2;
                PayResultModel payResultModel3;
                CashierContract.Presenter presenter;
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                payResultModel = PaylaterInstallmentFragment.this.moveToNextValue;
                if (payResultModel != null) {
                    AttributeCashierPayModel attributeCashierPayModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    String str2 = attributeCashierPayModel != null ? attributeCashierPayModel.T : null;
                    if (str2 == null) {
                        str2 = "";
                    }
                    payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.MB java.lang.String = str2;
                }
                payResultModel2 = PaylaterInstallmentFragment.this.moveToNextValue;
                if (payResultModel2 != null) {
                    AttributeCashierPayModel attributeCashierPayModel2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    payResultModel2.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel2 != null ? attributeCashierPayModel2.SummaryVoucherView$$ExternalSyntheticLambda0 : null;
                }
                payResultModel3 = PaylaterInstallmentFragment.this.moveToNextValue;
                if (payResultModel3 != null) {
                    AttributeCashierPayModel attributeCashierPayModel3 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    payResultModel3.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel3 != null ? attributeCashierPayModel3.getSupportButtonTintMode : null;
                }
                AttributeCashierPayModel attributeCashierPayModel4 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                if (attributeCashierPayModel4 != null) {
                    PaylaterInstallmentFragment paylaterInstallmentFragment = PaylaterInstallmentFragment.this;
                    if (attributeCashierPayModel4.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        PaylaterInstallmentFragment.KClassImpl$Data$declaredNonStaticMembers$2(paylaterInstallmentFragment, attributeCashierPayModel4);
                        return;
                    }
                    CashierContract.Presenter presenter2 = paylaterInstallmentFragment.cashierPresenter;
                    if (presenter2 != null) {
                        presenter = presenter2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    str = paylaterInstallmentFragment.PlaceComponentResult;
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(str, null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
                }
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                PaylaterInstallmentFragment.this.readMicros();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                PaylaterInstallmentFragment.this.scheduleImpl();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PaylaterInstallmentFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PaylaterInstallmentFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getErrorConfigVersion() {
                PaylaterInstallmentFragment.this.MyBillsEntityDataFactory(true);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void scheduleImpl() {
                PaylaterInstallmentFragment.this.getErrorConfigVersion = true;
                PaylaterInstallmentFragment.this.MyBillsEntityDataFactory(false);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getAuthRequestContext() {
                PaylaterInstallmentFragment.this.MyBillsEntityDataFactory(false);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                PaylaterInstallmentFragment paylaterInstallmentFragment = PaylaterInstallmentFragment.this;
                if (p0 == null) {
                    p0 = "";
                }
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(paylaterInstallmentFragment, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(PaylaterInstallmentFragment.this.getContext());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                PayResultModel payResultModel;
                String str;
                String str2;
                ArrayList arrayList;
                CashierPayChannelModel cashierPayChannelModel;
                ExtendCashierModel extendCashierModel;
                String format;
                String format2;
                Intrinsics.checkNotNullParameter(p0, "");
                AttributeCashierPayModel attributeCashierPayModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                if (attributeCashierPayModel != null) {
                    PaylaterInstallmentFragment paylaterInstallmentFragment = PaylaterInstallmentFragment.this;
                    if (!attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        payResultModel = paylaterInstallmentFragment.moveToNextValue;
                        if (payResultModel != null) {
                            String str3 = attributeCashierPayModel.SubSequence;
                            if (str3 == null) {
                                str3 = "";
                            }
                            Intrinsics.checkNotNullParameter(str3, "");
                            payResultModel.PrepareContext = str3;
                            MoneyViewModel moneyViewModel = attributeCashierPayModel.getValueOfTouchPositionAbsolute;
                            if (moneyViewModel != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                                format2 = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                                if (format2 == null) {
                                    format2 = "";
                                }
                                sb.append(format2);
                                str = sb.toString();
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                str = "";
                            }
                            Intrinsics.checkNotNullParameter(str, "");
                            payResultModel.SubSequence = str;
                            MoneyViewModel moneyViewModel2 = attributeCashierPayModel.X;
                            if (moneyViewModel2 != null) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(moneyViewModel2.KClassImpl$Data$declaredNonStaticMembers$2);
                                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel2.MyBillsEntityDataFactory());
                                if (format == null) {
                                    format = "";
                                }
                                sb2.append(format);
                                str2 = sb2.toString();
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = "";
                            }
                            payResultModel.AppCompatEmojiTextHelper = str2;
                            List<CashierPayChannelModel> list = attributeCashierPayModel.I;
                            String str4 = (list == null || (cashierPayChannelModel = (CashierPayChannelModel) CollectionsKt.getOrNull(list, 0)) == null || (extendCashierModel = cashierPayChannelModel.newProxyInstance) == null) ? null : extendCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            if (str4 == null) {
                                str4 = "";
                            }
                            Intrinsics.checkNotNullParameter(str4, "");
                            payResultModel.A = str4;
                            String str5 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.GB java.lang.String;
                            if (str5 == null) {
                                str5 = "";
                            }
                            Intrinsics.checkNotNullParameter(str5, "");
                            payResultModel.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = str5;
                            String str6 = attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (str6 == null) {
                                str6 = "";
                            }
                            Intrinsics.checkNotNullParameter(str6, "");
                            payResultModel.BuiltInFictitiousFunctionClassFactory = str6;
                            String str7 = attributeCashierPayModel.E;
                            if (str7 == null) {
                                str7 = "";
                            }
                            payResultModel.L = str7;
                            payResultModel.getAuthRequestContext = attributeCashierPayModel.getAuthRequestContext();
                            arrayList = paylaterInstallmentFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
                            payResultModel.G = arrayList;
                            payResultModel.moveToNextValue = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            String str8 = attributeCashierPayModel.BottomSheetCardBindingView$watcherCardNumberView$1;
                            if (str8 == null) {
                                str8 = "";
                            }
                            Intrinsics.checkNotNullParameter(str8, "");
                            payResultModel.readMicros = str8;
                            payResultModel.isLayoutRequested = attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
                            ProcessingMilestoneModel processingMilestoneModel = attributeCashierPayModel.L;
                            payResultModel.getCallingPid = processingMilestoneModel != null ? processingMilestoneModel.PlaceComponentResult : null;
                            payResultModel.getSupportButtonTintMode = attributeCashierPayModel.getOnBoardingScenario;
                            payResultModel.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda0;
                            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = attributeCashierPayModel.GetContactSyncConfig;
                            payResultModel.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel.getSupportButtonTintMode;
                            payResultModel.K = attributeCashierPayModel.V;
                            String BuiltInFictitiousFunctionClassFactory = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory();
                            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
                            payResultModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory;
                            payResultModel.MyBillsEntityDataFactory = attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory;
                        }
                        String str9 = attributeCashierPayModel.O;
                        PaylaterInstallmentFragment.BuiltInFictitiousFunctionClassFactory(paylaterInstallmentFragment, str9 == null ? "" : str9, (String) null, (String) null, CashierPayChannelModelKt.KClassImpl$Data$declaredNonStaticMembers$2(attributeCashierPayModel.I), 6);
                        return;
                    }
                    PaylaterInstallmentFragment.KClassImpl$Data$declaredNonStaticMembers$2(paylaterInstallmentFragment, p0.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }));
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$cashierRiskChallengeModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(PaylaterInstallmentFragment.this.getContext());
            }
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$topUpAndPayModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(PaylaterInstallmentFragment.this.getContext());
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$cashierCardBindingModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(PaylaterInstallmentFragment.this.getContext());
            }
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$cashierHighlightModule$1
        }));
        CashierComponent MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory2;
        MyBillsEntityDataFactory2.getAuthRequestContext(this);
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
        registerPresenter(abstractPresenterArr);
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void moveToNextValue() {
        List<RepaymentPlanModel> list;
        PaylaterInstallmentView paylaterInstallmentView;
        PaylaterInstallmentView paylaterInstallmentView2;
        PaylaterInstallmentView paylaterInstallmentView3;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("channelIndex");
            this.getAuthRequestContext = string;
            if (string != null && (paylaterInstallmentView3 = (PaylaterInstallmentView) BuiltInFictitiousFunctionClassFactory(R.id.paylater_installment_view)) != null) {
                paylaterInstallmentView3.setChannelIdx(string);
            }
            CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod = (CashierPayMethodModel.PaylaterPayMethod) arguments.getParcelable("arg_selected_pay_method");
            this.lookAheadTest = paylaterPayMethod;
            if (paylaterPayMethod != null && (paylaterInstallmentView2 = (PaylaterInstallmentView) BuiltInFictitiousFunctionClassFactory(R.id.paylater_installment_view)) != null) {
                paylaterInstallmentView2.setAdditionalInfo(paylaterPayMethod.MyBillsEntityDataFactory);
            }
            QueryInstallmentModel queryInstallmentModel = (QueryInstallmentModel) arguments.getParcelable("arg_query_installment");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = queryInstallmentModel;
            if (queryInstallmentModel != null && (list = queryInstallmentModel.moveToNextValue) != null && (paylaterInstallmentView = (PaylaterInstallmentView) BuiltInFictitiousFunctionClassFactory(R.id.paylater_installment_view)) != null) {
                paylaterInstallmentView.setInstallmentOptionItems(list);
            }
            String string2 = arguments.getString(CashierKeyParams.CASHIER_ORDER_ID, "");
            Intrinsics.checkNotNullExpressionValue(string2, "");
            this.PlaceComponentResult = string2;
            PayResultModel payResultModel = (PayResultModel) arguments.getParcelable(CashierKeyParams.PAY_RESULT_MODEL);
            this.moveToNextValue = payResultModel;
            getAuthRequestContext(payResultModel != null ? payResultModel.com.iap.ac.android.biz.common.utils.log.LogConstants.RESULT_FALSE java.lang.String : null);
            this.MyBillsEntityDataFactory = (CheckoutExternalInfo) arguments.getParcelable(CashierKeyParams.CHECKOUT_EXTERNAL_INFO);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = arguments.getStringArrayList("selectedAddonsId");
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void BuiltInFictitiousFunctionClassFactory() {
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.setCashierRiskListener(new PayActivity.CashierRiskListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$initCashierListener$1
                @Override // id.dana.pay.PayActivity.CashierRiskListener
                public final void MyBillsEntityDataFactory(String p0) {
                    String str;
                    CashierContract.Presenter presenter = PaylaterInstallmentFragment.this.cashierPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    str = PaylaterInstallmentFragment.this.PlaceComponentResult;
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(str, p0, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
                }
            });
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RiskParamsFactory p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory(p0);
        FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda2 = getPlaceComponentResult();
        if (NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
            NetworkUserEntityData$$ExternalSyntheticLambda2.check();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void lookAheadTest() {
        CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod = this.lookAheadTest;
        if (paylaterPayMethod != null) {
            String str = this.PlaceComponentResult;
            CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod2 = paylaterPayMethod;
            String NetworkUserEntityData$$ExternalSyntheticLambda1 = getInitRecordTimeStamp();
            VoucherCashierModel MyBillsEntityDataFactory = getGetContactSyncConfig();
            ArrayList<String> arrayList = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Integer num = this.KClassImpl$Data$declaredNonStaticMembers$2;
            String str2 = this.lookAheadTest;
            BaseActivity baseActivity = getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            CashierFaceAuthModel cashierFaceAuthModel = new CashierFaceAuthModel(str, paylaterPayMethod2, NetworkUserEntityData$$ExternalSyntheticLambda1, "MIC_FACE", MyBillsEntityDataFactory, arrayList, num, str2, baseActivity);
            CashierContract.Presenter presenter = this.cashierPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.BuiltInFictitiousFunctionClassFactory(cashierFaceAuthModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RiskParamsFactory GetContactSyncConfig = getNetworkUserEntityData$$ExternalSyntheticLambda2();
        if (GetContactSyncConfig != null) {
            String PlaceComponentResult = GetContactSyncConfig.PlaceComponentResult();
            BaseActivity baseActivity = getBaseActivity();
            PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
            if (payActivity != null) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = "";
                }
                PayActivity.handleCashierRiskPhase$default(payActivity, PlaceComponentResult, GetContactSyncConfig, null, null, 12, null);
            }
            BuiltInFictitiousFunctionClassFactory((RiskParamsFactory) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCallingPid() {
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a01c7_otpregistrationpresenter_input_2);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(C());
            danaButtonPrimaryView.setClickable(C());
            boolean C = C();
            Context context = danaButtonPrimaryView.getContext();
            danaButtonPrimaryView.setDanaButtonView(C ? 1 : 0, context != null ? context.getString(R.string.btn_continue_paylater) : null, "", null);
        }
        final boolean C2 = C();
        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a01c7_otpregistrationpresenter_input_2);
        if (danaButtonPrimaryView2 != null) {
            danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PaylaterInstallmentFragment.getAuthRequestContext(C2, this);
                }
            });
        }
    }

    private final boolean C() {
        return this.scheduleImpl && this.getErrorConfigVersion;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011JC\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/cashier/fragment/PaylaterInstallmentFragment$Companion;", "", "Lid/dana/cashier/model/PayResultModel;", "p0", "", "", "p1", "Lid/dana/cashier/model/QueryInstallmentModel;", "p2", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "p3", "Lid/dana/cashier/model/CashierPayMethodModel;", "p4", "Lid/dana/cashier/fragment/PaylaterInstallmentFragment;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/PayResultModel;Ljava/util/List;Lid/dana/cashier/model/QueryInstallmentModel;Lid/dana/cashier/domain/model/CheckoutExternalInfo;Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/fragment/PaylaterInstallmentFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static PaylaterInstallmentFragment MyBillsEntityDataFactory(PayResultModel p0, List<String> p1, QueryInstallmentModel p2, CheckoutExternalInfo p3, CashierPayMethodModel p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            PaylaterInstallmentFragment paylaterInstallmentFragment = new PaylaterInstallmentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelIndex", p4 != null ? p4.moveToNextValue() : null);
            bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, p0.getErrorConfigVersion);
            List mutableList = p1 != null ? CollectionsKt.toMutableList((Collection) p1) : null;
            if (mutableList == null) {
                mutableList = CollectionsKt.emptyList();
            }
            bundle.putStringArrayList("selectedAddonsId", new ArrayList<>(mutableList));
            bundle.putParcelable(CashierKeyParams.PAY_RESULT_MODEL, p0);
            bundle.putParcelable(CashierKeyParams.CHECKOUT_EXTERNAL_INFO, p3);
            bundle.putParcelable("arg_query_installment", p2);
            bundle.putParcelable("arg_selected_pay_method", p4);
            paylaterInstallmentFragment.setArguments(bundle);
            return paylaterInstallmentFragment;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(PaylaterInstallmentFragment paylaterInstallmentFragment, boolean z) {
        Intrinsics.checkNotNullParameter(paylaterInstallmentFragment, "");
        paylaterInstallmentFragment.getErrorConfigVersion = z;
        paylaterInstallmentFragment.getCallingPid();
    }

    public static /* synthetic */ void getAuthRequestContext(boolean z, PaylaterInstallmentFragment paylaterInstallmentFragment) {
        CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod;
        ConsultAgreementModel consultAgreementModel;
        List<AgreementInfo> list;
        Intrinsics.checkNotNullParameter(paylaterInstallmentFragment, "");
        if (!z || (paylaterPayMethod = paylaterInstallmentFragment.lookAheadTest) == null) {
            return;
        }
        CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod2 = paylaterPayMethod;
        paylaterInstallmentFragment.KClassImpl$Data$declaredNonStaticMembers$2(paylaterPayMethod2);
        CashierContract.Presenter presenter = paylaterInstallmentFragment.cashierPresenter;
        AgreementInfo agreementInfo = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        String str = paylaterInstallmentFragment.PlaceComponentResult;
        ArrayList<String> arrayList = paylaterInstallmentFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        List list2 = arrayList;
        VoucherCashierModel MyBillsEntityDataFactory = paylaterInstallmentFragment.getGetContactSyncConfig();
        String str2 = paylaterInstallmentFragment.lookAheadTest;
        Integer num = paylaterInstallmentFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        QueryInstallmentModel queryInstallmentModel = paylaterInstallmentFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (queryInstallmentModel != null && (consultAgreementModel = queryInstallmentModel.PlaceComponentResult) != null && (list = consultAgreementModel.getAuthRequestContext) != null) {
            agreementInfo = (AgreementInfo) CollectionsKt.firstOrNull((List) list);
        }
        presenter.PlaceComponentResult(str, paylaterPayMethod2, (r20 & 4) != 0 ? null : MyBillsEntityDataFactory, false, (r20 & 16) != 0 ? null : list2, (r20 & 32) != 0 ? null : null, (r20 & 64) != 0 ? null : str2, (r20 & 128) != 0 ? null : new PaylaterCashierRequestCheckoutModel(num, agreementInfo, null, null, 12, null));
    }

    public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(PaylaterInstallmentFragment paylaterInstallmentFragment) {
        String str;
        CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod = paylaterInstallmentFragment.lookAheadTest;
        if (paylaterPayMethod != null) {
            str = paylaterPayMethod.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (str == null) {
                str = "";
            }
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, OnlineCreditType.ONLINE_CREDIT_ADAKAMI) ? "Adakami" : Intrinsics.areEqual(str, OnlineCreditType.ONLINE_CREDIT_AKULAKU) ? DanaLogConstants.TAG.AKULAKU_TAG : "";
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PaylaterInstallmentFragment paylaterInstallmentFragment, AttributeCashierPayModel attributeCashierPayModel) {
        String str;
        List<String> list;
        String[] strArr;
        List<OneKlikPhonesModel> list2;
        RiskVerificationMethodModel riskVerificationMethodModel;
        RiskVerificationMethodModel riskVerificationMethodModel2;
        List<OneKlikPhonesModel> list3;
        CurrencyAmountModel currencyAmountModel;
        List<String> list4;
        String str2;
        boolean z = true;
        if (attributeCashierPayModel != null) {
            List<RiskVerificationMethodModel> list5 = attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda1;
            if (!(list5 == null || list5.isEmpty())) {
                RiskVerificationMethodModel riskVerificationMethodModel3 = (RiskVerificationMethodModel) CollectionsKt.first((List) attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda1);
                String str3 = riskVerificationMethodModel3.MyBillsEntityDataFactory;
                if (str3 == null) {
                    str3 = "";
                }
                paylaterInstallmentFragment.KClassImpl$Data$declaredNonStaticMembers$2(str3);
                str2 = riskVerificationMethodModel3.scheduleImpl;
            } else {
                RiskVerificationMethodModel riskVerificationMethodModel4 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String;
                if (riskVerificationMethodModel4 == null || (str2 = riskVerificationMethodModel4.scheduleImpl) == null) {
                    RiskVerificationMethodModel riskVerificationMethodModel5 = attributeCashierPayModel.P;
                    str2 = riskVerificationMethodModel5 != null ? riskVerificationMethodModel5.scheduleImpl : null;
                }
            }
            str = str2;
        } else {
            str = null;
        }
        if (attributeCashierPayModel != null) {
            List<RiskVerificationMethodModel> list6 = attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda1;
            if (list6 != null && !list6.isEmpty()) {
                z = false;
            }
            if (!z) {
                RiskVerificationMethodModel riskVerificationMethodModel6 = (RiskVerificationMethodModel) CollectionsKt.firstOrNull((List) attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda1);
                if (riskVerificationMethodModel6 != null) {
                    list4 = riskVerificationMethodModel6.lookAheadTest;
                    list = list4;
                }
                list4 = null;
                list = list4;
            } else {
                RiskVerificationMethodModel riskVerificationMethodModel7 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String;
                if (riskVerificationMethodModel7 == null || (list4 = riskVerificationMethodModel7.lookAheadTest) == null) {
                    RiskVerificationMethodModel riskVerificationMethodModel8 = attributeCashierPayModel.P;
                    if (riskVerificationMethodModel8 != null) {
                        list4 = riskVerificationMethodModel8.lookAheadTest;
                    }
                    list4 = null;
                }
                list = list4;
            }
        } else {
            list = null;
        }
        if (attributeCashierPayModel != null && (currencyAmountModel = paylaterInstallmentFragment.NetworkUserEntityData$$ExternalSyntheticLambda1) != null) {
            MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
            attributeCashierPayModel.X = MoneyViewModel.Companion.getAuthRequestContext(currencyAmountModel);
        }
        PayResultModel payResultModel = paylaterInstallmentFragment.moveToNextValue;
        if (payResultModel != null) {
            CurrencyAmountModel currencyAmountModel2 = paylaterInstallmentFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            payResultModel.AppCompatEmojiTextHelper = currencyAmountModel2 != null ? currencyAmountModel2.getAuthRequestContext() : null;
        }
        String str4 = paylaterInstallmentFragment.PlaceComponentResult;
        CashierPayMethodModel.PaylaterPayMethod paylaterPayMethod = paylaterInstallmentFragment.lookAheadTest;
        VoucherCashierModel MyBillsEntityDataFactory = paylaterInstallmentFragment.getGetContactSyncConfig();
        PayResultModel payResultModel2 = paylaterInstallmentFragment.moveToNextValue;
        ArrayList<String> arrayList = paylaterInstallmentFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (arrayList != null) {
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            strArr = (String[]) array;
        } else {
            strArr = null;
        }
        RiskParamsFactory riskParamsFactory = new RiskParamsFactory(attributeCashierPayModel, str4, paylaterPayMethod, true, MyBillsEntityDataFactory, payResultModel2, strArr, null, paylaterInstallmentFragment.KClassImpl$Data$declaredNonStaticMembers$2, null, null, null, null, null, list, 16000, null);
        BaseActivity baseActivity = paylaterInstallmentFragment.getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            String str5 = str == null ? "" : str;
            if (attributeCashierPayModel == null || (riskVerificationMethodModel2 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String) == null || (list3 = riskVerificationMethodModel2.getAuthRequestContext) == null) {
                list2 = (attributeCashierPayModel == null || (riskVerificationMethodModel = attributeCashierPayModel.P) == null) ? null : riskVerificationMethodModel.getAuthRequestContext;
            } else {
                list2 = list3;
            }
            payActivity.handleCashierRiskPhase(str5, riskParamsFactory, list2, paylaterInstallmentFragment);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PaylaterInstallmentFragment paylaterInstallmentFragment, CurrencyAmountModel currencyAmountModel) {
        paylaterInstallmentFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = currencyAmountModel;
        AppCompatTextView appCompatTextView = (AppCompatTextView) paylaterInstallmentFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1618_snapshotcontroller_1);
        if (appCompatTextView != null) {
            CurrencyAmountModel currencyAmountModel2 = paylaterInstallmentFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            appCompatTextView.setText(currencyAmountModel2 != null ? currencyAmountModel2.getAuthRequestContext() : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PaylaterInstallmentFragment paylaterInstallmentFragment, String str, String str2, String str3, boolean z, int i) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            z = false;
        }
        PayResultModel payResultModel = paylaterInstallmentFragment.moveToNextValue;
        if (payResultModel != null) {
            payResultModel.getValueOfTouchPositionAbsolute = str;
            String str4 = paylaterInstallmentFragment.PlaceComponentResult;
            Intrinsics.checkNotNullParameter(str4, "");
            payResultModel.getErrorConfigVersion = str4;
            payResultModel.GetContactSyncConfig = str2;
            payResultModel.scheduleImpl = str3;
            BaseActivity baseActivity = paylaterInstallmentFragment.getBaseActivity();
            PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
            if (payActivity != null) {
                PaymentResultFragment.Companion companion = PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                payActivity.addFragment(PaymentResultFragment.Companion.BuiltInFictitiousFunctionClassFactory(payResultModel, z));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [id.dana.cashier.fragment.PaylaterInstallmentFragment$setClickableSpan$1] */
    private static /* synthetic */ PaylaterInstallmentFragment$setClickableSpan$1 MyBillsEntityDataFactory(final PaylaterInstallmentFragment paylaterInstallmentFragment, final String str, final String str2, int i) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        return new ClickableSpan() { // from class: id.dana.cashier.fragment.PaylaterInstallmentFragment$setClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public final void onClick(View p0) {
                Intent intent;
                Intrinsics.checkNotNullParameter(p0, "");
                if (str.length() > 0) {
                    DanaH5.startContainerFullUrl(str);
                    return;
                }
                if (str2.length() > 0) {
                    Context context = paylaterInstallmentFragment.getContext();
                    PaylaterAnalyticTracker paylaterAnalyticTracker = null;
                    if (context != null) {
                        String str3 = str2;
                        CashierPaylaterTnCActivity.Companion companion = CashierPaylaterTnCActivity.INSTANCE;
                        intent = CashierPaylaterTnCActivity.Companion.PlaceComponentResult(context, str3);
                    } else {
                        intent = null;
                    }
                    paylaterInstallmentFragment.startActivity(intent);
                    PaylaterAnalyticTracker paylaterAnalyticTracker2 = paylaterInstallmentFragment.paylaterAnalyticTracker;
                    if (paylaterAnalyticTracker2 != null) {
                        paylaterAnalyticTracker = paylaterAnalyticTracker2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    paylaterAnalyticTracker.BuiltInFictitiousFunctionClassFactory(PaylaterInstallmentFragment.KClassImpl$Data$declaredNonStaticMembers$2(paylaterInstallmentFragment));
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public final void updateDrawState(TextPaint p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.updateDrawState(p0);
                p0.setUnderlineText(false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        if (r1.equals(id.dana.cashier.helper.CashierErrorType.RETRYABLE_RISK_CHALLENGE) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        r1 = r8;
        r9 = r9.getAuthRequestContext.asString(getContext());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r9 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        r9 = getString(id.dana.R.string.paylater_general_error_message);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
    
        id.dana.cashier.fragment.BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(r1, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (r1.equals(id.dana.cashier.helper.CashierErrorType.EXCEED_LIMIT) != false) goto L17;
     */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.helper.CashierErrorState r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r1 = r9.MyBillsEntityDataFactory
            int r2 = r1.hashCode()
            r3 = -2080396080(0xffffffff83ffacd0, float:-1.5027229E-36)
            if (r2 == r3) goto L39
            r3 = -1799199172(0xffffffff94c2663c, float:-1.9629318E-26)
            if (r2 == r3) goto L23
            r3 = -630188208(0xffffffffda701750, float:-1.68949067E16)
            if (r2 != r3) goto L5e
            java.lang.String r2 = "EXCEED_LIMIT"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L41
            goto L5e
        L23:
            java.lang.String r0 = "INSUFFICIENT_PAYLATER_LIMIT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5e
            r9 = r8
            id.dana.cashier.fragment.BaseCashierFragment r9 = (id.dana.cashier.fragment.BaseCashierFragment) r9
            r0 = 2131958074(0x7f13193a, float:1.955275E38)
            java.lang.String r0 = r8.getString(r0)
            id.dana.cashier.fragment.BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(r9, r0)
            return
        L39:
            java.lang.String r2 = "RETRYABLE_RISK_CHALLENGE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L5e
        L41:
            r1 = r8
            id.dana.cashier.fragment.BaseCashierFragment r1 = (id.dana.cashier.fragment.BaseCashierFragment) r1
            id.dana.core.ui.model.UiTextModel r9 = r9.getAuthRequestContext
            android.content.Context r2 = r8.getContext()
            java.lang.String r9 = r9.asString(r2)
            if (r9 != 0) goto L5a
            r9 = 2131956006(0x7f131126, float:1.9548556E38)
            java.lang.String r9 = r8.getString(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
        L5a:
            id.dana.cashier.fragment.BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(r1, r9)
            return
        L5e:
            id.dana.core.ui.model.UiTextModel r0 = r9.getAuthRequestContext
            android.content.Context r1 = r8.getContext()
            java.lang.String r4 = r0.asString(r1)
            java.lang.String r5 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            r6 = 0
            r7 = 8
            java.lang.String r3 = "fail"
            r2 = r8
            BuiltInFictitiousFunctionClassFactory(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.PaylaterInstallmentFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.helper.CashierErrorState):void");
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.cashier.fragment.BaseCashierFragment
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CashierAnalyticTracker cashierAnalyticTracker = this.cashierAnalyticTracker;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        cashierAnalyticTracker.getAuthRequestContext(p0.initRecordTimeStamp());
        CashierAnalyticTracker cashierAnalyticTracker2 = this.cashierAnalyticTracker;
        if (cashierAnalyticTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker2 = null;
        }
        String str = this.PlaceComponentResult;
        ArrayList<String> arrayList = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        List list = arrayList != null ? CollectionsKt.toList(arrayList) : null;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List list2 = list;
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        AddOnTrackingModel addOnTrackingModel = payActivity != null ? payActivity.getAddOnTrackingModel() : null;
        PayResultModel payResultModel = this.moveToNextValue;
        String str2 = payResultModel != null ? payResultModel.VerifyPinStateManager$executeRiskChallenge$2$2 : null;
        String source = getBaseActivity().getSource();
        Intrinsics.checkNotNullExpressionValue(source, "");
        BaseActivity baseActivity2 = getBaseActivity();
        PayActivity payActivity2 = baseActivity2 instanceof PayActivity ? (PayActivity) baseActivity2 : null;
        cashierAnalyticTracker2.MyBillsEntityDataFactory(new PaymentExecutionTrackerParams(str, p0, list2, addOnTrackingModel, str2, source, null, payActivity2 != null ? payActivity2.getFeatureTimeModel() : null, 64, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.BaseCashierFragment
    public final void MyBillsEntityDataFactory(boolean p0) {
        CashierAnalyticTracker cashierAnalyticTracker = this.cashierAnalyticTracker;
        if (cashierAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierAnalyticTracker = null;
        }
        CashierAnalyticTracker.CC.BuiltInFictitiousFunctionClassFactory(cashierAnalyticTracker, this.PlaceComponentResult, TrackerKey.CashierRiskType.FACE_VERIFICATION_CASHIER, Boolean.valueOf(p0), 4);
    }
}
