package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosContract;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosPresenter;

@Module
/* loaded from: classes4.dex */
public class SendMoneyScenarioModule {
    private SendMoneyScenariosContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyScenariosContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyScenariosPresenter sendMoneyScenariosPresenter) {
        return sendMoneyScenariosPresenter;
    }

    public SendMoneyScenarioModule(SendMoneyScenariosContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyScenariosContract.View getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }
}
