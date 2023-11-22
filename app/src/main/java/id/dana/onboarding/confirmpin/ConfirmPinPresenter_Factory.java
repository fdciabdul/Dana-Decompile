package id.dana.onboarding.confirmpin;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.featureconfig.interactor.GetAuthenticationTypeFeature;
import id.dana.domain.registration.interactor.CreateProfile;
import id.dana.onboarding.confirmpin.ConfirmPinContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ConfirmPinPresenter_Factory implements Factory<ConfirmPinPresenter> {
    private final Provider<GetAuthenticationTypeFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeviceInformationProvider> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CreateProfile> MyBillsEntityDataFactory;
    private final Provider<GetUserId> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;
    private final Provider<ConfirmPinContract.View> lookAheadTest;
    private final Provider<RegistrationTracker> scheduleImpl;

    private ConfirmPinPresenter_Factory(Provider<Context> provider, Provider<ConfirmPinContract.View> provider2, Provider<CreateProfile> provider3, Provider<DeviceInformationProvider> provider4, Provider<GetUserId> provider5, Provider<GetAuthenticationTypeFeature> provider6, Provider<RegistrationTracker> provider7) {
        this.getAuthRequestContext = provider;
        this.lookAheadTest = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.PlaceComponentResult = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.scheduleImpl = provider7;
    }

    public static ConfirmPinPresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<ConfirmPinContract.View> provider2, Provider<CreateProfile> provider3, Provider<DeviceInformationProvider> provider4, Provider<GetUserId> provider5, Provider<GetAuthenticationTypeFeature> provider6, Provider<RegistrationTracker> provider7) {
        return new ConfirmPinPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ConfirmPinPresenter(this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl));
    }
}
