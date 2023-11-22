package id.dana.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.domain.splitbill.model.SplitBillPayer;
import id.dana.model.CurrencyAmountModel;
import id.dana.splitbill.model.PayerModel;
import id.dana.splitbill.model.SplitBillHistoryModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillDetailMapper extends BaseMapper<SplitBillHistory, SplitBillHistoryModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ SplitBillHistoryModel map(SplitBillHistory splitBillHistory) {
        SplitBillHistory splitBillHistory2 = splitBillHistory;
        if (splitBillHistory2 != null) {
            SplitBillHistoryModel splitBillHistoryModel = new SplitBillHistoryModel();
            splitBillHistoryModel.getErrorConfigVersion = splitBillHistory2.getSplitBillId();
            splitBillHistoryModel.PlaceComponentResult = splitBillHistory2.getDeeplink();
            splitBillHistoryModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = splitBillHistory2.getStatus();
            splitBillHistoryModel.BuiltInFictitiousFunctionClassFactory = splitBillHistory2.getComment();
            List<SplitBillPayer> payers = splitBillHistory2.getPayers();
            ArrayList arrayList = new ArrayList();
            if (payers != null) {
                for (SplitBillPayer splitBillPayer : payers) {
                    if (splitBillPayer != null) {
                        arrayList.add(new PayerModel(splitBillPayer.getImageUrl(), new CurrencyAmountModel(splitBillPayer.getFundAmount(), "Rp"), splitBillPayer.getLoginId(), splitBillPayer.getName(), splitBillPayer.getUserId(), splitBillPayer.getStatus()));
                    }
                }
            }
            splitBillHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
            Iterator<SplitBillPayer> it = splitBillHistory2.getPayers().iterator();
            long j = 0;
            while (it.hasNext()) {
                j += Long.valueOf(it.next().getFundAmount()).longValue();
            }
            splitBillHistoryModel.lookAheadTest = String.valueOf(j);
            splitBillHistoryModel.MyBillsEntityDataFactory = Integer.parseInt(splitBillHistory2.getPayeeIndex());
            splitBillHistoryModel.getAuthRequestContext = Integer.parseInt(splitBillHistory2.getPayerIndex());
            return splitBillHistoryModel;
        }
        return null;
    }

    @Inject
    public SplitBillDetailMapper() {
    }
}
