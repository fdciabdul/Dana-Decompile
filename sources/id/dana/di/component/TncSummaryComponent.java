package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.TncSummaryModules;
import id.dana.tncsummary.TncSummaryActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {TncSummaryModules.class})
@PerActivity
/* loaded from: classes2.dex */
public interface TncSummaryComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(TncSummaryActivity tncSummaryActivity);
}
