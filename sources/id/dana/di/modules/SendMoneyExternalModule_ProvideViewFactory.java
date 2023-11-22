package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.external.SendMoneyExternalContract;

/* loaded from: classes4.dex */
public final class SendMoneyExternalModule_ProvideViewFactory implements Factory<SendMoneyExternalContract.View> {
    private final SendMoneyExternalModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SendMoneyExternalModule_ProvideViewFactory(SendMoneyExternalModule sendMoneyExternalModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sendMoneyExternalModule;
    }

    public static SendMoneyExternalModule_ProvideViewFactory MyBillsEntityDataFactory(SendMoneyExternalModule sendMoneyExternalModule) {
        return new SendMoneyExternalModule_ProvideViewFactory(sendMoneyExternalModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyExternalContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
