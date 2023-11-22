package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.TransferMethodInfoResult;
import id.dana.domain.sendmoney.model.AddPayMethod;
import id.dana.domain.withdraw.model.TransferMethodView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class WithdrawMethodViewResultMapper extends BaseMapper<List<TransferMethodInfoResult>, List<TransferMethodView>> {
    private List<AddPayMethod> addPayMethods;
    private final CurrencyAmountResultMapper currencyAmountResultMapper;
    private final PayMethodResultMapper payMethodResultMapper;
    private final WithdrawMethodOptionsResultMapper withdrawMethodOptionsResultMapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public WithdrawMethodViewResultMapper(CurrencyAmountResultMapper currencyAmountResultMapper, WithdrawMethodOptionsResultMapper withdrawMethodOptionsResultMapper, PayMethodResultMapper payMethodResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
        this.withdrawMethodOptionsResultMapper = withdrawMethodOptionsResultMapper;
        this.payMethodResultMapper = payMethodResultMapper;
    }

    @Override // id.dana.data.base.BaseMapper
    public List<TransferMethodView> map(List<TransferMethodInfoResult> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            this.payMethodResultMapper.setAddPayMethods(this.addPayMethods);
            for (TransferMethodInfoResult transferMethodInfoResult : list) {
                arrayList.add(new TransferMethodView.Builder().chargeAmount(this.currencyAmountResultMapper.map(transferMethodInfoResult.getChargeAmount())).freeRemainedTimes(transferMethodInfoResult.getFreeRemainingTimes()).freeMinAmount(this.currencyAmountResultMapper.map(transferMethodInfoResult.getFreeMinAmount())).freeTimes(transferMethodInfoResult.getFreeTimes()).withdrawMethodOptions(this.withdrawMethodOptionsResultMapper.map(transferMethodInfoResult.getWithdrawMethodViews())).transferMethod(transferMethodInfoResult.getTransferMethod()).setTransferMaxAmount(this.currencyAmountResultMapper.map(transferMethodInfoResult.getTransferMaxAmount())).setTransferMinAmount(this.currencyAmountResultMapper.map(transferMethodInfoResult.getTransferMinAmount())).setPayOptionDTOResponses(this.payMethodResultMapper.map(transferMethodInfoResult)).setPayeeMaxBalanceAmount(this.currencyAmountResultMapper.map(transferMethodInfoResult.getPayeeMaxBalanceAmount())).setPayeeMaxMonthFundInAmount(this.currencyAmountResultMapper.map(transferMethodInfoResult.getPayeeMaxMonthFundInAmount())).setPayeeMonthConsumedAmount(this.currencyAmountResultMapper.map(transferMethodInfoResult.getPayeeMonthConsumedAmount())).build());
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAddPayMethods(List<AddPayMethod> list) {
        this.addPayMethods = list;
    }
}
