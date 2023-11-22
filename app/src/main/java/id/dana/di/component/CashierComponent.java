package id.dana.di.component;

import dagger.Component;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.fragment.AddNewCardCashierFragment;
import id.dana.cashier.fragment.CashierCvvChallengeFragment;
import id.dana.cashier.fragment.CashierDailyLimitVerifyFragment;
import id.dana.cashier.fragment.CashierGeneralProcessingFragment;
import id.dana.cashier.fragment.CashierOneKlikChallengeFragment;
import id.dana.cashier.fragment.CashierOtpChallengeFragment;
import id.dana.cashier.fragment.CashierPhoneChallengeFragment;
import id.dana.cashier.fragment.CashierPinChallengeFragment;
import id.dana.cashier.fragment.CashierPromoSelectionFragment;
import id.dana.cashier.fragment.CashierVerifyElementsChallengeFragment;
import id.dana.cashier.fragment.InputAmountFragment;
import id.dana.cashier.fragment.PayConfirmationFragment;
import id.dana.cashier.fragment.PaylaterInstallmentFragment;
import id.dana.di.PerActivity;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.PaylaterAnalyticModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.expresspurchase.di.ExpressPurchaseModule;
import id.dana.pay.PayActivity;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {CashierModule.class, CashierRiskChallengeModule.class, ExpressPurchaseModule.class, CashierAnalyticModule.class, TopUpAndPayModule.class, FaceAuthenticationModule.class, PaylaterAnalyticModule.class, CashierCardBindingModule.class, CashierPayLaterModule.class, CashierAddOnModule.class, CashierUserRelatedModule.class, CashierHighlightModule.class})
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0012H&¢\u0006\u0004\b\b\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0017H&¢\u0006\u0004\b\u0010\u0010\u0018J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0019H&¢\u0006\u0004\b\u0015\u0010\u001aJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001bH&¢\u0006\u0004\b\u0015\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001dH&¢\u0006\u0004\b\u0005\u0010\u001eJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001fH&¢\u0006\u0004\b\r\u0010 J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!H&¢\u0006\u0004\b\u0015\u0010\"J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020#H&¢\u0006\u0004\b\b\u0010$ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/CashierComponent;", "", "Lid/dana/cashier/fragment/AddNewCardCashierFragment;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/fragment/AddNewCardCashierFragment;)V", "Lid/dana/cashier/fragment/CashierCvvChallengeFragment;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/fragment/CashierCvvChallengeFragment;)V", "Lid/dana/cashier/fragment/CashierDailyLimitVerifyFragment;", "(Lid/dana/cashier/fragment/CashierDailyLimitVerifyFragment;)V", "Lid/dana/cashier/fragment/CashierGeneralProcessingFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/fragment/CashierGeneralProcessingFragment;)V", "Lid/dana/cashier/fragment/CashierOneKlikChallengeFragment;", "PlaceComponentResult", "(Lid/dana/cashier/fragment/CashierOneKlikChallengeFragment;)V", "Lid/dana/cashier/fragment/CashierOtpChallengeFragment;", "(Lid/dana/cashier/fragment/CashierOtpChallengeFragment;)V", "Lid/dana/cashier/fragment/CashierPhoneChallengeFragment;", "getAuthRequestContext", "(Lid/dana/cashier/fragment/CashierPhoneChallengeFragment;)V", "Lid/dana/cashier/fragment/CashierPinChallengeFragment;", "(Lid/dana/cashier/fragment/CashierPinChallengeFragment;)V", "Lid/dana/cashier/fragment/CashierPromoSelectionFragment;", "(Lid/dana/cashier/fragment/CashierPromoSelectionFragment;)V", "Lid/dana/cashier/fragment/CashierVerifyElementsChallengeFragment;", "(Lid/dana/cashier/fragment/CashierVerifyElementsChallengeFragment;)V", "Lid/dana/cashier/fragment/InputAmountFragment;", "(Lid/dana/cashier/fragment/InputAmountFragment;)V", "Lid/dana/cashier/fragment/PayConfirmationFragment;", "(Lid/dana/cashier/fragment/PayConfirmationFragment;)V", "Lid/dana/cashier/fragment/PaylaterInstallmentFragment;", "(Lid/dana/cashier/fragment/PaylaterInstallmentFragment;)V", "Lid/dana/pay/PayActivity;", "(Lid/dana/pay/PayActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public interface CashierComponent {
    void BuiltInFictitiousFunctionClassFactory(AddNewCardCashierFragment p0);

    void BuiltInFictitiousFunctionClassFactory(InputAmountFragment p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(CashierGeneralProcessingFragment p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(PayConfirmationFragment p0);

    void MyBillsEntityDataFactory(CashierCvvChallengeFragment p0);

    void MyBillsEntityDataFactory(CashierDailyLimitVerifyFragment p0);

    void MyBillsEntityDataFactory(CashierOtpChallengeFragment p0);

    void MyBillsEntityDataFactory(PayActivity p0);

    void PlaceComponentResult(CashierOneKlikChallengeFragment p0);

    void PlaceComponentResult(CashierPinChallengeFragment p0);

    void getAuthRequestContext(CashierPhoneChallengeFragment p0);

    void getAuthRequestContext(CashierPromoSelectionFragment p0);

    void getAuthRequestContext(CashierVerifyElementsChallengeFragment p0);

    void getAuthRequestContext(PaylaterInstallmentFragment p0);
}
