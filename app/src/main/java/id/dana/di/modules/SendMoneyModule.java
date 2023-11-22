package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.contract.sendmoney.SendMoneyPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class SendMoneyModule {
    private SendMoneyContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyContract.Presenter MyBillsEntityDataFactory(SendMoneyPresenter sendMoneyPresenter) {
        return sendMoneyPresenter;
    }

    public SendMoneyModule(SendMoneyContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
