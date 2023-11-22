package id.dana.data.splitbill.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.splitbill.model.SplitBillHistoryResult;
import java.util.List;

/* loaded from: classes4.dex */
public class GetSplitBillHistoriesResult extends BaseRpcResult {
    private List<SplitBillHistoryResult> splitBillHistoryList;

    public List<SplitBillHistoryResult> getSplitBillHistoryList() {
        return this.splitBillHistoryList;
    }

    public void setSplitBillHistoryList(List<SplitBillHistoryResult> list) {
        this.splitBillHistoryList = list;
    }
}
