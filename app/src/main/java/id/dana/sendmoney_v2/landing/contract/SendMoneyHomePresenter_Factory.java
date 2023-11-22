package id.dana.sendmoney_v2.landing.contract;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.sendmoney.interactor.GetFeatureSendMoneyCashierNative;
import id.dana.domain.sendmoney.interactor.GetIsUserCertifiedGlobalSend;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.interactor.SaveIsUserCertifiedGlobalSend;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.sendmoney.domain.globalsend.interactor.InitGlobalTransferVerifyUser;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyHomePresenter_Factory implements Factory<SendMoneyHomePresenter> {
    private final Provider<GetIsUserCertifiedGlobalSend> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserInfo> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetFeatureSendMoneyCashierNative> MyBillsEntityDataFactory;
    private final Provider<InitGlobalTransferVerifyUser> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetAuthCode> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;
    private final Provider<InitTransferMoney> lookAheadTest;
    private final Provider<SaveIsUserCertifiedGlobalSend> moveToNextValue;
    private final Provider<KycAndDebitPayOptionContract.View> scheduleImpl;

    private SendMoneyHomePresenter_Factory(Provider<Context> provider, Provider<InitTransferMoney> provider2, Provider<GetFeatureSendMoneyCashierNative> provider3, Provider<GetAuthCode> provider4, Provider<KycAndDebitPayOptionContract.View> provider5, Provider<GetUserInfo> provider6, Provider<InitGlobalTransferVerifyUser> provider7, Provider<SaveIsUserCertifiedGlobalSend> provider8, Provider<GetIsUserCertifiedGlobalSend> provider9) {
        this.getAuthRequestContext = provider;
        this.lookAheadTest = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.PlaceComponentResult = provider4;
        this.scheduleImpl = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
        this.moveToNextValue = provider8;
        this.BuiltInFictitiousFunctionClassFactory = provider9;
    }

    public static SendMoneyHomePresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<InitTransferMoney> provider2, Provider<GetFeatureSendMoneyCashierNative> provider3, Provider<GetAuthCode> provider4, Provider<KycAndDebitPayOptionContract.View> provider5, Provider<GetUserInfo> provider6, Provider<InitGlobalTransferVerifyUser> provider7, Provider<SaveIsUserCertifiedGlobalSend> provider8, Provider<GetIsUserCertifiedGlobalSend> provider9) {
        return new SendMoneyHomePresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyHomePresenter(this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.scheduleImpl.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.moveToNextValue.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
