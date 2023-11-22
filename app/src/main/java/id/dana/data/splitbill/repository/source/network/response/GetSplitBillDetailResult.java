package id.dana.data.splitbill.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.splitbill.model.SplitBillDetailResult;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class GetSplitBillDetailResult extends BaseRpcResult implements Serializable {
    private SplitBillDetailResult splitBillOrder;

    public SplitBillDetailResult getSplitBillOrder() {
        return this.splitBillOrder;
    }

    public void setSplitBillOrder(SplitBillDetailResult splitBillDetailResult) {
        this.splitBillOrder = splitBillDetailResult;
    }
}
