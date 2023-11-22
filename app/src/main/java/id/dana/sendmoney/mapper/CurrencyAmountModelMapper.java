package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.user.CurrencyAmount;
import id.dana.model.CurrencyAmountModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CurrencyAmountModelMapper extends BaseMapper<CurrencyAmount, CurrencyAmountModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ CurrencyAmountModel map(CurrencyAmount currencyAmount) {
        CurrencyAmount currencyAmount2 = currencyAmount;
        if (currencyAmount2 == null) {
            return null;
        }
        return new CurrencyAmountModel(currencyAmount2.getAmount(), currencyAmount2.getCurrency(), currencyAmount2.isPlaceholder());
    }

    @Inject
    public CurrencyAmountModelMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CurrencyAmountModel getAuthRequestContext(CurrencyAmount currencyAmount) {
        if (currencyAmount == null) {
            return null;
        }
        return new CurrencyAmountModel(currencyAmount.getAmount(), currencyAmount.getCurrency(), currencyAmount.isPlaceholder());
    }
}
