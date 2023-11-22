package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.PayChannelResult;
import id.dana.domain.payasset.model.PayChannelOptionView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PayChannelResultMapper extends BaseMapper<List<PayChannelResult>, List<PayChannelOptionView>> {
    private final CurrencyAmountResultMapper currencyAmountResultMapper;

    @Inject
    public PayChannelResultMapper(CurrencyAmountResultMapper currencyAmountResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<PayChannelOptionView> map(List<PayChannelResult> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PayChannelResult payChannelResult : list) {
            arrayList.add(new PayChannelOptionView.Builder().setEnableStatus(payChannelResult.enableStatus).setInstId(payChannelResult.instId).setInstName(payChannelResult.instName).setPayMethod(payChannelResult.payMethod).setPayOption(payChannelResult.payOption).setDisableReason(payChannelResult.disableReason).setMinAmount(this.currencyAmountResultMapper.apply(payChannelResult.minAmount)).setMaxAmount(this.currencyAmountResultMapper.apply(payChannelResult.maxAmount)).setSupportCountries(payChannelResult.supportCountries).build());
        }
        return arrayList;
    }
}
