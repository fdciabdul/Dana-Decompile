package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.sendmoney.voucher.VoucherDetailActivity;

@Component(dependencies = {ApplicationComponent.class})
@PerActivity
/* loaded from: classes4.dex */
public interface VoucherDetailComponent {
    void MyBillsEntityDataFactory(VoucherDetailActivity voucherDetailActivity);
}
