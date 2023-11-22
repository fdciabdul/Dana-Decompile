package id.dana.wallet_v3.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.user.GetBalanceModule;
import id.dana.di.PerActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.wallet_v3.di.module.WalletSearchModule;
import id.dana.wallet_v3.loyalty.di.LoyaltyWalletDetailModule;
import id.dana.wallet_v3.view.search.view.WalletSearchFragment;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {WalletSearchModule.class, ServicesModule.class, GetBalanceModule.class, DeepLinkModule.class, LoyaltyWalletDetailModule.class})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/di/component/WalletSearchComponent;", "", "Lid/dana/wallet_v3/view/search/view/WalletSearchFragment;", "walletSearchFragment", "", "inject", "(Lid/dana/wallet_v3/view/search/view/WalletSearchFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public interface WalletSearchComponent {
    void inject(WalletSearchFragment walletSearchFragment);
}
