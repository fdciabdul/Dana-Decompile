package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.ActivityModule;

@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface ActivityComponent {
}
