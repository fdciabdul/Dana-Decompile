package id.dana.di.component;

import dagger.Component;
import id.dana.contract.payasset.ChangePayMethodModule;
import id.dana.contract.payqr.GetPaymentResultModule;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.PayQrModule;
import id.dana.contract.user.GetUserInfoModule;
import id.dana.di.PerActivity;
import id.dana.pay.BalancePayFragment;
import id.dana.pay.BalanceQrisPayFragment;

@Component(dependencies = {ApplicationComponent.class}, modules = {GetPaymentResultModule.class, PayQrModule.class, GetUserInfoModule.class, ChangePayMethodModule.class, OfflinePayModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface BalancePayComponent {
    void MyBillsEntityDataFactory(BalanceQrisPayFragment balanceQrisPayFragment);

    void PlaceComponentResult(BalancePayFragment balancePayFragment);
}
