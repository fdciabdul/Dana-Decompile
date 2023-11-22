package id.dana.cashier.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.cashier.CashierRiskChallengeContract;
import id.dana.cashier.domain.interactor.CreateCashierAgreement;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.otp.interactor.ReceiveSms;
import id.dana.domain.otp.interactor.SendBankOtp;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.otp.interactor.VerifyOtpOneKlik;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CashierRiskChallengePresenter_Factory implements Factory<CashierRiskChallengePresenter> {
    private final Provider<ReceiveSms> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SendBankOtp> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<DeviceInformationProvider> PlaceComponentResult;
    private final Provider<CreateCashierAgreement> getAuthRequestContext;
    private final Provider<CashierRiskChallengeContract.View> getErrorConfigVersion;
    private final Provider<SendOtp> lookAheadTest;
    private final Provider<VerifyOtpOneKlik> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CashierRiskChallengePresenter(this.MyBillsEntityDataFactory.get(), this.getErrorConfigVersion.get(), this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.scheduleImpl.get(), this.PlaceComponentResult.get());
    }
}
