package id.dana.sendmoney.recipient;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.sendmoney.recipient.SendMoneyToBankContract;

@Module
/* loaded from: classes9.dex */
public class SendMoneyToBankModule {
    private final SendMoneyToBankContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyToBankContract.Presenter BuiltInFictitiousFunctionClassFactory(SendMoneyToBankPresenter sendMoneyToBankPresenter) {
        return sendMoneyToBankPresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneyToBankContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
