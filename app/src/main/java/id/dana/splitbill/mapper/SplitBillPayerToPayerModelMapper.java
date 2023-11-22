package id.dana.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.model.CurrencyAmountModel;
import id.dana.splitbill.model.PayerModel;
import id.dana.splitbill.model.SplitBillPayerModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillPayerToPayerModelMapper extends BaseMapper<List<SplitBillPayerModel>, List<PayerModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<PayerModel> map(List<SplitBillPayerModel> list) {
        PayerModel payerModel;
        String str;
        List<SplitBillPayerModel> list2 = list;
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            for (SplitBillPayerModel splitBillPayerModel : list2) {
                if (splitBillPayerModel != null) {
                    String str2 = splitBillPayerModel.MyBillsEntityDataFactory;
                    CurrencyAmountModel currencyAmountModel = splitBillPayerModel.getAuthRequestContext;
                    String str3 = splitBillPayerModel.scheduleImpl;
                    if (splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0.equals("-")) {
                        str = splitBillPayerModel.moveToNextValue;
                    } else {
                        str = splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    }
                    payerModel = new PayerModel(str2, currencyAmountModel, str3, str, splitBillPayerModel.lookAheadTest, splitBillPayerModel.getErrorConfigVersion);
                } else {
                    payerModel = null;
                }
                arrayList.add(payerModel);
            }
        }
        return arrayList;
    }

    @Inject
    public SplitBillPayerToPayerModelMapper() {
    }
}
