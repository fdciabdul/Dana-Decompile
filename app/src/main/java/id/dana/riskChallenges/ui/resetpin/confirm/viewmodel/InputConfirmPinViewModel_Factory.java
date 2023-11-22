package id.dana.riskChallenges.ui.resetpin.confirm.viewmodel;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.createpin.InputConfirmPinTrackerImpl;
import id.dana.domain.resetpin.interactor.SelfUnfreeze;
import id.dana.riskChallenges.domain.forgetpassword.interactor.ResetPassword;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InputConfirmPinViewModel_Factory implements Factory<InputConfirmPinViewModel> {
    private final Provider<ResetPassword> MyBillsEntityDataFactory;
    private final Provider<InputConfirmPinTrackerImpl> PlaceComponentResult;
    private final Provider<SelfUnfreeze> getAuthRequestContext;

    private InputConfirmPinViewModel_Factory(Provider<ResetPassword> provider, Provider<InputConfirmPinTrackerImpl> provider2, Provider<SelfUnfreeze> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static InputConfirmPinViewModel_Factory BuiltInFictitiousFunctionClassFactory(Provider<ResetPassword> provider, Provider<InputConfirmPinTrackerImpl> provider2, Provider<SelfUnfreeze> provider3) {
        return new InputConfirmPinViewModel_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InputConfirmPinViewModel(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
