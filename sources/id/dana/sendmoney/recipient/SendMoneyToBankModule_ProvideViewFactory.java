package id.dana.sendmoney.recipient;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.recipient.SendMoneyToBankContract;

/* loaded from: classes9.dex */
public final class SendMoneyToBankModule_ProvideViewFactory implements Factory<SendMoneyToBankContract.View> {
    private final SendMoneyToBankModule BuiltInFictitiousFunctionClassFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyToBankContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
