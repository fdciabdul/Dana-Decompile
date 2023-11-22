package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.HomeReferralModule;
import id.dana.di.modules.MissionSummaryModule;
import id.dana.richview.homereferral.HomeReferralView;

@Component(dependencies = {ApplicationComponent.class}, modules = {HomeReferralModule.class, DeepLinkModule.class, MissionSummaryModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface HomeReferralComponent {
    void BuiltInFictitiousFunctionClassFactory(HomeReferralView homeReferralView);
}
