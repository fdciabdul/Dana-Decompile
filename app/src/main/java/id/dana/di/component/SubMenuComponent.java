package id.dana.di.component;

import dagger.Component;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.ChangePhoneNumberH5EventModule;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.SessionModule;
import id.dana.di.modules.SubMenuModule;
import id.dana.myprofile.SettingMoreProfileActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {SubMenuModule.class, ChangePhoneNumberH5EventModule.class, LogoutModule.class, FaceAuthPopUpConsultationModule.class, SessionModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface SubMenuComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(SettingMoreProfileActivity settingMoreProfileActivity);
}
