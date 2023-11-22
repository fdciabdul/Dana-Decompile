package id.dana.contract.payqr;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.payqr.PayQrContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class PayQrModule {
    private final PayQrContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PayQrContract.Presenter BuiltInFictitiousFunctionClassFactory(PayQrPresenter payQrPresenter) {
        return payQrPresenter;
    }

    public PayQrModule(PayQrContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public PayQrContract.View getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }
}
