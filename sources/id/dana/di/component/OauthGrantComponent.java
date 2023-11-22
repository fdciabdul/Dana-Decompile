package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.OauthGrantModule;
import id.dana.di.modules.OauthGrantTrackerModule;
import id.dana.oauth.activity.OauthGrantActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {OauthGrantModule.class, OauthGrantTrackerModule.class, DeepLinkModule.class})
@PerActivity
/* loaded from: classes2.dex */
public interface OauthGrantComponent {
    void getAuthRequestContext(OauthGrantActivity oauthGrantActivity);
}
