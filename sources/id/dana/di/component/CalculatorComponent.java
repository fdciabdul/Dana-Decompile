package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.SendMoneyModule;
import id.dana.sendmoney.di.module.SendMoneyCoreModule;
import id.dana.sendmoney.summary.view.SummaryView;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;

@Component(dependencies = {ApplicationComponent.class}, modules = {SendMoneyModule.class, SendMoneyTrackerModule.class, SendMoneyCoreModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface CalculatorComponent {
    void PlaceComponentResult(SummaryView summaryView);
}
