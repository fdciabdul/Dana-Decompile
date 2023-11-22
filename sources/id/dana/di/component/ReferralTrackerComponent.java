package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.ReferralTrackerModule;
import id.dana.referral.MyReferralDetailActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {DeepLinkModule.class, ReferralTrackerModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ReferralTrackerComponent {
    void getAuthRequestContext(MyReferralDetailActivity myReferralDetailActivity);
}
