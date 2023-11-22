package id.dana.di.component;

import dagger.Subcomponent;
import id.dana.cashier.CashierBannerModule;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierFeedModule;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.PayResultModule;
import id.dana.expresspurchase.di.ExpressPurchaseModule;
import kotlin.Metadata;

@Subcomponent(modules = {PayResultModule.class, DeepLinkModule.class, ExpressPurchaseModule.class, GlobalNetworkModule.class, CashierCardBindingModule.class, CashierBannerModule.class, CashierFeedModule.class, CashierUserRelatedModule.class, CashierPayLaterModule.class})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/CashierResultWithFeedComponent;", "", "Lid/dana/cashier/fragment/PaymentResultFragment;", "p0", "", "getAuthRequestContext", "(Lid/dana/cashier/fragment/PaymentResultFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes2.dex */
public interface CashierResultWithFeedComponent {
    void getAuthRequestContext(PaymentResultFragment p0);
}
