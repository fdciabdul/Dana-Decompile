package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.sendmoney.model.PayOptionDTO;
import id.dana.sendmoney.model.SendMoneyInitModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SendMoneyInitMapper extends BaseMapper<SendMoneyInit, SendMoneyInitModel> {
    private final CurrencyAmountModelMapper getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ SendMoneyInitModel map(SendMoneyInit sendMoneyInit) {
        ArrayList arrayList;
        PayOptionDTO payOptionDTO;
        SendMoneyInit sendMoneyInit2 = sendMoneyInit;
        if (sendMoneyInit2 == null) {
            return null;
        }
        SendMoneyInitModel sendMoneyInitModel = new SendMoneyInitModel();
        sendMoneyInitModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = CurrencyAmountModelMapper.getAuthRequestContext(sendMoneyInit2.getPayerMinAmount());
        sendMoneyInitModel.getErrorConfigVersion = CurrencyAmountModelMapper.getAuthRequestContext(sendMoneyInit2.getPayerMaxAmount());
        sendMoneyInitModel.scheduleImpl = sendMoneyInit2.getAmount();
        sendMoneyInitModel.lookAheadTest = sendMoneyInit2.getCurrency();
        sendMoneyInitModel.moveToNextValue = sendMoneyInit2.getPayeeUserId();
        sendMoneyInitModel.KClassImpl$Data$declaredNonStaticMembers$2 = sendMoneyInit2.getPayeeMaskedPhoneNumber();
        sendMoneyInitModel.getAuthRequestContext = sendMoneyInit2.getPayeeMaskedNickname();
        List<PayOptionDTOResponse> payOptions = sendMoneyInit2.getPayOptions();
        if (payOptions == null || payOptions.isEmpty()) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList();
            for (PayOptionDTOResponse payOptionDTOResponse : payOptions) {
                if (payOptionDTOResponse.isPayMethodFlag()) {
                    if (payOptionDTOResponse == null) {
                        payOptionDTO = null;
                    } else {
                        payOptionDTO = new PayOptionDTO();
                        payOptionDTO.MyBillsEntityDataFactory = payOptionDTOResponse.getPayMethod();
                        payOptionDTO.BuiltInFictitiousFunctionClassFactory = CurrencyAmountModelMapper.getAuthRequestContext(payOptionDTOResponse.getPayerMaxAmount());
                        payOptionDTO.getAuthRequestContext = CurrencyAmountModelMapper.getAuthRequestContext(payOptionDTOResponse.getPayerMinAmount());
                    }
                    arrayList.add(payOptionDTO);
                }
            }
        }
        sendMoneyInitModel.BuiltInFictitiousFunctionClassFactory = arrayList;
        sendMoneyInitModel.MyBillsEntityDataFactory = sendMoneyInit2.getAvatarUrl();
        if (sendMoneyInit2.getKyc() != null) {
            sendMoneyInitModel.PlaceComponentResult = sendMoneyInit2.getKyc().getLevel();
        }
        return sendMoneyInitModel;
    }

    @Inject
    public SendMoneyInitMapper(CurrencyAmountModelMapper currencyAmountModelMapper) {
        this.getAuthRequestContext = currencyAmountModelMapper;
    }
}
