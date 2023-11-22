package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.ChangeVoucherModule;
import id.dana.sendmoney.voucher.SummaryVoucherView;

@Component(dependencies = {ApplicationComponent.class}, modules = {ChangeVoucherModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ChangeVoucherComponent {
    void PlaceComponentResult(SummaryVoucherView summaryVoucherView);
}
