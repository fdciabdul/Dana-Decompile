package id.dana.di.component;

import dagger.Component;
import id.dana.challenge.ChallengePinWithFaceActivity;
import id.dana.challenge.pinwithface.ChallengePinWithFaceModule;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.BiometricAnalyticModule;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.PinChallengeModule;
import id.dana.di.modules.SessionModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;

@Component(dependencies = {ApplicationComponent.class}, modules = {PinChallengeModule.class, ChallengePinWithFaceModule.class, LogoutModule.class, FaceAuthPopUpConsultationModule.class, BiometricAnalyticModule.class, FaceAuthenticationModule.class, SessionModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ChallengePinWithFaceActivityComponent {
    void BuiltInFictitiousFunctionClassFactory(ChallengePinWithFaceActivity challengePinWithFaceActivity);
}
