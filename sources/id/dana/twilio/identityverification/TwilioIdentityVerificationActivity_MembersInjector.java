package id.dana.twilio.identityverification;

import dagger.MembersInjector;
import id.dana.challenge.pin.LogoutContract;

/* loaded from: classes5.dex */
public final class TwilioIdentityVerificationActivity_MembersInjector implements MembersInjector<TwilioIdentityVerificationActivity> {
    public static void MyBillsEntityDataFactory(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, TwilioIdentityVerificationPresenter twilioIdentityVerificationPresenter) {
        twilioIdentityVerificationActivity.twilioIdentityVerificationPresenter = twilioIdentityVerificationPresenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(TwilioIdentityVerificationActivity twilioIdentityVerificationActivity, LogoutContract.Presenter presenter) {
        twilioIdentityVerificationActivity.logoutPresenter = presenter;
    }
}
