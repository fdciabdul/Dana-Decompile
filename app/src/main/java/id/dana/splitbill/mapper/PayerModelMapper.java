package id.dana.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.splitbill.model.SplitBillPayer;
import id.dana.model.CurrencyAmountModel;
import id.dana.splitbill.model.PayerModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PayerModelMapper extends BaseMapper<SplitBillPayer, PayerModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ PayerModel map(SplitBillPayer splitBillPayer) {
        return BuiltInFictitiousFunctionClassFactory(splitBillPayer);
    }

    @Inject
    public PayerModelMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PayerModel BuiltInFictitiousFunctionClassFactory(SplitBillPayer splitBillPayer) {
        if (splitBillPayer != null) {
            return new PayerModel(splitBillPayer.getImageUrl(), new CurrencyAmountModel(splitBillPayer.getFundAmount(), "Rp"), splitBillPayer.getLoginId(), splitBillPayer.getName(), splitBillPayer.getUserId(), splitBillPayer.getStatus());
        }
        return null;
    }
}
