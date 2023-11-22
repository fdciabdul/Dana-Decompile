package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.NearbyMeModule;
import id.dana.nearbyme.NearbyMeActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {NearbyMeModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface NearbyMeComponent {
    void getAuthRequestContext(NearbyMeActivity nearbyMeActivity);
}
