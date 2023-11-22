package id.dana.data.splitbill.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.splitbill.model.SplitBillDetailResult;
import id.dana.data.splitbill.model.SplitBillPayerResult;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.domain.splitbill.model.SplitBillPayer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SplitBillDetailResultMapper extends BaseMapper<SplitBillDetailResult, SplitBillHistory> {
    @Inject
    public SplitBillDetailResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public SplitBillHistory map(SplitBillDetailResult splitBillDetailResult) {
        if (splitBillDetailResult != null) {
            SplitBillHistory splitBillHistory = new SplitBillHistory();
            splitBillHistory.setSplitBillId(splitBillDetailResult.getSplitBillId());
            splitBillHistory.setComment(splitBillDetailResult.getComment());
            splitBillHistory.setStatus(splitBillDetailResult.getStatus());
            splitBillHistory.setDeeplink(splitBillDetailResult.getDeeplinkUrl());
            splitBillHistory.setPayers(map(splitBillDetailResult.getPayersResult()));
            splitBillHistory.setPayerIndex(splitBillDetailResult.getPayerIndex());
            splitBillHistory.setPayeeIndex(splitBillDetailResult.getPayeeIndex());
            return splitBillHistory;
        }
        return null;
    }

    private List<SplitBillPayer> map(List<SplitBillPayerResult> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SplitBillPayerResult splitBillPayerResult : list) {
                if (splitBillPayerResult != null) {
                    arrayList.add(map(splitBillPayerResult));
                }
            }
        }
        return arrayList;
    }

    private SplitBillPayer map(SplitBillPayerResult splitBillPayerResult) {
        SplitBillPayer splitBillPayer = new SplitBillPayer();
        splitBillPayer.setName(splitBillPayerResult.getName());
        splitBillPayer.setStatus(splitBillPayerResult.getStatus());
        splitBillPayer.setFundAmount(splitBillPayerResult.getFundAmount());
        splitBillPayer.setLoginId(splitBillPayerResult.getLoginId());
        splitBillPayer.setUserId(splitBillPayerResult.getUserId());
        splitBillPayer.setImageUrl(splitBillPayerResult.getAvatarUrl());
        return splitBillPayer;
    }
}
