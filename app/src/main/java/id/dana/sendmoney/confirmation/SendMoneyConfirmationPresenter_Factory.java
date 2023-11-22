package id.dana.sendmoney.confirmation;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoney;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyContact;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyOTC;
import id.dana.domain.sendmoney.interactor.GetRefundTimeout;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import id.dana.sendmoney.mapper.ConfirmToContactMapper;
import id.dana.sendmoney.mapper.RecentRecipientModelMapper;
import id.dana.sendmoney.mapper.SendMoneyConfirmModelMapper;
import id.dana.utils.DateTimeUtil;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyConfirmationPresenter_Factory implements Factory<SendMoneyConfirmationPresenter> {
    private final Provider<CheckTransferX2PFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SendMoneyConfirmModelMapper> DatabaseTableConfigUtil;
    private final Provider<SendMoneyConfirmationContract.View> GetContactSyncConfig;
    private final Provider<ConfirmSendMoneyContact> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ConfirmSendMoneyOTC> MyBillsEntityDataFactory;
    private final Provider<GetSingleBalance> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SaveRecentContact> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<SendMoneyConfirmationData> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<ConfirmSendMoney> PlaceComponentResult;
    private final Provider<ConfirmToContactMapper> getAuthRequestContext;
    private final Provider<GetRecentTransaction> getErrorConfigVersion;
    private final Provider<RecentRecipientModelMapper> initRecordTimeStamp;
    private final Provider<Context> lookAheadTest;
    private final Provider<GetRefundTimeout> moveToNextValue;
    private final Provider<DateTimeUtil> scheduleImpl;

    private SendMoneyConfirmationPresenter_Factory(Provider<ConfirmSendMoney> provider, Provider<Context> provider2, Provider<GetRefundTimeout> provider3, Provider<SendMoneyConfirmationContract.View> provider4, Provider<SendMoneyConfirmationData> provider5, Provider<DateTimeUtil> provider6, Provider<GetRecentTransaction> provider7, Provider<RecentRecipientModelMapper> provider8, Provider<GetSingleBalance> provider9, Provider<SendMoneyConfirmModelMapper> provider10, Provider<ConfirmSendMoneyContact> provider11, Provider<ConfirmToContactMapper> provider12, Provider<SaveRecentContact> provider13, Provider<CheckTransferX2PFeature> provider14, Provider<ConfirmSendMoneyOTC> provider15) {
        this.PlaceComponentResult = provider;
        this.lookAheadTest = provider2;
        this.moveToNextValue = provider3;
        this.GetContactSyncConfig = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider5;
        this.scheduleImpl = provider6;
        this.getErrorConfigVersion = provider7;
        this.initRecordTimeStamp = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider9;
        this.DatabaseTableConfigUtil = provider10;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider11;
        this.getAuthRequestContext = provider12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider13;
        this.BuiltInFictitiousFunctionClassFactory = provider14;
        this.MyBillsEntityDataFactory = provider15;
    }

    public static SendMoneyConfirmationPresenter_Factory getAuthRequestContext(Provider<ConfirmSendMoney> provider, Provider<Context> provider2, Provider<GetRefundTimeout> provider3, Provider<SendMoneyConfirmationContract.View> provider4, Provider<SendMoneyConfirmationData> provider5, Provider<DateTimeUtil> provider6, Provider<GetRecentTransaction> provider7, Provider<RecentRecipientModelMapper> provider8, Provider<GetSingleBalance> provider9, Provider<SendMoneyConfirmModelMapper> provider10, Provider<ConfirmSendMoneyContact> provider11, Provider<ConfirmToContactMapper> provider12, Provider<SaveRecentContact> provider13, Provider<CheckTransferX2PFeature> provider14, Provider<ConfirmSendMoneyOTC> provider15) {
        return new SendMoneyConfirmationPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        SendMoneyConfirmationPresenter sendMoneyConfirmationPresenter = new SendMoneyConfirmationPresenter(this.PlaceComponentResult.get(), this.lookAheadTest.get(), this.moveToNextValue.get(), this.GetContactSyncConfig.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.scheduleImpl.get(), this.getErrorConfigVersion.get(), this.initRecordTimeStamp.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
        SendMoneyConfirmationPresenter_MembersInjector.KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyConfirmationPresenter, this.DatabaseTableConfigUtil.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
        return sendMoneyConfirmationPresenter;
    }
}
