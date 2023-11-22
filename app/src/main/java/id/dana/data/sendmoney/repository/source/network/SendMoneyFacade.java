package id.dana.data.sendmoney.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.sendmoney.model.TransferOTCSubmitRequest;
import id.dana.data.sendmoney.repository.source.network.request.BizGroupModifyEntityRequest;
import id.dana.data.sendmoney.repository.source.network.request.BizTransferOrderCreateRequest;
import id.dana.data.sendmoney.repository.source.network.request.BizTransferPrePayRequest;
import id.dana.data.sendmoney.repository.source.network.request.SendMoneyInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.SendMoneyRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferOTCInitRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferSubmitRequest;
import id.dana.data.sendmoney.repository.source.network.request.WithdrawInitRequest;
import id.dana.data.sendmoney.repository.source.network.result.BizGroupModifyEntityResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferInitResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferOrderCreateResult;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferPrePayResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyInitResult;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyResult;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawInitResult;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;

/* loaded from: classes4.dex */
public interface SendMoneyFacade {
    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_INIT)
    @SignCheck
    BizTransferInitResult bizInit(TransferInitRequest transferInitRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_INIT)
    @SignCheck
    BizTransferInitResult bizOTCInit(TransferOTCInitRequest transferOTCInitRequest);

    @OperationType("alipayplus.mobilewallet.biztransfer.confirm")
    @SignCheck
    SendMoneyResult confirm(SendMoneyRequest sendMoneyRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_INIT)
    @SignCheck
    SendMoneyInitResult init(SendMoneyInitRequest sendMoneyInitRequest);

    @OperationType("alipayplus.mobilewallet.biztransfer.prepay")
    @SignCheck
    BizTransferPrePayResult initPrePay(BizTransferPrePayRequest bizTransferPrePayRequest);

    @OperationType(GroupSendOperationType.GROUP_MODIFY)
    @SignCheck
    BizGroupModifyEntityResult modifyGroup(BizGroupModifyEntityRequest bizGroupModifyEntityRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_SUBMIT)
    @SignCheck
    SendMoneyResult transferOTCSubmit(TransferOTCSubmitRequest transferOTCSubmitRequest);

    @OperationType("alipayplus.acquirebatch.order.create")
    @SignCheck
    BizTransferOrderCreateResult transferOrderCreate(BizTransferOrderCreateRequest bizTransferOrderCreateRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_SUBMIT)
    @SignCheck
    SendMoneyResult transferSubmit(TransferSubmitRequest transferSubmitRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.WITHDRAW_INIT)
    @SignCheck
    WithdrawInitResult withdrawInit(WithdrawInitRequest withdrawInitRequest);
}
