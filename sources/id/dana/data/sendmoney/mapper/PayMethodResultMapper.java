package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.PayMethodInfoResult;
import id.dana.data.sendmoney.model.TransferMethodInfoResult;
import id.dana.data.sendmoney.model.WithdrawBizMethodViewResult;
import id.dana.domain.sendmoney.model.AddPayMethod;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PayMethodResultMapper extends BaseMapper<TransferMethodInfoResult, List<PayOptionDTOResponse>> {
    private static final int INDEX_ZERO = 0;
    private List<AddPayMethod> addPayMethods;
    private final CurrencyAmountResultMapper currencyAmountResultMapper;
    private final PayMethodViewResultMapper payMethodViewResultMapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public PayMethodResultMapper(CurrencyAmountResultMapper currencyAmountResultMapper, PayMethodViewResultMapper payMethodViewResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
        this.payMethodViewResultMapper = payMethodViewResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<PayOptionDTOResponse> map(TransferMethodInfoResult transferMethodInfoResult) {
        ArrayList arrayList = new ArrayList();
        List<PayMethodInfoResult> paymethodInfoResult = getPaymethodInfoResult(transferMethodInfoResult);
        this.payMethodViewResultMapper.setAddPayMethods(this.addPayMethods);
        for (PayMethodInfoResult payMethodInfoResult : paymethodInfoResult) {
            PayOptionDTOResponse payOptionDTOResponse = new PayOptionDTOResponse();
            payOptionDTOResponse.setPayMethod(payMethodInfoResult.getPayMethod());
            payOptionDTOResponse.setPayerMaxAmount(this.currencyAmountResultMapper.apply(payMethodInfoResult.getPayerMaxAmount()));
            payOptionDTOResponse.setPayerMinAmount(this.currencyAmountResultMapper.apply(payMethodInfoResult.getPayerMinAmount()));
            payOptionDTOResponse.setFundType(payMethodInfoResult.getFundType());
            payOptionDTOResponse.setPayMethodView(this.payMethodViewResultMapper.apply(payMethodInfoResult.getPayMethodView()));
            payOptionDTOResponse.setPayeeMaxBalanceAmount(this.currencyAmountResultMapper.apply(payMethodInfoResult.getPayeeMaxBalanceAmount()));
            payOptionDTOResponse.setPayeeMonthConsumedAmount(this.currencyAmountResultMapper.apply(payMethodInfoResult.getPayeeMonthConsumedAmount()));
            payOptionDTOResponse.setPayeeMaxMonthFundInAmount(this.currencyAmountResultMapper.apply(payMethodInfoResult.getPayeeMaxMonthFundInAmount()));
            arrayList.add(payOptionDTOResponse);
        }
        return arrayList;
    }

    private List<PayMethodInfoResult> getPaymethodInfoResult(TransferMethodInfoResult transferMethodInfoResult) {
        if (transferMethodInfoResult != null) {
            if ("OTC".equals(transferMethodInfoResult.getTransferMethod()) && transferMethodInfoResult.getWithdrawMethodViews() != null) {
                List<WithdrawBizMethodViewResult> withdrawMethodViews = transferMethodInfoResult.getWithdrawMethodViews();
                if (withdrawMethodViews.size() > 0 && withdrawMethodViews.get(0) != null && withdrawMethodViews.get(0).withdrawChannelOptionViews != null && withdrawMethodViews.get(0).withdrawChannelOptionViews.size() > 0) {
                    return withdrawMethodViews.get(0).withdrawChannelOptionViews.get(0).getPayMethodInfos();
                }
            }
            return transferMethodInfoResult.getPayMethodInfos();
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAddPayMethods(List<AddPayMethod> list) {
        this.addPayMethods = list;
    }
}
