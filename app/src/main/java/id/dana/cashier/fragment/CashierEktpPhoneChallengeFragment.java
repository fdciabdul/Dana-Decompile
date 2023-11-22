package id.dana.cashier.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.R;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.extension.view.InputExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\t"}, d2 = {"Lid/dana/cashier/fragment/CashierEktpPhoneChallengeFragment;", "Lid/dana/cashier/fragment/CashierPhoneChallengeFragment;", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "p0", "Lid/dana/cashier/model/SendBankOtpModel;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;)Lid/dana/cashier/model/SendBankOtpModel;", "", "NetworkUserEntityData$$ExternalSyntheticLambda4", "()V", "", LogConstants.RESULT_FALSE, "()Z", "C", "VerifyPinStateManager$executeRiskChallenge$2$1", DiskFormatter.B, "BottomSheetCardBindingView$watcherCardNumberView$1", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierEktpPhoneChallengeFragment extends CashierPhoneChallengeFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> GetContactSyncConfig = new LinkedHashMap();

    @Override // id.dana.cashier.fragment.CashierPhoneChallengeFragment, id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.GetContactSyncConfig;
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

    @Override // id.dana.cashier.fragment.CashierPhoneChallengeFragment, id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.GetContactSyncConfig.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.CashierPhoneChallengeFragment, id.dana.cashier.fragment.BaseVBCashierFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        super.NetworkUserEntityData$$ExternalSyntheticLambda4();
        AppCompatEditText appCompatEditText = (AppCompatEditText) getAuthRequestContext(R.id.getHashMap);
        if (appCompatEditText != null) {
            appCompatEditText.setImeOptions(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.CashierPhoneChallengeFragment
    public final void B() {
        super.B();
        Group group = (Group) getAuthRequestContext(R.id.groupEktp);
        if (group != null) {
            group.setVisibility(0);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) getAuthRequestContext(R.id.MobileInStorePaymentInitInfo);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.CashierPhoneChallengeFragment
    public final void VerifyPinStateManager$executeRiskChallenge$2$1() {
        super.VerifyPinStateManager$executeRiskChallenge$2$1();
        AppCompatEditText appCompatEditText = (AppCompatEditText) getAuthRequestContext(R.id.getHashMap);
        if (appCompatEditText != null) {
            appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.fragment.CashierEktpPhoneChallengeFragment$setEktpInputListener$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) CashierEktpPhoneChallengeFragment.this.getAuthRequestContext(R.id.res_0x7f0a097a_r8_lambda_41qq6licic8qk_sjz7rcr6ft7na);
                    if (appCompatImageView != null) {
                        appCompatImageView.setVisibility((p0 != null ? p0.length() : 0) > 0 ? 0 : 8);
                    }
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    boolean F;
                    CashierEktpPhoneChallengeFragment.this.BottomSheetCardBindingView$watcherCardNumberView$1();
                    CashierEktpPhoneChallengeFragment cashierEktpPhoneChallengeFragment = CashierEktpPhoneChallengeFragment.this;
                    String string = cashierEktpPhoneChallengeFragment.getString(R.string.invalid_ktp_number);
                    F = CashierEktpPhoneChallengeFragment.this.F();
                    CashierEktpPhoneChallengeFragment.MyBillsEntityDataFactory(cashierEktpPhoneChallengeFragment, string, !F);
                }
            });
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) getAuthRequestContext(R.id.res_0x7f0a097a_r8_lambda_41qq6licic8qk_sjz7rcr6ft7na);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.CashierEktpPhoneChallengeFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierEktpPhoneChallengeFragment.BuiltInFictitiousFunctionClassFactory(CashierEktpPhoneChallengeFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.CashierPhoneChallengeFragment
    public final void C() {
        AppCompatEditText appCompatEditText = (AppCompatEditText) getAuthRequestContext(R.id.getHashMap);
        if (appCompatEditText != null) {
            getAuthRequestContext(appCompatEditText);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.CashierPhoneChallengeFragment
    public final void BottomSheetCardBindingView$watcherCardNumberView$1() {
        MyBillsEntityDataFactory(F() && VerifyPinStateManager$executeRiskChallenge$2$2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F() {
        AppCompatEditText appCompatEditText = (AppCompatEditText) getAuthRequestContext(R.id.getHashMap);
        return appCompatEditText != null && appCompatEditText.length() == 16;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/fragment/CashierEktpPhoneChallengeFragment$Companion;", "", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "p0", "Lid/dana/cashier/model/PayResultModel;", "p1", "Lid/dana/cashier/fragment/CashierEktpPhoneChallengeFragment;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;Lid/dana/cashier/model/PayResultModel;)Lid/dana/cashier/fragment/CashierEktpPhoneChallengeFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static CashierEktpPhoneChallengeFragment MyBillsEntityDataFactory(CashierPayMethodModel.CardPayMethod p0, PayResultModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            CashierEktpPhoneChallengeFragment cashierEktpPhoneChallengeFragment = new CashierEktpPhoneChallengeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CashierKeyParams.CASHIER_PAY_METHOD, p0);
            bundle.putParcelable(CashierKeyParams.PAY_RESULT_MODEL, p1);
            cashierEktpPhoneChallengeFragment.setArguments(bundle);
            return cashierEktpPhoneChallengeFragment;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierEktpPhoneChallengeFragment cashierEktpPhoneChallengeFragment) {
        Intrinsics.checkNotNullParameter(cashierEktpPhoneChallengeFragment, "");
        AppCompatEditText appCompatEditText = (AppCompatEditText) cashierEktpPhoneChallengeFragment.getAuthRequestContext(R.id.getHashMap);
        if (appCompatEditText != null) {
            InputExtKt.MyBillsEntityDataFactory(appCompatEditText);
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierEktpPhoneChallengeFragment cashierEktpPhoneChallengeFragment, String str, boolean z) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) cashierEktpPhoneChallengeFragment.getAuthRequestContext(R.id.MobileInStorePaymentInitInfo);
        if (appCompatTextView != null) {
            if (str == null) {
                str = "";
            }
            appCompatTextView.setText(str);
            appCompatTextView.setVisibility(z ^ true ? 4 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.cashier.fragment.CashierPhoneChallengeFragment
    public final SendBankOtpModel MyBillsEntityDataFactory(CashierPayMethodModel.CardPayMethod p0) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(p0, "");
        PayResultModel payResultModel = ((BaseCashierRiskFragment) this).BuiltInFictitiousFunctionClassFactory;
        String str6 = payResultModel != null ? payResultModel.getErrorConfigVersion : null;
        String str7 = str6 == null ? "" : str6;
        String D = D();
        CashierPayMethodModel.NewCardData newCardData = p0.getAuthRequestContext;
        if (newCardData == null || (str = newCardData.MyBillsEntityDataFactory) == null) {
            str = p0.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        String str8 = str;
        CashierPayMethodModel.NewCardData newCardData2 = p0.getAuthRequestContext;
        if (newCardData2 == null || (str2 = newCardData2.BuiltInFictitiousFunctionClassFactory) == null) {
            str2 = p0.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl;
        }
        String str9 = str2;
        CashierPayMethodModel.NewCardData newCardData3 = p0.getAuthRequestContext;
        String str10 = ((newCardData3 == null || (str3 = newCardData3.getAuthRequestContext) == null) && (str3 = p0.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8) == null) ? "" : str3;
        CashierPayMethodModel.NewCardData newCardData4 = p0.getAuthRequestContext;
        if (newCardData4 == null || (str5 = newCardData4.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            String str11 = p0.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested;
            str4 = str11 == null ? "" : str11;
        } else {
            str4 = str5;
        }
        Editable text = ((AppCompatEditText) getAuthRequestContext(R.id.getHashMap)).getText();
        String obj = text != null ? text.toString() : null;
        return new SendBankOtpModel(str9, str7, str8, D, obj == null ? "" : obj, null, null, null, str10, str4, null, null, null, null, 15584, null);
    }

    @Override // id.dana.cashier.fragment.CashierPhoneChallengeFragment, id.dana.cashier.fragment.BaseCashierRiskFragment, id.dana.cashier.fragment.BaseVBCashierFragment, id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.GetContactSyncConfig.clear();
    }
}
