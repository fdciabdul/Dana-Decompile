package id.dana.onboarding.referral;

import dagger.MembersInjector;
import id.dana.onboarding.referral.ReferralContract;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import javax.inject.Named;

/* loaded from: classes5.dex */
public final class VerifyReferralCodeFragment_MembersInjector implements MembersInjector<VerifyReferralCodeFragment> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(VerifyReferralCodeFragment verifyReferralCodeFragment, LocationPermissionSubject locationPermissionSubject) {
        verifyReferralCodeFragment.locationPermissionSubject = locationPermissionSubject;
    }

    @Named("verifyReferralCodePresenter")
    public static void BuiltInFictitiousFunctionClassFactory(VerifyReferralCodeFragment verifyReferralCodeFragment, ReferralContract.Presenter presenter) {
        verifyReferralCodeFragment.verifyReferralCodePresenter = presenter;
    }
}
