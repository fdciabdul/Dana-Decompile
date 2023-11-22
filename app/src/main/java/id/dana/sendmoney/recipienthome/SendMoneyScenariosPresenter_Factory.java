package id.dana.sendmoney.recipienthome;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.sendmoney.interactor.GetSendMoneyScenarios;
import id.dana.mapper.SendMoneyScenariosMapper;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyScenariosPresenter_Factory implements Factory<SendMoneyScenariosPresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SendMoneyScenariosContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SendMoneyScenariosMapper> MyBillsEntityDataFactory;
    private final Provider<GetSendMoneyScenarios> PlaceComponentResult;

    private SendMoneyScenariosPresenter_Factory(Provider<SendMoneyScenariosContract.View> provider, Provider<GetSendMoneyScenarios> provider2, Provider<SendMoneyScenariosMapper> provider3, Provider<Context> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
    }

    public static SendMoneyScenariosPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<SendMoneyScenariosContract.View> provider, Provider<GetSendMoneyScenarios> provider2, Provider<SendMoneyScenariosMapper> provider3, Provider<Context> provider4) {
        return new SendMoneyScenariosPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyScenariosPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
