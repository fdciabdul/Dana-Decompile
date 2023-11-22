package id.dana.data.qrbarcode.repository.source;

import id.dana.data.model.DefaultInfoResult;
import id.dana.data.qrbarcode.repository.source.network.request.PreCreateOrderEntityRequest;
import id.dana.data.qrbarcode.repository.source.network.request.SplitBillPayerEntity;
import id.dana.data.qrbarcode.repository.source.network.request.TransferBankGenerateQrEntity;
import id.dana.data.qrbarcode.repository.source.network.request.TransferGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.UserBankGenerateQrEntity;
import id.dana.data.qrbarcode.repository.source.network.result.DecodedQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.GenerateQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.SplitBillQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.UserBankQrResult;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes4.dex */
public interface QrBarcodeEntityData {
    Observable<DecodedQrResult> decode(String str, String str2, Long l);

    Observable<DefaultInfoResult> preCreateCashierOrder(PreCreateOrderEntityRequest preCreateOrderEntityRequest);

    Observable<SplitBillQrResult> requestSplitBillCode(List<SplitBillPayerEntity> list, String str);

    Observable<UserBankQrResult> requestTransferBankCode(TransferBankGenerateQrEntity transferBankGenerateQrEntity);

    Observable<GenerateQrResult> requestTransferCode(TransferGenerateQrRequest transferGenerateQrRequest);

    Observable<UserBankQrResult> userBankCode(UserBankGenerateQrEntity userBankGenerateQrEntity);

    Observable<GenerateQrResult> userCode(boolean z, String str, int i);
}
