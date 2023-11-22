package id.dana.di.component;

import dagger.Component;
import id.dana.contract.homeinfo.HomeInfoModule;
import id.dana.di.PerActivity;
import id.dana.richview.SurveyView;

@Component(dependencies = {ApplicationComponent.class}, modules = {HomeInfoModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface SurveyComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(SurveyView surveyView);
}
