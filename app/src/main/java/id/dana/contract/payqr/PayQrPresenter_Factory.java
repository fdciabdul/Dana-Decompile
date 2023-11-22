package id.dana.contract.payqr;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.payqr.PayQrContract;
import id.dana.domain.featureconfig.interactor.IsCashierEntryPointEnabled;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.offlinepay.interactor.SetSeedExtra;
import id.dana.domain.qrpay.interactor.GetOtpInitResult;
import id.dana.domain.qrpay.interactor.GetPaymentCode;
import id.dana.domain.qrpay.interactor.GetQrisPaymentData;
import id.dana.domain.qrpay.interactor.IsQrisEnable;
import id.dana.domain.qrpay.interactor.PauseOfflinePay;
import id.dana.domain.qrpay.interactor.RestartOfflinePay;
import id.dana.domain.qrpay.interactor.StartOfflinePay;
import id.dana.domain.qrpay.interactor.StopOfflinePay;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayQrPresenter_Factory implements Factory<PayQrPresenter> {
    private final Provider<IsCashierEntryPointEnabled> BuiltInFictitiousFunctionClassFactory;
    private final Provider<StopOfflinePay> GetContactSyncConfig;
    private final Provider<GetOtpInitResult> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetQrisPaymentData> MyBillsEntityDataFactory;
    private final Provider<PauseOfflinePay> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<PayQrContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<IsOfflineF2FPay> PlaceComponentResult;
    private final Provider<GetPaymentCode> getAuthRequestContext;
    private final Provider<RestartOfflinePay> getErrorConfigVersion;
    private final Provider<IsQrisEnable> lookAheadTest;
    private final Provider<StartOfflinePay> moveToNextValue;
    private final Provider<SetSeedExtra> scheduleImpl;

    private PayQrPresenter_Factory(Provider<PayQrContract.View> provider, Provider<SetSeedExtra> provider2, Provider<GetOtpInitResult> provider3, Provider<IsQrisEnable> provider4, Provider<IsCashierEntryPointEnabled> provider5, Provider<GetPaymentCode> provider6, Provider<GetQrisPaymentData> provider7, Provider<StartOfflinePay> provider8, Provider<StopOfflinePay> provider9, Provider<PauseOfflinePay> provider10, Provider<RestartOfflinePay> provider11, Provider<IsOfflineF2FPay> provider12) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider;
        this.scheduleImpl = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.lookAheadTest = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.getAuthRequestContext = provider6;
        this.MyBillsEntityDataFactory = provider7;
        this.moveToNextValue = provider8;
        this.GetContactSyncConfig = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider10;
        this.getErrorConfigVersion = provider11;
        this.PlaceComponentResult = provider12;
    }

    public static PayQrPresenter_Factory PlaceComponentResult(Provider<PayQrContract.View> provider, Provider<SetSeedExtra> provider2, Provider<GetOtpInitResult> provider3, Provider<IsQrisEnable> provider4, Provider<IsCashierEntryPointEnabled> provider5, Provider<GetPaymentCode> provider6, Provider<GetQrisPaymentData> provider7, Provider<StartOfflinePay> provider8, Provider<StopOfflinePay> provider9, Provider<PauseOfflinePay> provider10, Provider<RestartOfflinePay> provider11, Provider<IsOfflineF2FPay> provider12) {
        return new PayQrPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        PayQrPresenter payQrPresenter = new PayQrPresenter(DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
        PayQrPresenter_MembersInjector.PlaceComponentResult(payQrPresenter, DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
        PayQrPresenter_MembersInjector.PlaceComponentResult(payQrPresenter, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
        return payQrPresenter;
    }
}
