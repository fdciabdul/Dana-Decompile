package id.dana.di.component;

import dagger.Component;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.payqr.GetPaymentResultModule;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.PayQrModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.pay.PayFragment;

@Component(dependencies = {ApplicationComponent.class}, modules = {GetPaymentResultModule.class, QueryPayMethodModule.class, PayQrModule.class, OfflinePayModule.class, PlayStoreReviewModules.class})
@PerActivity
/* loaded from: classes4.dex */
public interface PayComponent {
    void getAuthRequestContext(PayFragment payFragment);
}
