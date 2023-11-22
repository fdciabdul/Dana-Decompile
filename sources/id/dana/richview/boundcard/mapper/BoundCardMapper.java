package id.dana.richview.boundcard.mapper;

import id.dana.domain.payasset.model.PayChannelOptionView;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.model.UserInfo;
import id.dana.pay.PayCardInfo;
import id.dana.richview.boundcard.model.BoundCard;
import id.dana.richview.boundcard.model.PayChannelOptionViewDTO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class BoundCardMapper {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public BoundCardMapper() {
    }

    public static BoundCard BuiltInFictitiousFunctionClassFactory(SendMoneyInit sendMoneyInit) {
        BoundCard boundCard = new BoundCard();
        boundCard.getAuthRequestContext = sendMoneyInit.getAmount();
        boundCard.MyBillsEntityDataFactory = sendMoneyInit.getCurrency();
        boundCard.GetContactSyncConfig = sendMoneyInit.getPayeeMaskedPhoneNumber();
        boundCard.initRecordTimeStamp = sendMoneyInit.getKyc().getLevel();
        boundCard.NetworkUserEntityData$$ExternalSyntheticLambda7 = "BALANCE";
        return boundCard;
    }

    public static PayChannelOptionViewDTO BuiltInFictitiousFunctionClassFactory(PayChannelOptionView payChannelOptionView) {
        if (payChannelOptionView != null) {
            PayChannelOptionViewDTO payChannelOptionViewDTO = new PayChannelOptionViewDTO();
            payChannelOptionViewDTO.setEnableStatus(Boolean.valueOf(payChannelOptionView.isEnableStatus()));
            payChannelOptionViewDTO.setInstId(payChannelOptionView.getInstId());
            payChannelOptionViewDTO.setInstName(payChannelOptionView.getInstName());
            payChannelOptionViewDTO.setPayOption(payChannelOptionView.getPayOption());
            return payChannelOptionViewDTO;
        }
        return null;
    }

    public static List<BoundCard> getAuthRequestContext(List<PayCardInfo> list, UserInfo userInfo) {
        BoundCard boundCard;
        ArrayList arrayList = new ArrayList();
        BoundCard boundCard2 = new BoundCard();
        boundCard2.NetworkUserEntityData$$ExternalSyntheticLambda7 = "BALANCE";
        if (userInfo != null) {
            boundCard2.getAuthRequestContext = userInfo.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            boundCard2.MyBillsEntityDataFactory = userInfo.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            boundCard2.initRecordTimeStamp = userInfo.DatabaseTableConfigUtil.PlaceComponentResult;
        }
        arrayList.add(boundCard2);
        for (PayCardInfo payCardInfo : list) {
            if (payCardInfo != null) {
                boundCard = new BoundCard();
                boundCard.GetContactSyncConfig = payCardInfo.lookAheadTest;
                boundCard.BuiltInFictitiousFunctionClassFactory = payCardInfo.getAuthRequestContext;
                boundCard.getErrorConfigVersion = payCardInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                boundCard.NetworkUserEntityData$$ExternalSyntheticLambda0 = payCardInfo.NetworkUserEntityData$$ExternalSyntheticLambda0;
                boundCard.lookAheadTest = payCardInfo.getErrorConfigVersion;
                boundCard.KClassImpl$Data$declaredNonStaticMembers$2 = payCardInfo.BuiltInFictitiousFunctionClassFactory;
                boundCard.DatabaseTableConfigUtil = payCardInfo.scheduleImpl;
                boundCard.NetworkUserEntityData$$ExternalSyntheticLambda7 = payCardInfo.DatabaseTableConfigUtil;
                boundCard.NetworkUserEntityData$$ExternalSyntheticLambda1 = payCardInfo.BuiltInFictitiousFunctionClassFactory();
                boundCard.PlaceComponentResult = payCardInfo.PlaceComponentResult;
            } else {
                boundCard = null;
            }
            arrayList.add(boundCard);
        }
        return arrayList;
    }
}
