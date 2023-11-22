package id.dana.cardbinding.viewmodel;

import android.app.Application;
import dagger.internal.Factory;
import id.dana.cashier.domain.interactor.CreateCashierAgreementFlow;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.otp.interactor.ReceiveSmsFlow;
import id.dana.domain.otp.interactor.SendBankOtpFlow;
import id.dana.domain.otp.interactor.SendOtpFlow;
import id.dana.domain.otp.interactor.VerifyOtpOneKlikFlow;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OtpCardBindingViewModel_Factory implements Factory<OtpCardBindingViewModel> {
    private final Provider<DeviceInformationProvider> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SendBankOtpFlow> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ReceiveSmsFlow> MyBillsEntityDataFactory;
    private final Provider<Application> PlaceComponentResult;
    private final Provider<CreateCashierAgreementFlow> getAuthRequestContext;
    private final Provider<SendOtpFlow> lookAheadTest;
    private final Provider<VerifyOtpOneKlikFlow> scheduleImpl;

    private OtpCardBindingViewModel_Factory(Provider<Application> provider, Provider<CreateCashierAgreementFlow> provider2, Provider<SendOtpFlow> provider3, Provider<SendBankOtpFlow> provider4, Provider<ReceiveSmsFlow> provider5, Provider<VerifyOtpOneKlikFlow> provider6, Provider<DeviceInformationProvider> provider7) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.lookAheadTest = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.scheduleImpl = provider6;
        this.BuiltInFictitiousFunctionClassFactory = provider7;
    }

    public static OtpCardBindingViewModel_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Application> provider, Provider<CreateCashierAgreementFlow> provider2, Provider<SendOtpFlow> provider3, Provider<SendBankOtpFlow> provider4, Provider<ReceiveSmsFlow> provider5, Provider<VerifyOtpOneKlikFlow> provider6, Provider<DeviceInformationProvider> provider7) {
        return new OtpCardBindingViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OtpCardBindingViewModel(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.scheduleImpl.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
