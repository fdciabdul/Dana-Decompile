package id.dana.twilio.onboarding;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.twilio.interactor.CreateTwilioFactor;
import id.dana.domain.twilio.interactor.DeleteTwilioLocalFactor;
import id.dana.domain.twilio.interactor.TwilioBindEnrollment;
import id.dana.domain.twilio.interactor.TwilioConsultEnrollment;
import id.dana.domain.twilio.interactor.TwilioEnrollment;
import id.dana.domain.twilio.interactor.VerifyTwilioFactor;
import id.dana.twilio.onboarding.TwilioIntroductionContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class TwilioIntroductionPresenter_Factory implements Factory<TwilioIntroductionPresenter> {
    private final Provider<DeleteTwilioLocalFactor> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CreateTwilioFactor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<TwilioEnrollment> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<TwilioBindEnrollment> PlaceComponentResult;
    private final Provider<CheckTwilioEnrollmentStatus> getAuthRequestContext;
    private final Provider<TwilioConsultEnrollment> getErrorConfigVersion;
    private final Provider<VerifyTwilioFactor> lookAheadTest;
    private final Provider<TwilioIntroductionContract.View> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TwilioIntroductionPresenter(this.MyBillsEntityDataFactory.get(), this.scheduleImpl.get(), this.getErrorConfigVersion.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.lookAheadTest.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
