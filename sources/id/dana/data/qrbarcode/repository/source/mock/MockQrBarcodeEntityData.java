package id.dana.data.qrbarcode.repository.source.mock;

import com.alipay.mobile.security.bio.service.local.NotImplementedException;
import id.dana.data.model.DefaultInfoResult;
import id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData;
import id.dana.data.qrbarcode.repository.source.network.request.PreCreateOrderEntityRequest;
import id.dana.data.qrbarcode.repository.source.network.request.SplitBillPayerEntity;
import id.dana.data.qrbarcode.repository.source.network.request.TransferBankGenerateQrEntity;
import id.dana.data.qrbarcode.repository.source.network.request.TransferGenerateQrRequest;
import id.dana.data.qrbarcode.repository.source.network.request.UserBankGenerateQrEntity;
import id.dana.data.qrbarcode.repository.source.network.result.DecodedQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.GenerateQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.SplitBillQrResult;
import id.dana.data.qrbarcode.repository.source.network.result.UserBankQrResult;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes4.dex */
public class MockQrBarcodeEntityData implements QrBarcodeEntityData {
    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public Observable<UserBankQrResult> requestTransferBankCode(TransferBankGenerateQrEntity transferBankGenerateQrEntity) {
        return null;
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public Observable<UserBankQrResult> userBankCode(UserBankGenerateQrEntity userBankGenerateQrEntity) {
        return null;
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public Observable<DecodedQrResult> decode(String str, String str2, Long l) {
        DecodedQrResult decodedQrResult = new DecodedQrResult();
        decodedQrResult.bizType = DecodeQrBizType.GN_AC_CODE;
        decodedQrResult.acDecodeConfig = "decodeConfigGn";
        return Observable.just(decodedQrResult);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public Observable<GenerateQrResult> userCode(boolean z, String str, int i) {
        GenerateQrResult generateQrResult = new GenerateQrResult();
        generateQrResult.qrCode = "https://test.onepay.finance/gateway/oneQ/OS035697214894/20200413161613271FYr";
        return Observable.just(generateQrResult);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public Observable<GenerateQrResult> requestTransferCode(TransferGenerateQrRequest transferGenerateQrRequest) {
        GenerateQrResult generateQrResult = new GenerateQrResult();
        generateQrResult.qrCode = "https://test.onepay.finance/gateway/oneQ/OS035697214894/20200413161613271FYr";
        return Observable.just(generateQrResult);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public Observable<SplitBillQrResult> requestSplitBillCode(List<SplitBillPayerEntity> list, String str) {
        SplitBillQrResult splitBillQrResult = new SplitBillQrResult();
        splitBillQrResult.qrCode = "https://qr.dana.id/v1/1234567";
        return Observable.just(splitBillQrResult);
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrBarcodeEntityData
    public Observable<DefaultInfoResult> preCreateCashierOrder(PreCreateOrderEntityRequest preCreateOrderEntityRequest) {
        throw new NotImplementedException();
    }
}
