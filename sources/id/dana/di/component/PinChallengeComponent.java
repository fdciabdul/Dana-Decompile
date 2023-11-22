package id.dana.di.component;

import dagger.Component;
import id.dana.challenge.pin.PinChallengeFragment;
import id.dana.di.PerActivity;
import id.dana.di.modules.PinChallengeModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;

@Component(dependencies = {ApplicationComponent.class}, modules = {PinChallengeModule.class, FaceAuthenticationModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface PinChallengeComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(PinChallengeFragment pinChallengeFragment);
}
