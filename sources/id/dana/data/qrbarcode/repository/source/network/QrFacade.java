package id.dana.data.qrbarcode.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.model.DefaultInfoResult;
import id.dana.data.qrbarcode.repository.source.network.request.DecodeQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.PreCreateOrderEntityRequest;
import id.dana.data.qrbarcode.repository.source.network.request.SplitBillQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.TransferBankGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.TransferGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.UserBankGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.UserGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.result.DecodedQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.GenerateQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.SplitBillQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.UserBankQrResult;

/* loaded from: classes4.dex */
public interface QrFacade {
    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.DECODE_QR)
    @SignCheck
    DecodedQrResult decode(DecodeQrRequest decodeQrRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.SPLIT_BILL_QR)
    @SignCheck
    SplitBillQrResult getSplitBillQr(SplitBillQrRequest splitBillQrRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_TRANSFER_BANK)
    @SignCheck
    UserBankQrResult getTransferBankQr(TransferBankGenerateQrRequest transferBankGenerateQrRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_TRANSFER)
    @SignCheck
    GenerateQrResult getTransferQr(TransferGenerateQrRequest transferGenerateQrRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_USER_BANK)
    @SignCheck
    UserBankQrResult getUserBankQr(UserBankGenerateQrRequest userBankGenerateQrRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_USER)
    @SignCheck
    GenerateQrResult getUserQr(UserGenerateQrRequest userGenerateQrRequest);

    @OperationType("alipayplus.mobilewallet.qr.precreateorder")
    @SignCheck
    DefaultInfoResult preCreateCashierOrder(PreCreateOrderEntityRequest preCreateOrderEntityRequest);
}
