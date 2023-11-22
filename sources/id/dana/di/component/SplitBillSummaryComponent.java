package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.SplitBillAnalyticModule;
import id.dana.di.modules.SplitBillDetailModule;
import id.dana.di.modules.SplitBillModule;
import id.dana.splitbill.view.SplitBillSummaryActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {SplitBillModule.class, SplitBillDetailModule.class, SplitBillAnalyticModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface SplitBillSummaryComponent {
    void BuiltInFictitiousFunctionClassFactory(SplitBillSummaryActivity splitBillSummaryActivity);
}
