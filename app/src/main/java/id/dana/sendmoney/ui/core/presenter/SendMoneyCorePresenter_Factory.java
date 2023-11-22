package id.dana.sendmoney.ui.core.presenter;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.sendmoney.domain.core.interactor.GetSendMoneyApiMigrationConfig;
import id.dana.sendmoney.domain.core.interactor.GetTransferBalanceInit;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SendMoneyCorePresenter_Factory implements Factory<SendMoneyCorePresenter> {
    private final Provider<GetUserId> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetSendMoneyApiMigrationConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SendMoneyCoreContract.View> MyBillsEntityDataFactory;
    private final Provider<GetTransferBalanceInit> PlaceComponentResult;
    private final Provider<GetPhoneNumber> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyCorePresenter(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
