package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankPresenter;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter;

@Module
/* loaded from: classes4.dex */
public class SendMoneyConfirmationModule {
    private SendMoneyConfirmationContract.View MyBillsEntityDataFactory;
    private SendMoneyConfirmationBankContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyConfirmationBankContract.Presenter MyBillsEntityDataFactory(SendMoneyConfirmationBankPresenter sendMoneyConfirmationBankPresenter) {
        return sendMoneyConfirmationBankPresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyConfirmationContract.Presenter PlaceComponentResult(SendMoneyConfirmationPresenter sendMoneyConfirmationPresenter) {
        return sendMoneyConfirmationPresenter;
    }

    public SendMoneyConfirmationModule(SendMoneyConfirmationContract.View view, SendMoneyConfirmationBankContract.View view2) {
        this.MyBillsEntityDataFactory = view;
        this.PlaceComponentResult = view2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyConfirmationContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyConfirmationBankContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }
}
