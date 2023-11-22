package id.dana.twilio.trusteddevice;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetTwilioManualCheckConfig;
import id.dana.domain.twilio.interactor.CheckPendingChallenge;
import id.dana.domain.twilio.interactor.DeleteTwilioLocalFactor;
import id.dana.domain.twilio.interactor.SubmitTwilioDeroll;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.twilio.trusteddevice.TrustedDeviceContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TrustedDevicePresenter_Factory implements Factory<TrustedDevicePresenter> {
    private final Provider<GetTwilioManualCheckConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckPendingChallenge> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetUserInfo> MyBillsEntityDataFactory;
    private final Provider<DeleteTwilioLocalFactor> PlaceComponentResult;
    private final Provider<SubmitTwilioDeroll> getAuthRequestContext;
    private final Provider<TrustedDeviceContract.View> getErrorConfigVersion;

    private TrustedDevicePresenter_Factory(Provider<TrustedDeviceContract.View> provider, Provider<GetUserInfo> provider2, Provider<GetTwilioManualCheckConfig> provider3, Provider<SubmitTwilioDeroll> provider4, Provider<DeleteTwilioLocalFactor> provider5, Provider<CheckPendingChallenge> provider6) {
        this.getErrorConfigVersion = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.getAuthRequestContext = provider4;
        this.PlaceComponentResult = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
    }

    public static TrustedDevicePresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<TrustedDeviceContract.View> provider, Provider<GetUserInfo> provider2, Provider<GetTwilioManualCheckConfig> provider3, Provider<SubmitTwilioDeroll> provider4, Provider<DeleteTwilioLocalFactor> provider5, Provider<CheckPendingChallenge> provider6) {
        return new TrustedDevicePresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TrustedDevicePresenter(this.getErrorConfigVersion.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
