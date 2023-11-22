package id.dana.challenge.otp;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.domain.otp.interactor.ReceiveOtp;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OtpTwilioPresenter_Factory implements Factory<OtpTwilioPresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<TwilioVerifySecurityProduct> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AbstractOtpContract.View> MyBillsEntityDataFactory;
    private final Provider<SendOtp> PlaceComponentResult;
    private final Provider<ReceiveOtp> getAuthRequestContext;

    private OtpTwilioPresenter_Factory(Provider<Context> provider, Provider<AbstractOtpContract.View> provider2, Provider<SendOtp> provider3, Provider<TwilioVerifySecurityProduct> provider4, Provider<ReceiveOtp> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static OtpTwilioPresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<AbstractOtpContract.View> provider2, Provider<SendOtp> provider3, Provider<TwilioVerifySecurityProduct> provider4, Provider<ReceiveOtp> provider5) {
        return new OtpTwilioPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OtpTwilioPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
