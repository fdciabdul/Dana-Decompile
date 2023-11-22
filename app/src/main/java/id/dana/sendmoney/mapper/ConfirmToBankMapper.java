package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.SendMoneyConfirmParam;
import id.dana.sendmoney.model.ConfirmToBankParamModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ConfirmToBankMapper extends BaseMapper<ConfirmToBankParamModel, SendMoneyConfirmParam> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ SendMoneyConfirmParam map(ConfirmToBankParamModel confirmToBankParamModel) {
        ConfirmToBankParamModel confirmToBankParamModel2 = confirmToBankParamModel;
        SendMoneyConfirmParam sendMoneyConfirmParam = new SendMoneyConfirmParam();
        if (confirmToBankParamModel2 != null) {
            sendMoneyConfirmParam.setAmount(confirmToBankParamModel2.BuiltInFictitiousFunctionClassFactory);
            sendMoneyConfirmParam.setCardIndexNo(confirmToBankParamModel2.MyBillsEntityDataFactory);
            sendMoneyConfirmParam.setFundType(confirmToBankParamModel2.moveToNextValue);
            sendMoneyConfirmParam.setPayMethod(confirmToBankParamModel2.lookAheadTest);
            sendMoneyConfirmParam.setRemarks(confirmToBankParamModel2.scheduleImpl);
            sendMoneyConfirmParam.setAcceptTimeoutUnit(confirmToBankParamModel2.PlaceComponentResult);
            sendMoneyConfirmParam.setAcceptTimeoutValue(confirmToBankParamModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            sendMoneyConfirmParam.setOriginInstId(confirmToBankParamModel2.getErrorConfigVersion);
            sendMoneyConfirmParam.setCouponId(confirmToBankParamModel2.getAuthRequestContext);
            sendMoneyConfirmParam.setTransferScenario(confirmToBankParamModel2.NetworkUserEntityData$$ExternalSyntheticLambda2);
            sendMoneyConfirmParam.setPayeeInfo(confirmToBankParamModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sendMoneyConfirmParam.setTransferMethod(confirmToBankParamModel2.DatabaseTableConfigUtil);
        }
        return sendMoneyConfirmParam;
    }

    @Inject
    public ConfirmToBankMapper() {
    }
}
