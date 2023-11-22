package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.domain.user.CurrencyAmount;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class CurrencyAmountResultMapper extends BaseMapper<CurrencyAmountResult, CurrencyAmount> {
    @Inject
    public CurrencyAmountResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public CurrencyAmount map(CurrencyAmountResult currencyAmountResult) {
        if (currencyAmountResult == null) {
            return null;
        }
        return new CurrencyAmount(currencyAmountResult.getAmount(), currencyAmountResult.getCurrency(), currencyAmountResult.isPlaceholder());
    }
}
