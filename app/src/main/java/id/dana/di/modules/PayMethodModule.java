package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.sendmoney.PayMethodContract;
import id.dana.contract.sendmoney.PayMethodPresenter;

@Module
/* loaded from: classes4.dex */
public class PayMethodModule {
    private final PayMethodContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PayMethodContract.Presenter BuiltInFictitiousFunctionClassFactory(PayMethodPresenter payMethodPresenter) {
        return payMethodPresenter;
    }

    public PayMethodModule(PayMethodContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PayMethodContract.View getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }
}
