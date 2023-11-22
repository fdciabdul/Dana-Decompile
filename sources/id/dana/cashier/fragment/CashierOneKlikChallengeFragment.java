package id.dana.cashier.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierRiskChallengeContract;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.OneklikAnnotations;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayChannelModelKt;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.ExtendCashierModel;
import id.dana.cashier.model.OneKlikPhonesModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.ProcessingMilestoneModel;
import id.dana.cashier.model.TopUpVerifyRequestModel;
import id.dana.cashier.presenter.CashierPresenter;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.presenter.TopUpAndPayPresenter;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.databinding.FragmentCashierOneklikChallengeBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.domain.otp.interactor.VerifyOtpOneKlik;
import id.dana.extension.view.InputExtKt;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.richview.DanaProtectionLoadingView;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import id.dana.utils.TextUtil;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u000fJC\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0012\u0010\u001a\u001a\u00020\u0019X\u0087\"¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001d\u001a\u00020\u001cX\u0087\"¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010!R&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0012\u0010)\u001a\u00020(X\u0087\"¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Lid/dana/cashier/fragment/CashierOneKlikChallengeFragment;", "Lid/dana/cashier/fragment/BaseCashierRiskFragment;", "Lid/dana/databinding/FragmentCashierOneklikChallengeBinding;", "", "p0", "p1", "p2", "p3", "p4", "", "p5", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "FragmentBottomSheetPaymentSettingBinding", "()V", "NetworkUserEntityData$$ExternalSyntheticLambda3", "onDestroyView", "whenAvailable", "PlaceComponentResult", "(Z)V", "initRecordTimeStamp", "Ljava/lang/String;", "GetContactSyncConfig", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/presenter/CashierPresenter;", "cashierPresenter", "Lid/dana/cashier/presenter/CashierPresenter;", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "cashierRiskChallengePresenter", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "Landroid/os/CountDownTimer;", "isLayoutRequested", "Landroid/os/CountDownTimer;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/ArrayList;", "Lid/dana/cashier/model/OneKlikPhonesModel;", "Lkotlin/collections/ArrayList;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/util/ArrayList;", "Lid/dana/cashier/presenter/TopUpAndPayPresenter;", "topUpAndPayPresenter", "Lid/dana/cashier/presenter/TopUpAndPayPresenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierOneKlikChallengeFragment extends BaseCashierRiskFragment<FragmentCashierOneklikChallengeBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @Inject
    public CashierPresenter cashierPresenter;
    @Inject
    public CashierRiskChallengePresenter cashierRiskChallengePresenter;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private CountDownTimer BuiltInFictitiousFunctionClassFactory;
    @Inject
    public TopUpAndPayPresenter topUpAndPayPresenter;
    public Map<Integer, View> NetworkUserEntityData$$ExternalSyntheticLambda1 = new LinkedHashMap();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2 = "";

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String getAuthRequestContext = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private ArrayList<OneKlikPhonesModel> PlaceComponentResult = new ArrayList<>();

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
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
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ ViewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCashierOneklikChallengeBinding PlaceComponentResult = FragmentCashierOneklikChallengeBinding.PlaceComponentResult(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        super.FragmentBottomSheetPaymentSettingBinding();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            FragmentActivity fragmentActivity = activity;
            ArrayList<OneKlikPhonesModel> arrayList = this.PlaceComponentResult;
            ArrayList arrayList2 = new ArrayList();
            Iterator<OneKlikPhonesModel> it = arrayList.iterator();
            while (it.hasNext()) {
                String str = it.next().PlaceComponentResult;
                if (str == null) {
                    str = "";
                }
                arrayList2.add(PhoneNumberUtilKt.removeIndoPhonePrefix(str));
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(fragmentActivity, (int) R.layout.spinner_item_body16_normal, arrayList2);
            arrayAdapter.setDropDownViewResource(17367049);
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentCashierOneklikChallengeBinding) vb).getErrorConfigVersion.setAdapter((SpinnerAdapter) arrayAdapter);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb2 = this.PlaceComponentResult;
        if (vb2 != 0) {
            ((FragmentCashierOneklikChallengeBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierOneKlikChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierOneKlikChallengeFragment.this);
                }
            });
            VB vb3 = this.PlaceComponentResult;
            if (vb3 != 0) {
                PlaceComponentResult(RxTextView.textChanges(((FragmentCashierOneklikChallengeBinding) vb3).getAuthRequestContext).filter(new Predicate() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Predicate
                    public final boolean test(Object obj) {
                        boolean KClassImpl$Data$declaredNonStaticMembers$2;
                        KClassImpl$Data$declaredNonStaticMembers$2 = CashierOneKlikChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierOneKlikChallengeFragment.this, (CharSequence) obj);
                        return KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                }).subscribe(new Consumer() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        CashierOneKlikChallengeFragment.MyBillsEntityDataFactory(CashierOneKlikChallengeFragment.this, (CharSequence) obj);
                    }
                }));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(cashierOneKlikChallengeFragment, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        int length = charSequence.length();
        VB vb = cashierOneKlikChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            return length == ((FragmentCashierOneklikChallengeBinding) vb).getAuthRequestContext.getMaxLength();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$cashierRiskChallengeModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
                CashierOneKlikChallengeFragment.MyBillsEntityDataFactory(CashierOneKlikChallengeFragment.this);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOneKlikChallengeFragment.PlaceComponentResult(CashierOneKlikChallengeFragment.this);
                VB vb = CashierOneKlikChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    ((FragmentCashierOneklikChallengeBinding) vb).GetContactSyncConfig.setVisibility(0);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void initRecordTimeStamp() {
                String str;
                String str2;
                CashierPresenter cashierPresenter = null;
                if (CashierOneKlikChallengeFragment.this.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    TopUpAndPayPresenter topUpAndPayPresenter = CashierOneKlikChallengeFragment.this.topUpAndPayPresenter;
                    if (topUpAndPayPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        topUpAndPayPresenter = null;
                    }
                    TopUpAndPayPresenter topUpAndPayPresenter2 = topUpAndPayPresenter;
                    str2 = CashierOneKlikChallengeFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    TopUpVerifyRequestModel topUpVerifyRequestModel = ((BaseCashierRiskFragment) CashierOneKlikChallengeFragment.this).moveToNextValue;
                    String str3 = topUpVerifyRequestModel != null ? topUpVerifyRequestModel.getAuthRequestContext : null;
                    String str4 = str3 != null ? str3 : "";
                    FragmentActivity activity = CashierOneKlikChallengeFragment.this.getActivity();
                    PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
                    topUpAndPayPresenter2.PlaceComponentResult(str2, str4, null, payActivity != null ? payActivity.getMoveToNextValue() : null);
                    return;
                }
                CashierPresenter cashierPresenter2 = CashierOneKlikChallengeFragment.this.cashierPresenter;
                if (cashierPresenter2 != null) {
                    cashierPresenter = cashierPresenter2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                str = CashierOneKlikChallengeFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                cashierPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str, null, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? null : null);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
                CashierOneKlikChallengeFragment.PlaceComponentResult(CashierOneKlikChallengeFragment.this);
                VB vb = CashierOneKlikChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    ((FragmentCashierOneklikChallengeBinding) vb).GetContactSyncConfig.setVisibility(0);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }));
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOneKlikChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierOneKlikChallengeFragment.this, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOneKlikChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                CashierOneKlikChallengeFragment.this.SubSequence();
                VB vb = CashierOneKlikChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    TextView textView = ((FragmentCashierOneklikChallengeBinding) vb).GetContactSyncConfig;
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    textView.setVisibility(8);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierOneKlikChallengeFragment.this.GetContactSyncConfig();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment = CashierOneKlikChallengeFragment.this;
                if (p0 == null) {
                    p0 = "";
                }
                FragmentActivity activity = cashierOneKlikChallengeFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
                VB vb = CashierOneKlikChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    TextView textView = ((FragmentCashierOneklikChallengeBinding) vb).GetContactSyncConfig;
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    InputExtKt.MyBillsEntityDataFactory(textView);
                    CashierOneKlikChallengeFragment.MyBillsEntityDataFactory(CashierOneKlikChallengeFragment.this);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void getErrorConfigVersion() {
                CashierOneKlikChallengeFragment.this.getAuthRequestContext(true);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void scheduleImpl() {
                CashierOneKlikChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                CashierOneKlikChallengeFragment.this.getAuthRequestContext(false);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierOneKlikChallengeFragment.this.getContext());
            }
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$topUpAndPayModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void MyBillsEntityDataFactory(CashierPayModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOneKlikChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierOneKlikChallengeFragment.this, p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                CashierOneKlikChallengeFragment.this.SubSequence();
                VB vb = CashierOneKlikChallengeFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    TextView textView = ((FragmentCashierOneklikChallengeBinding) vb).GetContactSyncConfig;
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    textView.setVisibility(8);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierOneKlikChallengeFragment.this.GetContactSyncConfig();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.TopUpAndPayContract.View
            public final void lookAheadTest(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOneKlikChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CashierOneKlikChallengeFragment.this.PlaceComponentResult(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment = CashierOneKlikChallengeFragment.this;
                if (p0 == null) {
                    p0 = "";
                }
                FragmentActivity activity = cashierOneKlikChallengeFragment.getActivity();
                if (activity != null) {
                    CustomToast.BuiltInFictitiousFunctionClassFactory(activity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, p0, 72, true, null);
                }
                CashierOneKlikChallengeFragment.MyBillsEntityDataFactory(CashierOneKlikChallengeFragment.this);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return LocationUtil.getAuthRequestContext(CashierOneKlikChallengeFragment.this.getContext());
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.CashierOneKlikChallengeFragment$cashierHighlightModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().PlaceComponentResult(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[3];
        CashierRiskChallengePresenter cashierRiskChallengePresenter = this.cashierRiskChallengePresenter;
        TopUpAndPayPresenter topUpAndPayPresenter = null;
        if (cashierRiskChallengePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierRiskChallengePresenter = null;
        }
        abstractPresenterArr[0] = cashierRiskChallengePresenter;
        CashierPresenter cashierPresenter = this.cashierPresenter;
        if (cashierPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierPresenter = null;
        }
        abstractPresenterArr[1] = cashierPresenter;
        TopUpAndPayPresenter topUpAndPayPresenter2 = this.topUpAndPayPresenter;
        if (topUpAndPayPresenter2 != null) {
            topUpAndPayPresenter = topUpAndPayPresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        abstractPresenterArr[2] = topUpAndPayPresenter;
        BuiltInFictitiousFunctionClassFactory(abstractPresenterArr);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void whenAvailable() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            ((BaseCashierRiskFragment) this).NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierPayMethodModel) arguments.getParcelable(CashierKeyParams.CASHIER_PAY_METHOD);
            String string = arguments.getString("BANK_PHONE_NUMBER");
            if (string == null) {
                string = "";
            }
            this.getAuthRequestContext = string;
            ArrayList<OneKlikPhonesModel> parcelableArrayList = arguments.getParcelableArrayList("PHONE_NUMBER_LIST");
            if (parcelableArrayList != null) {
                for (OneKlikPhonesModel oneKlikPhonesModel : parcelableArrayList) {
                    if (oneKlikPhonesModel != null) {
                        this.PlaceComponentResult.add(oneKlikPhonesModel);
                    }
                }
            }
            String string2 = arguments.getString(CashierKeyParams.CASHIER_ORDER_ID);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = string2 != null ? string2 : "";
            MyBillsEntityDataFactory((TopUpVerifyRequestModel) arguments.getParcelable(CashierKeyParams.TOP_UP_VERIFY_REQUEST_MODEL));
            BuiltInFictitiousFunctionClassFactory(((BaseCashierRiskFragment) this).moveToNextValue != null);
            MyBillsEntityDataFactory((PayResultModel) arguments.getParcelable(CashierKeyParams.PAY_RESULT_MODEL));
        }
    }

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.BuiltInFictitiousFunctionClassFactory;
        if (countDownTimer != null) {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/fragment/CashierOneKlikChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/cashier/fragment/CashierOneKlikChallengeFragment;", "PlaceComponentResult", "(Landroid/os/Bundle;)Lid/dana/cashier/fragment/CashierOneKlikChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CashierOneKlikChallengeFragment PlaceComponentResult(Bundle p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment = new CashierOneKlikChallengeFragment();
            cashierOneKlikChallengeFragment.setArguments(p0);
            return cashierOneKlikChallengeFragment;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.CashierOneKlikChallengeFragment r26) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierOneKlikChallengeFragment.BuiltInFictitiousFunctionClassFactory(id.dana.cashier.fragment.CashierOneKlikChallengeFragment):void");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment, CharSequence charSequence) {
        String str;
        Intrinsics.checkNotNullParameter(cashierOneKlikChallengeFragment, "");
        String obj = charSequence.toString();
        VB vb = cashierOneKlikChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            DanaProtectionLoadingView danaProtectionLoadingView = ((FragmentCashierOneklikChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory;
            if (danaProtectionLoadingView != null) {
                danaProtectionLoadingView.startLoading();
            }
            final CashierRiskChallengePresenter cashierRiskChallengePresenter = cashierOneKlikChallengeFragment.cashierRiskChallengePresenter;
            if (cashierRiskChallengePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                cashierRiskChallengePresenter = null;
            }
            if (!cashierOneKlikChallengeFragment.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                str = cashierOneKlikChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            } else {
                TopUpVerifyRequestModel topUpVerifyRequestModel = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).moveToNextValue;
                str = topUpVerifyRequestModel != null ? topUpVerifyRequestModel.getAuthRequestContext : null;
                if (str == null) {
                    str = "";
                }
            }
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(obj, "");
            String androidId = cashierRiskChallengePresenter.getAuthRequestContext.getAndroidId(cashierRiskChallengePresenter.PlaceComponentResult);
            String str2 = androidId;
            if (!(str2 == null || str2.length() == 0)) {
                VerifyOtpOneKlik verifyOtpOneKlik = cashierRiskChallengePresenter.scheduleImpl;
                String authRequestContext = TextUtil.getAuthRequestContext(androidId, UserAgentFactory.getUserAgent(), OneklikAnnotations.ONEKLIK_STATIC_IP);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                verifyOtpOneKlik.execute(new VerifyOtpOneKlik.Params(str, obj, authRequestContext), new Function1<Boolean, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$verifyOtpOneklik$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        CashierRiskChallengeContract.View view;
                        CashierRiskChallengeContract.View view2;
                        if (z) {
                            view2 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                            view2.initRecordTimeStamp();
                            return;
                        }
                        view = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                        view.NetworkUserEntityData$$ExternalSyntheticLambda1();
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$verifyOtpOneklik$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        CashierRiskChallengeContract.View view;
                        Intrinsics.checkNotNullParameter(th, "");
                        view = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                        view.NetworkUserEntityData$$ExternalSyntheticLambda1();
                    }
                });
            } else {
                cashierRiskChallengePresenter.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1();
            }
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(cashierOneKlikChallengeFragment.getActivity());
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment, CashierPayModel cashierPayModel) {
        String str;
        String str2;
        String format;
        CashierPayChannelModel cashierPayChannelModel;
        ExtendCashierModel extendCashierModel;
        String format2;
        PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel != null) {
            AttributeCashierPayModel attributeCashierPayModel = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            payResultModel.FragmentBottomSheetPaymentSettingBinding = attributeCashierPayModel != null ? attributeCashierPayModel.getSupportButtonTintMode : null;
        }
        PayResultModel payResultModel2 = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel2 != null) {
            AttributeCashierPayModel attributeCashierPayModel2 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            payResultModel2.VerifyPinStateManager$executeRiskChallenge$2$2 = attributeCashierPayModel2 != null ? attributeCashierPayModel2.SummaryVoucherView$$ExternalSyntheticLambda0 : null;
        }
        PayResultModel payResultModel3 = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel3 != null) {
            AttributeCashierPayModel attributeCashierPayModel3 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            payResultModel3.getOnBoardingScenario = attributeCashierPayModel3 != null ? attributeCashierPayModel3.J : null;
        }
        PayResultModel payResultModel4 = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel4 != null) {
            AttributeCashierPayModel attributeCashierPayModel4 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            String BuiltInFictitiousFunctionClassFactory = attributeCashierPayModel4 != null ? attributeCashierPayModel4.BuiltInFictitiousFunctionClassFactory() : null;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory = "";
            }
            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
            payResultModel4.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory;
        }
        PayResultModel payResultModel5 = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel5 != null) {
            AttributeCashierPayModel attributeCashierPayModel5 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            payResultModel5.C = attributeCashierPayModel5 != null ? attributeCashierPayModel5.I : null;
        }
        PayResultModel payResultModel6 = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel6 != null) {
            AttributeCashierPayModel attributeCashierPayModel6 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            payResultModel6.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String = attributeCashierPayModel6 != null ? attributeCashierPayModel6.W : null;
        }
        PayResultModel payResultModel7 = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel7 != null) {
            AttributeCashierPayModel attributeCashierPayModel7 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            payResultModel7.whenAvailable = attributeCashierPayModel7 != null ? attributeCashierPayModel7.getValueOfTouchPositionAbsolute : null;
        }
        PayResultModel payResultModel8 = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).BuiltInFictitiousFunctionClassFactory;
        if (payResultModel8 != null) {
            AttributeCashierPayModel attributeCashierPayModel8 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            payResultModel8.MyBillsEntityDataFactory = attributeCashierPayModel8 != null ? attributeCashierPayModel8.BuiltInFictitiousFunctionClassFactory : null;
        }
        if (Intrinsics.areEqual(cashierPayModel.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE)) {
            AttributeCashierPayModel attributeCashierPayModel9 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
            if ((attributeCashierPayModel9 != null ? attributeCashierPayModel9.P : null) == null) {
                AttributeCashierPayModel attributeCashierPayModel10 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
                if (attributeCashierPayModel10 != null) {
                    PayResultModel payResultModel9 = ((BaseCashierRiskFragment) cashierOneKlikChallengeFragment).BuiltInFictitiousFunctionClassFactory;
                    if (payResultModel9 != null) {
                        String str3 = attributeCashierPayModel10.SubSequence;
                        if (str3 == null) {
                            str3 = "";
                        }
                        Intrinsics.checkNotNullParameter(str3, "");
                        payResultModel9.PrepareContext = str3;
                        MoneyViewModel moneyViewModel = attributeCashierPayModel10.getValueOfTouchPositionAbsolute;
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
                        payResultModel9.SubSequence = str;
                        String str4 = attributeCashierPayModel10.com.alibaba.griver.image.photo.utils.DiskFormatter.GB java.lang.String;
                        if (str4 == null) {
                            str4 = "";
                        }
                        Intrinsics.checkNotNullParameter(str4, "");
                        payResultModel9.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = str4;
                        List<CashierPayChannelModel> list = attributeCashierPayModel10.I;
                        String str5 = (list == null || (cashierPayChannelModel = (CashierPayChannelModel) CollectionsKt.getOrNull(list, 0)) == null || (extendCashierModel = cashierPayChannelModel.newProxyInstance) == null) ? null : extendCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (str5 == null) {
                            str5 = "";
                        }
                        Intrinsics.checkNotNullParameter(str5, "");
                        payResultModel9.A = str5;
                        String str6 = attributeCashierPayModel10.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (str6 == null) {
                            str6 = "";
                        }
                        Intrinsics.checkNotNullParameter(str6, "");
                        payResultModel9.BuiltInFictitiousFunctionClassFactory = str6;
                        String str7 = attributeCashierPayModel10.C;
                        if (str7 == null) {
                            str7 = "";
                        }
                        Intrinsics.checkNotNullParameter(str7, "");
                        payResultModel9.NetworkUserEntityData$$ExternalSyntheticLambda4 = str7;
                        String str8 = attributeCashierPayModel10.E;
                        if (str8 == null) {
                            str8 = "";
                        }
                        payResultModel9.L = str8;
                        payResultModel9.getAuthRequestContext = attributeCashierPayModel10.getAuthRequestContext();
                        MoneyViewModel moneyViewModel2 = attributeCashierPayModel10.X;
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
                        payResultModel9.AppCompatEmojiTextHelper = str2;
                        payResultModel9.moveToNextValue = attributeCashierPayModel10.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        String str9 = attributeCashierPayModel10.BottomSheetCardBindingView$watcherCardNumberView$1;
                        if (str9 == null) {
                            str9 = "";
                        }
                        Intrinsics.checkNotNullParameter(str9, "");
                        payResultModel9.readMicros = str9;
                        ProcessingMilestoneModel processingMilestoneModel = attributeCashierPayModel10.L;
                        payResultModel9.getCallingPid = processingMilestoneModel != null ? processingMilestoneModel.PlaceComponentResult : null;
                        String str10 = attributeCashierPayModel10.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                        if (str10 == null) {
                            str10 = "";
                        }
                        payResultModel9.VerifyPinStateManager$executeRiskChallenge$2$1 = str10;
                        payResultModel9.getSupportButtonTintMode = attributeCashierPayModel10.getOnBoardingScenario;
                        payResultModel9.NetworkUserEntityData$$ExternalSyntheticLambda2 = attributeCashierPayModel10.GetContactSyncConfig;
                        payResultModel9.K = attributeCashierPayModel10.V;
                        String BuiltInFictitiousFunctionClassFactory2 = attributeCashierPayModel10.BuiltInFictitiousFunctionClassFactory();
                        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory2, "");
                        payResultModel9.NetworkUserEntityData$$ExternalSyntheticLambda1 = BuiltInFictitiousFunctionClassFactory2;
                        payResultModel9.NetworkUserEntityData$$ExternalSyntheticLambda3 = attributeCashierPayModel10.A;
                        payResultModel9.NetworkUserEntityData$$ExternalSyntheticLambda8 = attributeCashierPayModel10.NetworkUserEntityData$$ExternalSyntheticLambda6;
                        Boolean bool = attributeCashierPayModel10.NetworkUserEntityData$$ExternalSyntheticLambda4;
                        payResultModel9.newProxyInstance = bool != null ? bool.booleanValue() : false;
                        Boolean bool2 = attributeCashierPayModel10.VerifyPinStateManager$executeRiskChallenge$2$1;
                        payResultModel9.NetworkUserEntityData$$ExternalSyntheticLambda6 = bool2 != null ? bool2.booleanValue() : false;
                    }
                    CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment2 = cashierOneKlikChallengeFragment;
                    String str11 = attributeCashierPayModel10.O;
                    BaseVBCashierFragment.getAuthRequestContext(cashierOneKlikChallengeFragment2, str11 == null ? "" : str11, null, null, null, null, CashierPayChannelModelKt.KClassImpl$Data$declaredNonStaticMembers$2(attributeCashierPayModel10.I), 30);
                    return;
                }
                return;
            }
        }
        VB vb = cashierOneKlikChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierOneklikChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory.finishLoading(true);
            VB vb2 = cashierOneKlikChallengeFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCashierOneklikChallengeBinding) vb2).BuiltInFictitiousFunctionClassFactory.hideVisibility();
                VB vb3 = cashierOneKlikChallengeFragment.PlaceComponentResult;
                if (vb3 != 0) {
                    PinEntryEditText pinEntryEditText = ((FragmentCashierOneklikChallengeBinding) vb3).getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
                    InputExtKt.MyBillsEntityDataFactory(pinEntryEditText);
                    VB vb4 = cashierOneKlikChallengeFragment.PlaceComponentResult;
                    if (vb4 != 0) {
                        TextView textView = ((FragmentCashierOneklikChallengeBinding) vb4).GetContactSyncConfig;
                        Intrinsics.checkNotNullExpressionValue(textView, "");
                        textView.setVisibility(0);
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

    public static final /* synthetic */ void PlaceComponentResult(CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment) {
        VB vb = cashierOneKlikChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierOneklikChallengeBinding) vb).BuiltInFictitiousFunctionClassFactory.finishLoading(true);
            VB vb2 = cashierOneKlikChallengeFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCashierOneklikChallengeBinding) vb2).BuiltInFictitiousFunctionClassFactory.hideVisibility();
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierOneKlikChallengeFragment cashierOneKlikChallengeFragment) {
        VB vb = cashierOneKlikChallengeFragment.PlaceComponentResult;
        if (vb != 0) {
            PinEntryEditText pinEntryEditText = ((FragmentCashierOneklikChallengeBinding) vb).getAuthRequestContext;
            if (pinEntryEditText != null) {
                pinEntryEditText.requestFocus();
            }
            FragmentActivity activity = cashierOneKlikChallengeFragment.getActivity();
            if (activity != null) {
                KeyboardHelper.getAuthRequestContext(activity);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void PlaceComponentResult(boolean p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierOneklikChallengeBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(p0 ? 8 : 0);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentCashierOneklikChallengeBinding) vb2).MyBillsEntityDataFactory.setVisibility(p0 ? 0 : 8);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
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
            payResultModel.getValueOfTouchPositionAbsolute = p0;
            payResultModel.GetContactSyncConfig = p1;
            payResultModel.scheduleImpl = p2;
            payResultModel.G = BuiltInFictitiousFunctionClassFactory();
            FragmentActivity activity = getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                PaymentResultFragment.Companion companion = PaymentResultFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                payActivity.addFragment(PaymentResultFragment.Companion.BuiltInFictitiousFunctionClassFactory(payResultModel, p5));
            }
        }
    }
}
