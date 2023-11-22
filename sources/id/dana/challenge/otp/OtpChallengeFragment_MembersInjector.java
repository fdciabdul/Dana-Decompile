package id.dana.challenge.otp;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.h5event.ChangePhoneNumberH5EventContract;

/* loaded from: classes4.dex */
public final class OtpChallengeFragment_MembersInjector implements MembersInjector<OtpChallengeFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(OtpChallengeFragment otpChallengeFragment, ChangePhoneNumberH5EventContract.Presenter presenter) {
        otpChallengeFragment.changePhoneNumberH5EventPresenter = presenter;
    }

    public static void getAuthRequestContext(OtpChallengeFragment otpChallengeFragment, AbstractOtpContract.Presenter presenter) {
        otpChallengeFragment.presenter = presenter;
    }

    public static void getAuthRequestContext(OtpChallengeFragment otpChallengeFragment, DeviceInformationProvider deviceInformationProvider) {
        otpChallengeFragment.deviceInformationProvider = deviceInformationProvider;
    }

    public static void BuiltInFictitiousFunctionClassFactory(OtpChallengeFragment otpChallengeFragment, Lazy<BotProtectionChallenge> lazy) {
        otpChallengeFragment.botProtectionChallenge = lazy;
    }
}
