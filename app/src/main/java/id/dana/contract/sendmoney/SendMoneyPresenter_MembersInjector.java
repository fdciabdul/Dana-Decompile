package id.dana.contract.sendmoney;

import dagger.MembersInjector;
import id.dana.domain.recentcontact.interactor.SaveDanaUserContact;
import id.dana.domain.sendmoney.interactor.InitSendMoneyContact;
import id.dana.sendmoney.mapper.SendMoneyInitMapper;
import id.dana.sendmoney.mapper.TransferContactMapper;
import id.dana.sendmoney.mapper.WithdrawOTCMapper;

/* loaded from: classes4.dex */
public final class SendMoneyPresenter_MembersInjector implements MembersInjector<SendMoneyPresenter> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyPresenter sendMoneyPresenter, TransferContactMapper transferContactMapper, SendMoneyInitMapper sendMoneyInitMapper, SaveDanaUserContact saveDanaUserContact, InitSendMoneyContact initSendMoneyContact, WithdrawOTCMapper withdrawOTCMapper) {
        sendMoneyPresenter.lookAheadTest = transferContactMapper;
        sendMoneyPresenter.BuiltInFictitiousFunctionClassFactory = sendMoneyInitMapper;
        sendMoneyPresenter.getAuthRequestContext = initSendMoneyContact;
        sendMoneyPresenter.PlaceComponentResult = saveDanaUserContact;
        sendMoneyPresenter.scheduleImpl = withdrawOTCMapper;
    }
}
