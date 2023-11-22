package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.sendmoney.voucher.ChangeVoucherContract;
import id.dana.contract.sendmoney.voucher.ChangeVoucherPresenter;

@Module
/* loaded from: classes4.dex */
public class ChangeVoucherModule {
    private final ChangeVoucherContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public ChangeVoucherContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(ChangeVoucherPresenter changeVoucherPresenter) {
        return changeVoucherPresenter;
    }

    public ChangeVoucherModule(ChangeVoucherContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public ChangeVoucherContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
