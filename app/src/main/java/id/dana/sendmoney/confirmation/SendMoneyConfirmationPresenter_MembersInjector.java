package id.dana.sendmoney.confirmation;

import dagger.MembersInjector;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyContact;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyOTC;
import id.dana.sendmoney.mapper.ConfirmToContactMapper;
import id.dana.sendmoney.mapper.SendMoneyConfirmModelMapper;

/* loaded from: classes5.dex */
public final class SendMoneyConfirmationPresenter_MembersInjector implements MembersInjector<SendMoneyConfirmationPresenter> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyConfirmationPresenter sendMoneyConfirmationPresenter, SendMoneyConfirmModelMapper sendMoneyConfirmModelMapper, ConfirmSendMoneyContact confirmSendMoneyContact, ConfirmToContactMapper confirmToContactMapper, SaveRecentContact saveRecentContact, CheckTransferX2PFeature checkTransferX2PFeature, ConfirmSendMoneyOTC confirmSendMoneyOTC) {
        sendMoneyConfirmationPresenter.lookAheadTest = sendMoneyConfirmModelMapper;
        sendMoneyConfirmationPresenter.MyBillsEntityDataFactory = confirmSendMoneyContact;
        sendMoneyConfirmationPresenter.getAuthRequestContext = confirmToContactMapper;
        sendMoneyConfirmationPresenter.scheduleImpl = saveRecentContact;
        sendMoneyConfirmationPresenter.KClassImpl$Data$declaredNonStaticMembers$2 = checkTransferX2PFeature;
        sendMoneyConfirmationPresenter.PlaceComponentResult = confirmSendMoneyOTC;
    }
}
