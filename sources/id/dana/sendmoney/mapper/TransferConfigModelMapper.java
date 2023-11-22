package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.withdraw.model.TransferMethodView;
import id.dana.sendmoney.model.PayOptionDTO;
import id.dana.sendmoney.model.WithdrawConfigModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class TransferConfigModelMapper extends BaseMapper<TransferInit, WithdrawConfigModel> {
    private final CurrencyAmountModelMapper PlaceComponentResult;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ WithdrawConfigModel map(TransferInit transferInit) {
        List<TransferMethodView> transferMethod;
        TransferInit transferInit2 = transferInit;
        if (transferInit2 == null || (transferMethod = transferInit2.getTransferMethod()) == null || transferMethod.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean isNeedSenderName = transferInit2.isNeedSenderName();
        int i = 0;
        int i2 = 0;
        for (TransferMethodView transferMethodView : transferMethod) {
            arrayList.add(new WithdrawConfigModel.Config(CurrencyAmountModelMapper.getAuthRequestContext(transferMethodView.getChargeAmount()), transferMethodView.getTransferMethod(), getAuthRequestContext(transferMethodView.getPayOptionDTOResponses())));
            int freeTimes = (int) transferMethodView.getFreeTimes();
            i2 = (int) transferMethodView.getFreeRemainedTimes();
            i = freeTimes;
        }
        return new WithdrawConfigModel(arrayList, isNeedSenderName, i, i2);
    }

    @Inject
    public TransferConfigModelMapper(CurrencyAmountModelMapper currencyAmountModelMapper) {
        this.PlaceComponentResult = currencyAmountModelMapper;
    }

    private List<PayOptionDTO> getAuthRequestContext(List<PayOptionDTOResponse> list) {
        PayOptionDTO payOptionDTO;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PayOptionDTOResponse payOptionDTOResponse : list) {
            if (payOptionDTOResponse != null) {
                payOptionDTO = new PayOptionDTO();
                payOptionDTO.MyBillsEntityDataFactory = payOptionDTOResponse.getPayMethod();
                payOptionDTO.PlaceComponentResult = payOptionDTOResponse.getFundType();
                payOptionDTO.BuiltInFictitiousFunctionClassFactory = CurrencyAmountModelMapper.getAuthRequestContext(payOptionDTOResponse.getPayerMaxAmount());
                payOptionDTO.getAuthRequestContext = CurrencyAmountModelMapper.getAuthRequestContext(payOptionDTOResponse.getPayerMinAmount());
            } else {
                payOptionDTO = null;
            }
            arrayList.add(payOptionDTO);
        }
        return arrayList;
    }
}
