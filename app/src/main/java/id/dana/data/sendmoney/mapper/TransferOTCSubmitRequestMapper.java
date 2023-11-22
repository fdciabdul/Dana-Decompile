package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.TransferOTCSubmitRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferParticipantDTO;
import id.dana.domain.sendmoney.model.SendMoneyConfirmOTCParam;
import id.dana.domain.sendmoney.model.SendMoneyConfirmParam;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class TransferOTCSubmitRequestMapper extends BaseMapper<SendMoneyConfirmOTCParam, TransferOTCSubmitRequest> {
    private String requestId;

    @Inject
    public TransferOTCSubmitRequestMapper() {
    }

    public TransferOTCSubmitRequest apply(SendMoneyConfirmOTCParam sendMoneyConfirmOTCParam, String str) {
        this.requestId = str;
        return apply(sendMoneyConfirmOTCParam);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public TransferOTCSubmitRequest map(SendMoneyConfirmOTCParam sendMoneyConfirmOTCParam) {
        if (sendMoneyConfirmOTCParam != null) {
            TransferOTCSubmitRequest transferOTCSubmitRequest = new TransferOTCSubmitRequest();
            transferOTCSubmitRequest.acceptTimeoutUnit = sendMoneyConfirmOTCParam.getAcceptTimeoutUnit();
            transferOTCSubmitRequest.acceptTimeoutValue = sendMoneyConfirmOTCParam.getAcceptTimeoutValue();
            transferOTCSubmitRequest.amount = sendMoneyConfirmOTCParam.getAmount();
            transferOTCSubmitRequest.fundType = sendMoneyConfirmOTCParam.getFundType();
            transferOTCSubmitRequest.instId = sendMoneyConfirmOTCParam.getInstId() == null ? "OTHER_DEBIT_CARD" : sendMoneyConfirmOTCParam.getInstId();
            transferOTCSubmitRequest.payeeInfo = getTransferParticipant(sendMoneyConfirmOTCParam);
            transferOTCSubmitRequest.payMethod = sendMoneyConfirmOTCParam.getPayMethod();
            transferOTCSubmitRequest.payOption = sendMoneyConfirmOTCParam.getPayOption();
            transferOTCSubmitRequest.withdrawInstId = sendMoneyConfirmOTCParam.getWithdrawInstId();
            transferOTCSubmitRequest.withdrawInstLocalName = sendMoneyConfirmOTCParam.getWithdrawInstLocalName();
            transferOTCSubmitRequest.withdrawInstName = sendMoneyConfirmOTCParam.getWithdrawInstName();
            transferOTCSubmitRequest.withdrawPayMethod = sendMoneyConfirmOTCParam.getWithdrawPayMethod();
            transferOTCSubmitRequest.withdrawPayOption = sendMoneyConfirmOTCParam.getWithdrawPayOption();
            transferOTCSubmitRequest.requestId = this.requestId;
            transferOTCSubmitRequest.shareActivity = sendMoneyConfirmOTCParam.isShareActivity();
            transferOTCSubmitRequest.setTransferMethod(sendMoneyConfirmOTCParam.getTransferMethod());
            return transferOTCSubmitRequest;
        }
        return null;
    }

    private TransferParticipantDTO getTransferParticipant(SendMoneyConfirmParam sendMoneyConfirmParam) {
        if (sendMoneyConfirmParam.getPayeeInfo() != null) {
            TransferParticipantDTO transferParticipantDTO = new TransferParticipantDTO();
            transferParticipantDTO.contactName = sendMoneyConfirmParam.getPayeeInfo().getContactName();
            transferParticipantDTO.loginId = sendMoneyConfirmParam.getPayeeInfo().getLoginId();
            transferParticipantDTO.dateOfBirth = sendMoneyConfirmParam.getPayeeInfo().getDateOfBirth();
            transferParticipantDTO.name = sendMoneyConfirmParam.getPayeeInfo().getNickname();
            return transferParticipantDTO;
        }
        return null;
    }
}
