package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.TransferSubmitParam;
import id.dana.data.sendmoney.repository.source.network.request.TransferParticipantDTO;
import id.dana.data.sendmoney.repository.source.network.request.TransferSubmitRequest;
import id.dana.domain.sendmoney.TransferScenario;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class TransferSubmitRequestMapper extends BaseMapper<TransferSubmitParam, TransferSubmitRequest> {
    @Inject
    public TransferSubmitRequestMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public TransferSubmitRequest map(TransferSubmitParam transferSubmitParam) {
        if (transferSubmitParam != null) {
            TransferSubmitRequest transferSubmitRequest = new TransferSubmitRequest();
            transferSubmitRequest.amount = transferSubmitParam.getAmount();
            transferSubmitRequest.fundType = transferSubmitParam.getFundType();
            transferSubmitRequest.remarks = transferSubmitParam.getRemarks();
            transferSubmitRequest.payMethod = transferSubmitParam.getPayMethod();
            transferSubmitRequest.payeeInfo = getTransferParticipant(transferSubmitParam);
            transferSubmitRequest.requestId = transferSubmitParam.getRequestId();
            transferSubmitRequest.acceptTimeoutValue = transferSubmitParam.getAcceptTimeoutValue();
            transferSubmitRequest.acceptTimeoutUnit = transferSubmitParam.getAcceptTimeoutUnit();
            transferSubmitRequest.instId = transferSubmitParam.getOriginInstId();
            transferSubmitRequest.transferScenario = transferSubmitParam.getTransferScenario();
            transferSubmitRequest.couponIds = transferSubmitParam.getCouponIds();
            transferSubmitRequest.setTransferMethod(transferSubmitParam.getTransferMethod());
            if (TransferScenario.SPLIT_BILL.equals(transferSubmitParam.getTransferScenario())) {
                transferSubmitRequest.splitBillId = transferSubmitParam.getSplitBillId();
            }
            transferSubmitRequest.shareActivity = transferSubmitParam.isShareActivity();
            return transferSubmitRequest;
        }
        return null;
    }

    private TransferParticipantDTO getTransferParticipant(TransferSubmitParam transferSubmitParam) {
        TransferParticipantDTO transferParticipantDTO = new TransferParticipantDTO();
        transferParticipantDTO.bankAccountIndexNo = transferSubmitParam.getCardIndexNo();
        if (transferSubmitParam.getPayeeInfo() != null) {
            transferParticipantDTO.contactName = transferSubmitParam.getPayeeInfo().contactName;
            transferParticipantDTO.nickname = transferSubmitParam.getPayeeInfo().nickname;
            transferParticipantDTO.loginId = transferSubmitParam.getPayeeInfo().loginId;
            transferParticipantDTO.userId = transferSubmitParam.getPayeeInfo().userId;
        }
        return transferParticipantDTO;
    }
}
