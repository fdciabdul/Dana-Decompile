package id.dana.challenge.verifypush;

import dagger.internal.Factory;
import id.dana.challenge.verifypush.VerifyPushContract;
import id.dana.domain.featureconfig.interactor.GetTwilioTimeoutConfig;
import id.dana.domain.login.interactor.VerifyPushLogin;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyPushLoginPresenter_Factory implements Factory<VerifyPushLoginPresenter> {
    private final Provider<VerifyPushLogin> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetTwilioTimeoutConfig> MyBillsEntityDataFactory;
    private final Provider<VerifyPushContract.View> PlaceComponentResult;
    private final Provider<TwilioRequestChallenge> getAuthRequestContext;

    private VerifyPushLoginPresenter_Factory(Provider<VerifyPushContract.View> provider, Provider<GetTwilioTimeoutConfig> provider2, Provider<TwilioRequestChallenge> provider3, Provider<VerifyPushLogin> provider4) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static VerifyPushLoginPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<VerifyPushContract.View> provider, Provider<GetTwilioTimeoutConfig> provider2, Provider<TwilioRequestChallenge> provider3, Provider<VerifyPushLogin> provider4) {
        return new VerifyPushLoginPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerifyPushLoginPresenter(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
