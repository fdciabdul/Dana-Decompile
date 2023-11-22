package id.dana.domain.sendmoney.repository;

import id.dana.domain.promotion.CdpContent;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.domain.sendmoney.model.DigitalMoney;
import id.dana.domain.sendmoney.model.NameCheckParam;
import id.dana.domain.sendmoney.model.OTCTransferInit;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.domain.sendmoney.model.SendMoneyConfirmOTCParam;
import id.dana.domain.sendmoney.model.SendMoneyConfirmParam;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.domain.sendmoney.model.SendMoneyScenario;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.model.TransferInitParam;
import id.dana.domain.sendmoney.model.TransferPrepay;
import id.dana.domain.sendmoney.model.WithdrawChannelInfoData;
import id.dana.domain.sendmoney.model.WithdrawInit;
import id.dana.domain.sendmoney.model.WithdrawNameCheck;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface SendMoneyRepository {
    Observable<SendMoneyConfirm> confirmSendMoney(SendMoneyConfirmParam sendMoneyConfirmParam);

    Observable<SendMoneyConfirm> confirmSendMoneyOTC(SendMoneyConfirmOTCParam sendMoneyConfirmOTCParam);

    Observable<SendMoneyConfirm> confirmSendMoneyToBank(SendMoneyConfirmParam sendMoneyConfirmParam);

    Observable<String> deleteGroup(String str);

    Observable<List<BillerX2B>> getAllBillerX2B();

    Observable<List<DigitalMoney>> getEWalletsBankAccountPrefix();

    Observable<Boolean> getIsUserCertifiedGlobalSend();

    Observable<TransferInit> getPayMethod(String str);

    Observable<CdpContent> getSendMoneyBanner();

    Observable<SendMoneyInit> getSendMoneyOption();

    Observable<List<SendMoneyScenario>> getSendMoneyScenarios();

    Observable<List<CdpContent>> getSendMoneyVendorLogo();

    Observable<String> getSortingSendMoney();

    Observable<String> getStateSendMoneyShareFeed();

    Observable<Boolean> getStateSuspiciousAccountSmartFriction();

    Observable<TransferInit> getTransferOption(String str);

    Observable<List<WithdrawChannelInfoData>> getWithdrawChannelInfoData();

    Observable<TransferPrepay> initPrePay(String str, String str2);

    Observable<Boolean> isNeedToShowExternalOnboardingDialog();

    Observable<WithdrawNameCheck> nameCheck(NameCheckParam nameCheckParam);

    Observable<Boolean> saveIsNeedToShowExternalOnboardingDialog(Boolean bool);

    Observable<Boolean> saveIsUserCertifiedGlobalSend();

    Observable<Boolean> saveSortingSendMoney(String str);

    Observable<Boolean> saveStateSendMoneyShareFeed(String str);

    Observable<Boolean> saveStateSuspiciousAccountSmartFriction(boolean z);

    Observable<SendMoneyConfirm> sendMoney(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8);

    Observable<SendMoneyInit> sendMoneyInit(String str, String str2, String str3);

    Observable<TransferInit> transferInit(TransferInitParam transferInitParam);

    Observable<OTCTransferInit> transferOTCInit(String str, String str2);

    Observable<WithdrawInit> withdrawInit(Boolean bool, String str);
}
