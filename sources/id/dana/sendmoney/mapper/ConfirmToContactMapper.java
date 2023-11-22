package id.dana.sendmoney.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.SendMoneyConfirmParam;
import id.dana.domain.sendmoney.model.TransferParticipant;
import id.dana.sendmoney.model.ConfirmToPeerParamModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ConfirmToContactMapper extends BaseMapper<ConfirmToPeerParamModel, SendMoneyConfirmParam> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ SendMoneyConfirmParam map(ConfirmToPeerParamModel confirmToPeerParamModel) {
        return PlaceComponentResult(confirmToPeerParamModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public ConfirmToContactMapper() {
    }

    public static SendMoneyConfirmParam PlaceComponentResult(ConfirmToPeerParamModel confirmToPeerParamModel) {
        SendMoneyConfirmParam sendMoneyConfirmParam = new SendMoneyConfirmParam();
        if (confirmToPeerParamModel != null) {
            sendMoneyConfirmParam.setAmount(confirmToPeerParamModel.DatabaseTableConfigUtil);
            sendMoneyConfirmParam.setCardIndexNo(confirmToPeerParamModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sendMoneyConfirmParam.setFundType(confirmToPeerParamModel.getErrorConfigVersion);
            sendMoneyConfirmParam.setPayMethod(confirmToPeerParamModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
            sendMoneyConfirmParam.setRemarks(confirmToPeerParamModel.getAuthRequestContext);
            sendMoneyConfirmParam.setOriginInstId(confirmToPeerParamModel.scheduleImpl);
            sendMoneyConfirmParam.setTransferScenario(confirmToPeerParamModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
            TransferParticipant transferParticipant = new TransferParticipant();
            transferParticipant.setUserId(confirmToPeerParamModel.lookAheadTest);
            transferParticipant.setLoginId(confirmToPeerParamModel.MyBillsEntityDataFactory);
            transferParticipant.setContactName(confirmToPeerParamModel.PlaceComponentResult);
            if (!TextUtils.isEmpty(confirmToPeerParamModel.lookAheadTest)) {
                transferParticipant.setNickname(confirmToPeerParamModel.moveToNextValue);
            }
            sendMoneyConfirmParam.setPayeeInfo(transferParticipant);
            sendMoneyConfirmParam.setCouponId(confirmToPeerParamModel.KClassImpl$Data$declaredNonStaticMembers$2);
            sendMoneyConfirmParam.setSplitBillId(confirmToPeerParamModel.GetContactSyncConfig);
            sendMoneyConfirmParam.setShareActivity(confirmToPeerParamModel.PlaceComponentResult());
            sendMoneyConfirmParam.setTransferMethod(confirmToPeerParamModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        return sendMoneyConfirmParam;
    }
}
