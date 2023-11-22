package id.dana.pay;

import id.dana.domain.payasset.model.PayCardOptionView;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PayCardInfoMapper {
    @Inject
    public PayCardInfoMapper() {
    }

    public static PayCardInfo PlaceComponentResult(PayCardOptionView payCardOptionView) {
        if (payCardOptionView != null) {
            PayCardInfo payCardInfo = new PayCardInfo();
            payCardInfo.PlaceComponentResult = payCardOptionView.getAssetType();
            payCardInfo.BuiltInFictitiousFunctionClassFactory = payCardOptionView.getCardIndexNo();
            payCardInfo.MyBillsEntityDataFactory = payCardOptionView.getCardNoLength();
            payCardInfo.getAuthRequestContext = payCardOptionView.getCardScheme();
            payCardInfo.KClassImpl$Data$declaredNonStaticMembers$2 = payCardOptionView.getExpiryMonth();
            payCardInfo.NetworkUserEntityData$$ExternalSyntheticLambda0 = payCardOptionView.getExpiryYear();
            payCardInfo.getErrorConfigVersion = payCardOptionView.getInstId();
            payCardInfo.scheduleImpl = payCardOptionView.getInstName();
            payCardInfo.lookAheadTest = payCardOptionView.getMaskedCardNo();
            payCardInfo.DatabaseTableConfigUtil = payCardOptionView.getPayMethod();
            payCardInfo.GetContactSyncConfig = payCardOptionView.getPayOption();
            payCardInfo.initRecordTimeStamp = payCardOptionView.isPayWithoutCVV();
            payCardInfo.moveToNextValue = payCardOptionView.getOfflinePayIndex();
            return payCardInfo;
        }
        return null;
    }
}
