package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.PayMethodModule;
import id.dana.sendmoney_v2.paymethod.PayMethodView;

@Component(dependencies = {ApplicationComponent.class}, modules = {PayMethodModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface PayMethodComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(PayMethodView payMethodView);
}
