package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.SplitBillAnalyticModule;
import id.dana.di.modules.SplitBillModule;
import id.dana.splitbill.view.SplitBillActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {GenerateDeepLinkModule.class, SplitBillModule.class, SplitBillAnalyticModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface SplitBillComponent {
    void PlaceComponentResult(SplitBillActivity splitBillActivity);
}
