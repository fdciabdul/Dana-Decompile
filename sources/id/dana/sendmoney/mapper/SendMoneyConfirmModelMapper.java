package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.sendmoney.model.SendMoneyConfirmModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SendMoneyConfirmModelMapper extends BaseMapper<SendMoneyConfirm, SendMoneyConfirmModel> {
    private final AttributesModelMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final PayMethodRiskMapper getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ SendMoneyConfirmModel map(SendMoneyConfirm sendMoneyConfirm) {
        SendMoneyConfirm sendMoneyConfirm2 = sendMoneyConfirm;
        if (sendMoneyConfirm2 != null) {
            SendMoneyConfirmModel sendMoneyConfirmModel = new SendMoneyConfirmModel();
            sendMoneyConfirmModel.getAuthRequestContext = sendMoneyConfirm2.getFundAmount();
            sendMoneyConfirmModel.KClassImpl$Data$declaredNonStaticMembers$2 = sendMoneyConfirm2.getCashierOrderId();
            sendMoneyConfirmModel.BuiltInFictitiousFunctionClassFactory = sendMoneyConfirm2.getFundOrderId();
            sendMoneyConfirmModel.getErrorConfigVersion = sendMoneyConfirm2.getRiskPhoneNumber();
            sendMoneyConfirmModel.PlaceComponentResult = PayMethodRiskMapper.KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyConfirm2.getPayMethodRiskResult());
            sendMoneyConfirmModel.MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.apply(sendMoneyConfirm2.getAttributes());
            sendMoneyConfirmModel.scheduleImpl = sendMoneyConfirm2.getPubkey();
            return sendMoneyConfirmModel;
        }
        return null;
    }

    @Inject
    public SendMoneyConfirmModelMapper(PayMethodRiskMapper payMethodRiskMapper, AttributesModelMapper attributesModelMapper) {
        this.getAuthRequestContext = payMethodRiskMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = attributesModelMapper;
    }
}
