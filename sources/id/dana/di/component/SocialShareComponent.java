package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.SocialShareModule;
import id.dana.richview.socialshare.SocialShareView;

@Component(dependencies = {ApplicationComponent.class}, modules = {SocialShareModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface SocialShareComponent {
    void BuiltInFictitiousFunctionClassFactory(SocialShareView socialShareView);
}
