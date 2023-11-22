package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.PayOptionResult;
import id.dana.domain.payasset.model.PayCardOptionView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class PayOptionsResultMapper extends BaseMapper<List<PayOptionResult>, List<PayCardOptionView>> {
    @Inject
    public PayOptionsResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<PayCardOptionView> map(List<PayOptionResult> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PayOptionResult payOptionResult : list) {
            arrayList.add(new PayCardOptionView.Builder().setBindingId(payOptionResult.bindingId).setCardIndexNo(payOptionResult.cardIndexNo).setCardNoLength(payOptionResult.cardNoLength).setEnableStatus(payOptionResult.enableStatus).setHolderName(payOptionResult.holderName).setMaskedCardNo(payOptionResult.maskedCardNo).setInstId(payOptionResult.instId).setInstName(payOptionResult.instName).setInsLocalName(payOptionResult.instLocalName).setPayMethod(payOptionResult.payMethod).setPayOption(payOptionResult.payOption).setExpiryMonth(payOptionResult.expiryMonth).setExpiryYear(payOptionResult.expiryYear).setDefaultCard(payOptionResult.defaultCard).setPayWithoutCVV(payOptionResult.payWithoutCVV).setCardScheme(payOptionResult.cardScheme).build());
        }
        return arrayList;
    }
}
