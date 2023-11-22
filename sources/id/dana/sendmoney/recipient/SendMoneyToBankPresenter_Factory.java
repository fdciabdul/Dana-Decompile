package id.dana.sendmoney.recipient;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.CheckTransferToBankFeature;
import id.dana.sendmoney.recipient.SendMoneyToBankContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SendMoneyToBankPresenter_Factory implements Factory<SendMoneyToBankPresenter> {
    private final Provider<SendMoneyToBankContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckTransferToBankFeature> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyToBankPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
