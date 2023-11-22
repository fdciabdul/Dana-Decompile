package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.challenge.pin.PinAuthAgreementPresenter;
import id.dana.challenge.pin.PinLoginPresenter;
import id.dana.challenge.pin.PinPaymentAuthPresenter;
import id.dana.challenge.pin.PinSwitchAutoRoutePresenter;
import id.dana.challenge.pin.PinSwitchFaceAuthPresenter;
import id.dana.challenge.pin.PinTwilioPresenter;
import id.dana.challenge.pin.presenter.PinCardBindingPresenter;
import id.dana.challenge.pin.presenter.PinFamilyAccountPresenter;
import id.dana.challenge.pin.presenter.PinUnbindMerchantPresenter;
import id.dana.challenge.pin.presenter.PinWalletPersonalKtpPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinChallengeModule_ProvidePresenterFactory implements Factory<AbstractPinContract.Presenter> {
    private final Provider<PinCardBindingPresenter> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PinFamilyAccountPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final PinChallengeModule MyBillsEntityDataFactory;
    private final Provider<PinUnbindMerchantPresenter> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<PinWalletPersonalKtpPresenter> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<PinLoginPresenter> PlaceComponentResult;
    private final Provider<PinAuthAgreementPresenter> getAuthRequestContext;
    private final Provider<PinSwitchAutoRoutePresenter> getErrorConfigVersion;
    private final Provider<PinTwilioPresenter> lookAheadTest;
    private final Provider<PinPaymentAuthPresenter> moveToNextValue;
    private final Provider<PinSwitchFaceAuthPresenter> scheduleImpl;

    private PinChallengeModule_ProvidePresenterFactory(PinChallengeModule pinChallengeModule, Provider<PinLoginPresenter> provider, Provider<PinPaymentAuthPresenter> provider2, Provider<PinSwitchFaceAuthPresenter> provider3, Provider<PinUnbindMerchantPresenter> provider4, Provider<PinTwilioPresenter> provider5, Provider<PinSwitchAutoRoutePresenter> provider6, Provider<PinAuthAgreementPresenter> provider7, Provider<PinFamilyAccountPresenter> provider8, Provider<PinWalletPersonalKtpPresenter> provider9, Provider<PinCardBindingPresenter> provider10) {
        this.MyBillsEntityDataFactory = pinChallengeModule;
        this.PlaceComponentResult = provider;
        this.moveToNextValue = provider2;
        this.scheduleImpl = provider3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider4;
        this.lookAheadTest = provider5;
        this.getErrorConfigVersion = provider6;
        this.getAuthRequestContext = provider7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider9;
        this.BuiltInFictitiousFunctionClassFactory = provider10;
    }

    public static PinChallengeModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(PinChallengeModule pinChallengeModule, Provider<PinLoginPresenter> provider, Provider<PinPaymentAuthPresenter> provider2, Provider<PinSwitchFaceAuthPresenter> provider3, Provider<PinUnbindMerchantPresenter> provider4, Provider<PinTwilioPresenter> provider5, Provider<PinSwitchAutoRoutePresenter> provider6, Provider<PinAuthAgreementPresenter> provider7, Provider<PinFamilyAccountPresenter> provider8, Provider<PinWalletPersonalKtpPresenter> provider9, Provider<PinCardBindingPresenter> provider10) {
        return new PinChallengeModule_ProvidePresenterFactory(pinChallengeModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AbstractPinContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get(), this.moveToNextValue.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.lookAheadTest.get(), this.getErrorConfigVersion.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
