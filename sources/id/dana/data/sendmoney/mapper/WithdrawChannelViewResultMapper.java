package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.PayMethodInfoResult;
import id.dana.data.sendmoney.model.WithdrawChannelOptionViewResult;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.withdraw.model.WithdrawChannelView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class WithdrawChannelViewResultMapper extends BaseMapper<List<WithdrawChannelOptionViewResult>, List<WithdrawChannelView>> {
    private CurrencyAmountResultMapper currencyAmountResultMapper;
    private PayMethodViewResultMapper payMethodViewResultMapper;

    @Inject
    public WithdrawChannelViewResultMapper(CurrencyAmountResultMapper currencyAmountResultMapper, PayMethodViewResultMapper payMethodViewResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
        this.payMethodViewResultMapper = payMethodViewResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<WithdrawChannelView> map(List<WithdrawChannelOptionViewResult> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (WithdrawChannelOptionViewResult withdrawChannelOptionViewResult : list) {
            WithdrawChannelView.Builder payOption = new WithdrawChannelView.Builder().enableStatus(withdrawChannelOptionViewResult.isEnableStatus()).instId(withdrawChannelOptionViewResult.getInstId()).instLocalName(withdrawChannelOptionViewResult.getInstLocalName()).instName(withdrawChannelOptionViewResult.getInstName()).payMethod(withdrawChannelOptionViewResult.getPayMethod()).payOption(withdrawChannelOptionViewResult.getPayOption());
            if (withdrawChannelOptionViewResult.getPayMethodInfos() != null) {
                payOption.payMethodInfos(transform(withdrawChannelOptionViewResult.getPayMethodInfos()));
            }
            arrayList.add(payOption.build());
        }
        return arrayList;
    }

    private List<PayOptionDTOResponse> transform(List<PayMethodInfoResult> list) {
        ArrayList arrayList = new ArrayList();
        for (PayMethodInfoResult payMethodInfoResult : list) {
            PayOptionDTOResponse payOptionDTOResponse = new PayOptionDTOResponse();
            payOptionDTOResponse.setPayMethod(payMethodInfoResult.getPayMethod());
            payOptionDTOResponse.setPayerMaxAmount(this.currencyAmountResultMapper.apply(payMethodInfoResult.getPayerMaxAmount()));
            payOptionDTOResponse.setPayerMinAmount(this.currencyAmountResultMapper.apply(payMethodInfoResult.getPayerMinAmount()));
            payOptionDTOResponse.setFundType(payMethodInfoResult.getFundType());
            payOptionDTOResponse.setPayMethodView(this.payMethodViewResultMapper.apply(payMethodInfoResult.getPayMethodView()));
            arrayList.add(payOptionDTOResponse);
        }
        return arrayList;
    }
}
