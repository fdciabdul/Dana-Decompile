package id.dana.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.splitbill.model.SplitBillPayer;
import id.dana.splitbill.model.PayerModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PayerModelListMapper extends BaseMapper<List<SplitBillPayer>, List<PayerModel>> {
    private PayerModelMapper getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<PayerModel> map(List<SplitBillPayer> list) {
        List<SplitBillPayer> list2 = list;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (SplitBillPayer splitBillPayer : list2) {
                if (splitBillPayer != null) {
                    arrayList.add(PayerModelMapper.BuiltInFictitiousFunctionClassFactory(splitBillPayer));
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @Inject
    public PayerModelListMapper(PayerModelMapper payerModelMapper) {
        this.getAuthRequestContext = payerModelMapper;
    }
}
