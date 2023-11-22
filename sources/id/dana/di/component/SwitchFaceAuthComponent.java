package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.SwitchFaceAuthenticationModule;
import id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView;
import id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;

@Component(dependencies = {ApplicationComponent.class}, modules = {SwitchFaceAuthenticationModule.class, FaceAuthenticationModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface SwitchFaceAuthComponent {
    void BuiltInFictitiousFunctionClassFactory(SwitchFaceAuthenticationView switchFaceAuthenticationView);

    void KClassImpl$Data$declaredNonStaticMembers$2(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView);
}
