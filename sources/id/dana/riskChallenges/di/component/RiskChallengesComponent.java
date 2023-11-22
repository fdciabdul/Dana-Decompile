package id.dana.riskChallenges.di.component;

import dagger.Subcomponent;
import id.dana.analytics.di.module.RiskChallengeTrackerModule;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.riskChallenges.di.module.DanaProtectionModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.riskChallenges.di.module.PasskeyModule;
import id.dana.riskChallenges.di.module.ResetPasswordModule;
import id.dana.riskChallenges.di.module.RiskChallengesViewModelModule;
import id.dana.riskChallenges.di.module.VerifyPasswordModule;
import id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment;
import id.dana.riskChallenges.ui.danaprotection.ActivityVerificationLauncher;
import id.dana.riskChallenges.ui.micface.MicFaceFragment;
import id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment;
import id.dana.riskChallenges.ui.otp.otpsms.OtpSmsSharedLogicHandler;
import id.dana.riskChallenges.ui.otp.otpwhatsapp.OtpWhatsappSharedLogicHandler;
import id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher;
import id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyLauncher;
import id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment;
import id.dana.riskChallenges.ui.resetpin.ResetPinLauncher;
import id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity;
import id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment;
import id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment;
import id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared;
import kotlin.Metadata;

@Subcomponent(modules = {FaceAuthenticationModule.class, ResetPasswordModule.class, RiskChallengesViewModelModule.class, VerifyPasswordModule.class, RiskChallengeTrackerModule.class, DanaProtectionModule.class, VerifyPasswordModule.class, PasskeyModule.class})
@RiskChallengesScope
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H&¢\u0006\u0004\b\u000b\u0010\u0011J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0012H&¢\u0006\u0004\b\u000b\u0010\u0013J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0014H&¢\u0006\u0004\b\u000b\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0016H&¢\u0006\u0004\b\u0005\u0010\u0017J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0018H&¢\u0006\u0004\b\u000e\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001dH&¢\u0006\u0004\b\u001b\u0010\u001eJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001fH&¢\u0006\u0004\b\u000b\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020!H&¢\u0006\u0004\b\u0005\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020#H&¢\u0006\u0004\b\u0005\u0010$J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020%H&¢\u0006\u0004\b\b\u0010&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "", "Lid/dana/riskChallenges/ui/callcsordiana/view/CallCsOrDianaFragment;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/riskChallenges/ui/callcsordiana/view/CallCsOrDianaFragment;)V", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationLauncher;", "PlaceComponentResult", "(Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationLauncher;)V", "Lid/dana/riskChallenges/ui/micface/MicFaceFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/riskChallenges/ui/micface/MicFaceFragment;)V", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpFragment;", "getAuthRequestContext", "(Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpFragment;)V", "Lid/dana/riskChallenges/ui/otp/otpsms/OtpSmsSharedLogicHandler;", "(Lid/dana/riskChallenges/ui/otp/otpsms/OtpSmsSharedLogicHandler;)V", "Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsappSharedLogicHandler;", "(Lid/dana/riskChallenges/ui/otp/otpwhatsapp/OtpWhatsappSharedLogicHandler;)V", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationFragment;", "(Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationFragment;)V", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "(Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;)V", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyLauncher;", "(Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyLauncher;)V", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainFragment;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainFragment;)V", "Lid/dana/riskChallenges/ui/resetpin/ResetPinLauncher;", "(Lid/dana/riskChallenges/ui/resetpin/ResetPinLauncher;)V", "Lid/dana/riskChallenges/ui/resetpin/SelfUnfreezeActivity;", "(Lid/dana/riskChallenges/ui/resetpin/SelfUnfreezeActivity;)V", "Lid/dana/riskChallenges/ui/resetpin/confirm/InputConfirmPinFragment;", "(Lid/dana/riskChallenges/ui/resetpin/confirm/InputConfirmPinFragment;)V", "Lid/dana/riskChallenges/ui/resetpin/newpin/InputNewPinFragment;", "(Lid/dana/riskChallenges/ui/resetpin/newpin/InputNewPinFragment;)V", "Lid/dana/riskChallenges/ui/verifypin/shared/VerifyPinShared;", "(Lid/dana/riskChallenges/ui/verifypin/shared/VerifyPinShared;)V", "Factory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RiskChallengesComponent {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/di/component/RiskChallengesComponent$Factory;", "", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/riskChallenges/di/component/RiskChallengesComponent;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: classes.dex */
    public interface Factory {
        RiskChallengesComponent BuiltInFictitiousFunctionClassFactory();
    }

    void BuiltInFictitiousFunctionClassFactory(EnrollmentMainFragment p0);

    void BuiltInFictitiousFunctionClassFactory(ResetPinLauncher p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(MicFaceFragment p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(OtpSmsSharedLogicHandler p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(OtpWhatsappSharedLogicHandler p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(PasskeyVerificationFragment p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(SelfUnfreezeActivity p0);

    void MyBillsEntityDataFactory(CallCsOrDianaFragment p0);

    void MyBillsEntityDataFactory(EnrollPasskeyLauncher p0);

    void MyBillsEntityDataFactory(InputConfirmPinFragment p0);

    void MyBillsEntityDataFactory(InputNewPinFragment p0);

    void PlaceComponentResult(ActivityVerificationLauncher p0);

    void PlaceComponentResult(VerifyPinShared p0);

    void getAuthRequestContext(MissedCallOtpFragment p0);

    void getAuthRequestContext(UnlinkPasskeyLauncher p0);
}
