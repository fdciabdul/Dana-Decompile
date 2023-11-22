package id.dana.contract.payqr;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.payqr.GetPaymentResultContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class GetPaymentResultModule {
    private final GetPaymentResultContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetPaymentResultContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(GetPaymentResultPresenter getPaymentResultPresenter) {
        return getPaymentResultPresenter;
    }

    public GetPaymentResultModule(GetPaymentResultContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetPaymentResultContract.View getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }
}
