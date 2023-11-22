package id.dana.di.component;

import dagger.Component;
import id.dana.animation.HomeTabActivity;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.data.devicestats.di.DeviceStatsModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.HomeTabModules;
import id.dana.di.modules.KycAmlEddModule;
import id.dana.di.modules.KycRenewalModule;
import id.dana.di.modules.PaymentSettingModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.ReferralDialogModule;
import id.dana.di.modules.TncSummaryModules;
import id.dana.di.modules.UserConfigModule;

@Component(dependencies = {ApplicationComponent.class}, modules = {PlayStoreReviewModules.class, DanaContactModule.class, TncSummaryModules.class, UserConfigModule.class, DeepLinkModule.class, KycRenewalModule.class, KycAmlEddModule.class, GlobalNetworkModule.class, ReferralDialogModule.class, PaymentSettingModule.class, HomeTabModules.class, DeviceStatsModule.class})
@PerActivity
/* loaded from: classes2.dex */
public interface HomeTabActivityComponent {
    void BuiltInFictitiousFunctionClassFactory(HomeTabActivity homeTabActivity);
}
