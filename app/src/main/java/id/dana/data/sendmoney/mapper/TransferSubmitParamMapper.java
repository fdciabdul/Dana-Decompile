package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.TransferSubmitParam;
import id.dana.data.sendmoney.repository.source.network.request.TransferParticipantDTO;
import id.dana.domain.sendmoney.model.SendMoneyConfirmParam;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class TransferSubmitParamMapper extends BaseMapper<SendMoneyConfirmParam, TransferSubmitParam> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public TransferSubmitParamMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public TransferSubmitParam map(SendMoneyConfirmParam sendMoneyConfirmParam) {
        if (sendMoneyConfirmParam != null) {
            TransferSubmitParam transferSubmitParam = new TransferSubmitParam();
            transferSubmitParam.setAmount(sendMoneyConfirmParam.getAmount());
            transferSubmitParam.setCardIndexNo(sendMoneyConfirmParam.getCardIndexNo());
            transferSubmitParam.setFundType(sendMoneyConfirmParam.getFundType());
            transferSubmitParam.setPayMethod(sendMoneyConfirmParam.getPayMethod());
            transferSubmitParam.setRemarks(sendMoneyConfirmParam.getRemarks());
            transferSubmitParam.setAcceptTimeoutValue(sendMoneyConfirmParam.getAcceptTimeoutValue());
            transferSubmitParam.setAcceptTimeoutUnit(sendMoneyConfirmParam.getAcceptTimeoutUnit());
            transferSubmitParam.setOriginInstId(sendMoneyConfirmParam.getOriginInstId());
            transferSubmitParam.setPayeeInfo(getTransferParticipant(sendMoneyConfirmParam));
            transferSubmitParam.setTransferScenario(sendMoneyConfirmParam.getTransferScenario());
            transferSubmitParam.setCouponIds(getCouponIds(sendMoneyConfirmParam));
            transferSubmitParam.setSplitBillId(sendMoneyConfirmParam.getSplitBillId());
            transferSubmitParam.setShareActivity(sendMoneyConfirmParam.isShareActivity());
            transferSubmitParam.setTransferMethod(sendMoneyConfirmParam.getTransferMethod());
            return transferSubmitParam;
        }
        return null;
    }

    private List<String> getCouponIds(SendMoneyConfirmParam sendMoneyConfirmParam) {
        ArrayList arrayList = new ArrayList();
        if (sendMoneyConfirmParam != null && sendMoneyConfirmParam.getCouponId() != null) {
            arrayList.add(sendMoneyConfirmParam.getCouponId());
        }
        return arrayList;
    }

    private TransferParticipantDTO getTransferParticipant(SendMoneyConfirmParam sendMoneyConfirmParam) {
        if (sendMoneyConfirmParam.getPayeeInfo() != null) {
            TransferParticipantDTO transferParticipantDTO = new TransferParticipantDTO();
            transferParticipantDTO.userId = sendMoneyConfirmParam.getPayeeInfo().getUserId();
            transferParticipantDTO.loginId = sendMoneyConfirmParam.getPayeeInfo().getLoginId();
            transferParticipantDTO.regId = sendMoneyConfirmParam.getPayeeInfo().getRegId();
            transferParticipantDTO.nickname = sendMoneyConfirmParam.getPayeeInfo().getNickname();
            transferParticipantDTO.contactName = sendMoneyConfirmParam.getPayeeInfo().getContactName();
            return transferParticipantDTO;
        }
        return null;
    }
}
