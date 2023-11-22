package id.dana.contract.sendmoney;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.recentcontact.interactor.SaveDanaUserContact;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.InitSendMoneyContact;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.sendmoney.mapper.SendMoneyInitMapper;
import id.dana.sendmoney.mapper.TransferBankMapper;
import id.dana.sendmoney.mapper.TransferContactMapper;
import id.dana.sendmoney.mapper.WithdrawOTCMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendMoneyPresenter_Factory implements Factory<SendMoneyPresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckTransferX2PFeature> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<InitTransferMoney> MyBillsEntityDataFactory;
    private final Provider<TransferContactMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<WithdrawOTCMapper> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<InitSendMoneyContact> PlaceComponentResult;
    private final Provider<GetPhoneNumber> getAuthRequestContext;
    private final Provider<SaveDanaUserContact> getErrorConfigVersion;
    private final Provider<TransferBankMapper> lookAheadTest;
    private final Provider<SendMoneyInitMapper> moveToNextValue;
    private final Provider<SendMoneyContract.View> scheduleImpl;

    private SendMoneyPresenter_Factory(Provider<InitTransferMoney> provider, Provider<TransferBankMapper> provider2, Provider<SendMoneyContract.View> provider3, Provider<CheckTransferX2PFeature> provider4, Provider<GetPhoneNumber> provider5, Provider<Context> provider6, Provider<TransferContactMapper> provider7, Provider<SendMoneyInitMapper> provider8, Provider<SaveDanaUserContact> provider9, Provider<InitSendMoneyContact> provider10, Provider<WithdrawOTCMapper> provider11) {
        this.MyBillsEntityDataFactory = provider;
        this.lookAheadTest = provider2;
        this.scheduleImpl = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.getAuthRequestContext = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
        this.moveToNextValue = provider8;
        this.getErrorConfigVersion = provider9;
        this.PlaceComponentResult = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider11;
    }

    public static SendMoneyPresenter_Factory getAuthRequestContext(Provider<InitTransferMoney> provider, Provider<TransferBankMapper> provider2, Provider<SendMoneyContract.View> provider3, Provider<CheckTransferX2PFeature> provider4, Provider<GetPhoneNumber> provider5, Provider<Context> provider6, Provider<TransferContactMapper> provider7, Provider<SendMoneyInitMapper> provider8, Provider<SaveDanaUserContact> provider9, Provider<InitSendMoneyContact> provider10, Provider<WithdrawOTCMapper> provider11) {
        return new SendMoneyPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        SendMoneyPresenter sendMoneyPresenter = new SendMoneyPresenter(this.MyBillsEntityDataFactory.get(), this.lookAheadTest.get(), this.scheduleImpl.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
        SendMoneyPresenter_MembersInjector.KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyPresenter, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.moveToNextValue.get(), this.getErrorConfigVersion.get(), this.PlaceComponentResult.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get());
        return sendMoneyPresenter;
    }
}
