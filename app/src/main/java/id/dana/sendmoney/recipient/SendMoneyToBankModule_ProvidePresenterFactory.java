package id.dana.sendmoney.recipient;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.recipient.SendMoneyToBankContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SendMoneyToBankModule_ProvidePresenterFactory implements Factory<SendMoneyToBankContract.Presenter> {
    private final Provider<SendMoneyToBankPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final SendMoneyToBankModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyToBankContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
