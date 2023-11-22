package id.dana.data.splitbill.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.splitbill.repository.source.network.request.GetSplitBillCloseRequest;
import id.dana.data.splitbill.repository.source.network.request.GetSplitBillDetailRequest;
import id.dana.data.splitbill.repository.source.network.request.GetSplitBillHistoriesRequest;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillDetailResult;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillHistoriesResult;

/* loaded from: classes4.dex */
public interface SplitBillFacade {
    @OperationType("dana.mobilewallet.splitbill.closepayers")
    @SignCheck
    BaseRpcResult closePayers(GetSplitBillCloseRequest getSplitBillCloseRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.SPLIT_BILL_DETAIL)
    @SignCheck
    GetSplitBillDetailResult getSplitBillDetail(GetSplitBillDetailRequest getSplitBillDetailRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.SPLIT_BILL_GET_HISTORY)
    @SignCheck
    GetSplitBillHistoriesResult getSplitBillHistories(GetSplitBillHistoriesRequest getSplitBillHistoriesRequest);
}
