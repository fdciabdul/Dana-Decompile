package id.dana.twilio.identityverification;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.twilio.interactor.GetTwilioChallengeDetails;
import id.dana.domain.twilio.interactor.IsTwilioForceLogout;
import id.dana.domain.twilio.interactor.UpdateTwilioChallenge;
import id.dana.twilio.identityverification.TwilioIdentityVerificationContract;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class TwilioIdentityVerificationPresenter_Factory implements Factory<TwilioIdentityVerificationPresenter> {
    private final Provider<IsTwilioForceLogout> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UpdateTwilioChallenge> MyBillsEntityDataFactory;
    private final Provider<TwilioMixpanelTracker> PlaceComponentResult;
    private final Provider<GetTwilioChallengeDetails> getAuthRequestContext;
    private final Provider<TwilioIdentityVerificationContract.View> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TwilioIdentityVerificationPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.scheduleImpl.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
