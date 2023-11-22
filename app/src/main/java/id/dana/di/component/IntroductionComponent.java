package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.onboarding.IntroductionActivity;

@Component(dependencies = {ApplicationComponent.class})
@PerActivity
/* loaded from: classes4.dex */
public interface IntroductionComponent {
    void getAuthRequestContext(IntroductionActivity introductionActivity);
}
