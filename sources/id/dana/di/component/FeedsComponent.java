package id.dana.di.component;

import dagger.Component;
import id.dana.contract.feeds.UserFeedsModule;
import id.dana.di.PerActivity;
import id.dana.feeds.views.UserFeedsActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {UserFeedsModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface FeedsComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(UserFeedsActivity userFeedsActivity);
}
