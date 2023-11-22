package id.dana.di.component;

import dagger.Component;
import id.dana.animation.HomeRecycleFragment;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.globalsearch.GlobalSearchModule;
import id.dana.contract.homeinfo.HomeInfoModule;
import id.dana.contract.inbox.UnreadInboxModule;
import id.dana.contract.ott.OttVerifyModule;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.permission.PermissionStateModule;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.user.GetBalanceModule;
import id.dana.contract.user.GetUserInfoModule;
import id.dana.data.devicestats.di.DeviceStatsModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.BiometricAnalyticModule;
import id.dana.di.modules.GeofenceModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.HomeTabModules;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.PaylaterAnalyticModule;
import id.dana.di.modules.SessionModule;

@Component(dependencies = {ApplicationComponent.class}, modules = {GetBalanceModule.class, UnreadInboxModule.class, QueryPayMethodModule.class, HomeInfoModule.class, GeofenceModule.class, LogoutModule.class, GlobalSearchModule.class, GetUserInfoModule.class, OttVerifyModule.class, PermissionStateModule.class, GlobalNetworkModule.class, SessionModule.class, PayLaterModule.class, HomeTabModules.class, BiometricAnalyticModule.class, ServicesModule.class, DeepLinkModule.class, PaylaterAnalyticModule.class, DeviceStatsModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface HomeRecycleComponent {
    void getAuthRequestContext(HomeRecycleFragment homeRecycleFragment);
}
