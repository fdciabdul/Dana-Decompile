package id.dana.cashier.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.ThrottledOnClickListenerKt;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.fragment.CashierOtpChallengeFragment;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.DailyLimitAmountConfModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.FragmentCashierVerifyLimitAmountDailyBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.pay.PayActivity;
import id.dana.utils.KeyboardHelper;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001e\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0011R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001c\u001a\u00020\u001bX\u0087\"¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/cashier/fragment/CashierDailyLimitVerifyFragment;", "Lid/dana/cashier/fragment/BaseCashierRiskFragment;", "Lid/dana/databinding/FragmentCashierVerifyLimitAmountDailyBinding;", "", "p0", "", "MyBillsEntityDataFactory", "(Z)V", "", "p1", "p2", "p3", "", "(JJJJ)Ljava/lang/String;", "C", "()J", "NetworkUserEntityData$$ExternalSyntheticLambda3", "()V", "NetworkUserEntityData$$ExternalSyntheticLambda4", "whenAvailable", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Z)V", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "cashierRiskChallengePresenter", "Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class CashierDailyLimitVerifyFragment extends BaseCashierRiskFragment<FragmentCashierVerifyLimitAmountDailyBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private CashierPayMethodModel.CardPayMethod KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public CashierRiskChallengePresenter cashierRiskChallengePresenter;
    public Map<Integer, View> initRecordTimeStamp = new LinkedHashMap();

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
        FragmentCashierVerifyLimitAmountDailyBinding MyBillsEntityDataFactory = FragmentCashierVerifyLimitAmountDailyBinding.MyBillsEntityDataFactory(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(initRecordTimeStamp());
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$otpModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierRiskChallengeContract.View
            public final void getAuthRequestContext(int i, int i2) {
                CashierDailyLimitVerifyFragment.BuiltInFictitiousFunctionClassFactory(CashierDailyLimitVerifyFragment.this, i, i2);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(CashierDailyLimitVerifyFragment.this.getActivity());
                CashierDailyLimitVerifyFragment.this.SubSequence();
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                CashierDailyLimitVerifyFragment.this.GetContactSyncConfig();
                CashierDailyLimitVerifyFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierDailyLimitVerifyFragment.this);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                CashierDailyLimitVerifyFragment.KClassImpl$Data$declaredNonStaticMembers$2(CashierDailyLimitVerifyFragment.this);
            }
        }));
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(new CashierModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$cashierModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$cashierHighlightModule$1
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$topUpAndPayModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().MyBillsEntityDataFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        CashierRiskChallengePresenter cashierRiskChallengePresenter = this.cashierRiskChallengePresenter;
        if (cashierRiskChallengePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierRiskChallengePresenter = null;
        }
        abstractPresenterArr[0] = cashierRiskChallengePresenter;
        BuiltInFictitiousFunctionClassFactory(abstractPresenterArr);
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void whenAvailable() {
        AssetCardModel assetCardModel;
        DailyLimitAmountConfModel dailyLimitAmountConfModel;
        Integer num;
        Bundle arguments = getArguments();
        if (arguments != null) {
            CashierPayMethodModel.CardPayMethod cardPayMethod = (CashierPayMethodModel.CardPayMethod) arguments.getParcelable(CashierKeyParams.CASHIER_PAY_METHOD);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cardPayMethod;
            if (cardPayMethod != null && (assetCardModel = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2) != null && (dailyLimitAmountConfModel = assetCardModel.moveToNextValue) != null && (num = dailyLimitAmountConfModel.BuiltInFictitiousFunctionClassFactory) != null) {
                int intValue = num.intValue();
                VB vb = this.PlaceComponentResult;
                if (vb != 0) {
                    ((FragmentCashierVerifyLimitAmountDailyBinding) vb).MyBillsEntityDataFactory.setText(String.valueOf(intValue));
                    VerifyPinStateManager$executeRiskChallenge$2$1();
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            MyBillsEntityDataFactory((PayResultModel) arguments.getParcelable(CashierKeyParams.PAY_RESULT_MODEL));
        }
    }

    private final String MyBillsEntityDataFactory(long p0, long p1, long p2, long p3) {
        String string;
        if (p0 != p1) {
            if (p0 == p2) {
                String string2 = getString(R.string.verify_limit_amount_daily_max_reached_error);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                string = String.format(string2, Arrays.copyOf(new Object[]{Long.valueOf(p2)}, 1));
                Intrinsics.checkNotNullExpressionValue(string, "");
            } else if (p0 == p3) {
                String string3 = getString(R.string.verify_limit_amount_daily_min_reached_error);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                string = String.format(string3, Arrays.copyOf(new Object[]{Long.valueOf(p3)}, 1));
                Intrinsics.checkNotNullExpressionValue(string, "");
            }
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }
        string = getString(R.string.verify_limit_amount_daily_hint);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/fragment/CashierDailyLimitVerifyFragment$Companion;", "", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "p0", "Lid/dana/cashier/model/PayResultModel;", "p1", "Lid/dana/cashier/fragment/CashierDailyLimitVerifyFragment;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;Lid/dana/cashier/model/PayResultModel;)Lid/dana/cashier/fragment/CashierDailyLimitVerifyFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CashierDailyLimitVerifyFragment BuiltInFictitiousFunctionClassFactory(CashierPayMethodModel.CardPayMethod p0, PayResultModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            CashierDailyLimitVerifyFragment cashierDailyLimitVerifyFragment = new CashierDailyLimitVerifyFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CashierKeyParams.CASHIER_PAY_METHOD, p0);
            bundle.putParcelable(CashierKeyParams.PAY_RESULT_MODEL, p1);
            cashierDailyLimitVerifyFragment.setArguments(bundle);
            return cashierDailyLimitVerifyFragment;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierDailyLimitVerifyFragment cashierDailyLimitVerifyFragment, int i, int i2) {
        if (cashierDailyLimitVerifyFragment.getActivity() instanceof PayActivity) {
            Bundle bundle = new Bundle();
            PayResultModel payResultModel = ((BaseCashierRiskFragment) cashierDailyLimitVerifyFragment).BuiltInFictitiousFunctionClassFactory;
            String str = payResultModel != null ? payResultModel.getErrorConfigVersion : null;
            if (str == null) {
                str = "";
            }
            bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, str);
            bundle.putLong("limitAmountDaily", cashierDailyLimitVerifyFragment.C());
            bundle.putParcelable(CashierKeyParams.CASHIER_PAY_METHOD, cashierDailyLimitVerifyFragment.KClassImpl$Data$declaredNonStaticMembers$2);
            bundle.putInt("retrySendSeconds", i);
            bundle.putInt("otpCodeLength", i2);
            bundle.putParcelable(CashierKeyParams.PAY_RESULT_MODEL, ((BaseCashierRiskFragment) cashierDailyLimitVerifyFragment).BuiltInFictitiousFunctionClassFactory);
            bundle.putBoolean(CashierKeyParams.IS_VERIFY_BANK_PHONE_OTP, true);
            FragmentActivity activity = cashierDailyLimitVerifyFragment.getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                CashierOtpChallengeFragment.Companion companion = CashierOtpChallengeFragment.INSTANCE;
                PayActivity.addAndRemoveStackedFragment$default(payActivity, CashierOtpChallengeFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(bundle), false, false, 6, null);
            }
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, EditText editText) {
        if (charSequence.length() > 0) {
            StringBuilder sb = new StringBuilder(charSequence);
            if (i == 0 && charSequence.charAt(i) == '0') {
                sb.deleteCharAt(i);
                if (editText != null) {
                    editText.setText(sb.toString());
                }
                if (editText != null) {
                    editText.setSelection(i);
                }
            }
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierDailyLimitVerifyFragment cashierDailyLimitVerifyFragment) {
        VB vb = cashierDailyLimitVerifyFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierVerifyLimitAmountDailyBinding) vb).MyBillsEntityDataFactory.requestFocus();
            cashierDailyLimitVerifyFragment.getErrorConfigVersion();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ SendBankOtpModel BuiltInFictitiousFunctionClassFactory(CashierDailyLimitVerifyFragment cashierDailyLimitVerifyFragment, CashierPayMethodModel.CardPayMethod cardPayMethod, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        CashierPayMethodModel.NewCardData newCardData = cardPayMethod.getAuthRequestContext;
        String str6 = "";
        String str7 = ((newCardData == null || (str2 = newCardData.BuiltInFictitiousFunctionClassFactory) == null) && (str2 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) == null) ? "" : str2;
        CashierPayMethodModel.NewCardData newCardData2 = cardPayMethod.getAuthRequestContext;
        String str8 = ((newCardData2 == null || (str3 = newCardData2.MyBillsEntityDataFactory) == null) && (str3 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? "" : str3;
        CashierPayMethodModel.NewCardData newCardData3 = cardPayMethod.getAuthRequestContext;
        String str9 = ((newCardData3 == null || (str4 = newCardData3.getAuthRequestContext) == null) && (str4 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8) == null) ? "" : str4;
        CashierPayMethodModel.NewCardData newCardData4 = cardPayMethod.getAuthRequestContext;
        if (newCardData4 == null || (str5 = newCardData4.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            String str10 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested;
            if (str10 != null) {
                str6 = str10;
            }
        } else {
            str6 = str5;
        }
        return new SendBankOtpModel(str7, str, str8, null, null, null, null, null, str9, str6, String.valueOf(cashierDailyLimitVerifyFragment.C()), null, null, null, 14584, null);
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            DanaButtonSecondaryView danaButtonSecondaryView = ((FragmentCashierVerifyLimitAmountDailyBinding) vb).PlaceComponentResult;
            danaButtonSecondaryView.setEnabled(p0);
            if (p0) {
                danaButtonSecondaryView.setActiveButton(getString(R.string.intro_next), null);
                return;
            } else {
                danaButtonSecondaryView.setDisabled(getString(R.string.intro_next));
                return;
            }
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final long C() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            Editable text = ((FragmentCashierVerifyLimitAmountDailyBinding) vb).MyBillsEntityDataFactory.getText();
            String obj = text != null ? text.toString() : null;
            if (obj == null) {
                obj = "";
            }
            String cleanAll = NumberUtils.getCleanAll(new MoneyViewModel(obj, null, null, 6, null).PlaceComponentResult);
            if (cleanAll == null) {
                cleanAll = "0";
            }
            Long longOrNull = StringsKt.toLongOrNull(cleanAll);
            if (longOrNull != null) {
                return longOrNull.longValue();
            }
            return 0L;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, boolean p1) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            AppCompatTextView appCompatTextView = ((FragmentCashierVerifyLimitAmountDailyBinding) vb).BuiltInFictitiousFunctionClassFactory;
            appCompatTextView.setText(p0);
            AppCompatTextView appCompatTextView2 = appCompatTextView;
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(appCompatTextView2, p1 ? R.style.f49812132017435 : R.style.f49862132017440);
            TextViewCompat.MyBillsEntityDataFactory(appCompatTextView2, 0, 0, p1 ? R.drawable.ic_warning_16 : 0, 0);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void VerifyPinStateManager$executeRiskChallenge$2$1() {
        AssetCardModel assetCardModel;
        CashierPayMethodModel.CardPayMethod cardPayMethod = this.KClassImpl$Data$declaredNonStaticMembers$2;
        DailyLimitAmountConfModel dailyLimitAmountConfModel = (cardPayMethod == null || (assetCardModel = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel.moveToNextValue;
        if (dailyLimitAmountConfModel != null) {
            long C = C();
            long safeLong = NumberExtKt.toSafeLong(dailyLimitAmountConfModel.KClassImpl$Data$declaredNonStaticMembers$2, 0L);
            long safeLong2 = NumberExtKt.toSafeLong(dailyLimitAmountConfModel.MyBillsEntityDataFactory, 0L);
            long coerceIn = RangesKt.coerceIn(C, dailyLimitAmountConfModel.MyBillsEntityDataFactory());
            boolean z = coerceIn != C;
            String MyBillsEntityDataFactory = MyBillsEntityDataFactory(coerceIn, C, safeLong2, safeLong);
            MyBillsEntityDataFactory(!z);
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, z);
        }
    }

    @Override // id.dana.cashier.fragment.BaseVBCashierFragment
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCashierVerifyLimitAmountDailyBinding) vb).MyBillsEntityDataFactory.requestFocus();
            getErrorConfigVersion();
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                DanaTextBoxView danaTextBoxView = ((FragmentCashierVerifyLimitAmountDailyBinding) vb2).MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(danaTextBoxView, "");
                danaTextBoxView.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$setListener$$inlined$addTextChangedListener$default$1
                    @Override // android.text.TextWatcher
                    public final void afterTextChanged(Editable p0) {
                    }

                    @Override // android.text.TextWatcher
                    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    }

                    @Override // android.text.TextWatcher
                    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                        if (p0 != null) {
                            VB vb3 = CashierDailyLimitVerifyFragment.this.PlaceComponentResult;
                            if (vb3 != 0) {
                                CashierDailyLimitVerifyFragment.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, ((FragmentCashierVerifyLimitAmountDailyBinding) vb3).MyBillsEntityDataFactory);
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                        CashierDailyLimitVerifyFragment.this.VerifyPinStateManager$executeRiskChallenge$2$1();
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    DanaButtonSecondaryView danaButtonSecondaryView = ((FragmentCashierVerifyLimitAmountDailyBinding) vb3).PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
                    ThrottledOnClickListenerKt.PlaceComponentResult(danaButtonSecondaryView, new Function1<View, Unit>() { // from class: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$onClickNext$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
                        
                            r6 = r5.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
                         */
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void invoke2(android.view.View r6) {
                            /*
                                r5 = this;
                                java.lang.String r0 = ""
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                                boolean r6 = r6.isEnabled()
                                if (r6 != 0) goto Lc
                                return
                            Lc:
                                id.dana.cashier.fragment.CashierDailyLimitVerifyFragment r6 = id.dana.cashier.fragment.CashierDailyLimitVerifyFragment.this
                                id.dana.cashier.model.CashierPayMethodModel$CardPayMethod r6 = id.dana.cashier.fragment.CashierDailyLimitVerifyFragment.MyBillsEntityDataFactory(r6)
                                if (r6 == 0) goto L31
                                id.dana.cashier.fragment.CashierDailyLimitVerifyFragment r1 = id.dana.cashier.fragment.CashierDailyLimitVerifyFragment.this
                                id.dana.cashier.presenter.CashierRiskChallengePresenter r2 = r1.cashierRiskChallengePresenter
                                r3 = 0
                                if (r2 == 0) goto L1c
                                goto L20
                            L1c:
                                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                                r2 = r3
                            L20:
                                id.dana.cashier.model.PayResultModel r4 = r1.BuiltInFictitiousFunctionClassFactory
                                if (r4 == 0) goto L26
                                java.lang.String r3 = r4.getErrorConfigVersion
                            L26:
                                if (r3 != 0) goto L29
                                goto L2a
                            L29:
                                r0 = r3
                            L2a:
                                id.dana.cashier.model.SendBankOtpModel r6 = id.dana.cashier.fragment.CashierDailyLimitVerifyFragment.BuiltInFictitiousFunctionClassFactory(r1, r6, r0)
                                r2.PlaceComponentResult(r6)
                            L31:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.CashierDailyLimitVerifyFragment$onClickNext$1.invoke2(android.view.View):void");
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

    @Override // id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.initRecordTimeStamp.clear();
    }
}
