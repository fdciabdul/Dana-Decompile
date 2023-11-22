package id.dana.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.splitbill.model.SplitBillPayer;
import id.dana.model.CurrencyAmountModel;
import id.dana.splitbill.model.SplitBillPayerModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class SplitBillPayerModelMapper extends BaseMapper<List<SplitBillPayer>, List<SplitBillPayerModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<SplitBillPayerModel> map(List<SplitBillPayer> list) {
        List<SplitBillPayer> list2 = list;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (SplitBillPayer splitBillPayer : list2) {
                SplitBillPayerModel splitBillPayerModel = new SplitBillPayerModel();
                splitBillPayerModel.lookAheadTest = splitBillPayer.getUserId();
                splitBillPayerModel.getAuthRequestContext = new CurrencyAmountModel(splitBillPayer.getFundAmount(), "Rp");
                splitBillPayerModel.MyBillsEntityDataFactory = splitBillPayer.getImageUrl();
                splitBillPayerModel.scheduleImpl = splitBillPayer.getLoginId();
                splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = splitBillPayer.getName();
                arrayList.add(splitBillPayerModel);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @Inject
    public SplitBillPayerModelMapper() {
    }
}
