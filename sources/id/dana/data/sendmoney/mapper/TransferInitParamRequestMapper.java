package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.repository.source.network.request.TransferInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferParticipantDTO;
import id.dana.domain.sendmoney.model.TransferInitParam;
import id.dana.domain.sendmoney.model.TransferParticipant;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class TransferInitParamRequestMapper extends BaseMapper<TransferInitParam, TransferInitRequest> {
    @Inject
    public TransferInitParamRequestMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public TransferInitRequest map(TransferInitParam transferInitParam) {
        if (transferInitParam != null) {
            TransferInitRequest transferInitRequest = new TransferInitRequest();
            transferInitRequest.setNeedTransferMethod(transferInitParam.isNeedTransferMethod());
            transferInitRequest.setNeedWithdrawMethod(transferInitParam.isNeedWithdrawMethod());
            transferInitRequest.setNeedPayMethod(transferInitParam.isNeedPayMethod());
            transferInitRequest.setPayeeInfo(getParticipantDTO(transferInitParam.getPayeeInfo()));
            transferInitRequest.setTransferMethod(transferInitParam.getTransferMethod());
            transferInitRequest.setAmount(transferInitParam.getAmount());
            transferInitRequest.setVersion(transferInitParam.getVersion());
            return transferInitRequest;
        }
        return null;
    }

    private TransferParticipantDTO getParticipantDTO(TransferParticipant transferParticipant) {
        if (transferParticipant != null) {
            if (transferParticipant.getLoginId() == null && transferParticipant.getUserId() == null) {
                return null;
            }
            TransferParticipantDTO transferParticipantDTO = new TransferParticipantDTO();
            transferParticipantDTO.bankAccountIndexNo = transferParticipant.getBankAccountIndexNo();
            transferParticipantDTO.loginId = transferParticipant.getLoginId();
            transferParticipantDTO.regId = transferParticipant.getRegId();
            transferParticipantDTO.userId = transferParticipant.getUserId();
            return transferParticipantDTO;
        }
        return null;
    }
}
