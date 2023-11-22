package id.dana.challenge.otp;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.domain.featureconfig.interactor.CheckResendWhatsAppEnable;
import id.dana.domain.otp.interactor.ReceiveOtp;
import id.dana.domain.otp.interactor.VerifyOtp;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import id.dana.domain.registration.interactor.GetNumberOfRequestOtp;
import id.dana.domain.registration.interactor.RemoveNumberOfRequestOtp;
import id.dana.domain.registration.interactor.ResendOtp;
import id.dana.domain.registration.interactor.SaveIsFreezeVerifyOtp;
import id.dana.domain.registration.interactor.SaveNumberOfRequestOtp;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OtpRegistrationPresenter_Factory implements Factory<OtpRegistrationPresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AbstractOtpContract.View> DatabaseTableConfigUtil;
    private final Provider<CheckResendWhatsAppEnable> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetNumberOfRequestOtp> MyBillsEntityDataFactory;
    private final Provider<SaveIsFreezeVerifyOtp> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<VerifyOtpRisk> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<ReceiveOtp> PlaceComponentResult;
    private final Provider<RegistrationTracker> getAuthRequestContext;
    private final Provider<RemoveNumberOfRequestOtp> getErrorConfigVersion;
    private final Provider<SaveNumberOfRequestOtp> lookAheadTest;
    private final Provider<ResendOtp> moveToNextValue;
    private final Provider<VerifyOtp> scheduleImpl;

    private OtpRegistrationPresenter_Factory(Provider<Context> provider, Provider<AbstractOtpContract.View> provider2, Provider<VerifyOtp> provider3, Provider<VerifyOtpRisk> provider4, Provider<ResendOtp> provider5, Provider<ReceiveOtp> provider6, Provider<CheckResendWhatsAppEnable> provider7, Provider<GetNumberOfRequestOtp> provider8, Provider<SaveNumberOfRequestOtp> provider9, Provider<RemoveNumberOfRequestOtp> provider10, Provider<SaveIsFreezeVerifyOtp> provider11, Provider<RegistrationTracker> provider12) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.DatabaseTableConfigUtil = provider2;
        this.scheduleImpl = provider3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider4;
        this.moveToNextValue = provider5;
        this.PlaceComponentResult = provider6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider7;
        this.MyBillsEntityDataFactory = provider8;
        this.lookAheadTest = provider9;
        this.getErrorConfigVersion = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider11;
        this.getAuthRequestContext = provider12;
    }

    public static OtpRegistrationPresenter_Factory getAuthRequestContext(Provider<Context> provider, Provider<AbstractOtpContract.View> provider2, Provider<VerifyOtp> provider3, Provider<VerifyOtpRisk> provider4, Provider<ResendOtp> provider5, Provider<ReceiveOtp> provider6, Provider<CheckResendWhatsAppEnable> provider7, Provider<GetNumberOfRequestOtp> provider8, Provider<SaveNumberOfRequestOtp> provider9, Provider<RemoveNumberOfRequestOtp> provider10, Provider<SaveIsFreezeVerifyOtp> provider11, Provider<RegistrationTracker> provider12) {
        return new OtpRegistrationPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OtpRegistrationPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.DatabaseTableConfigUtil.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.moveToNextValue.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.lookAheadTest.get(), this.getErrorConfigVersion.get(), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
