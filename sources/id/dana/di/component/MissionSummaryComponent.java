package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.MissionSummaryModule;
import id.dana.promoquest.views.MissionSummaryView;

@Component(dependencies = {ApplicationComponent.class}, modules = {MissionSummaryModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface MissionSummaryComponent {
    void getAuthRequestContext(MissionSummaryView missionSummaryView);
}
