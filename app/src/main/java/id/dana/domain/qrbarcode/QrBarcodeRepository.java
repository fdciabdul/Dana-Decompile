package id.dana.domain.qrbarcode;

import id.dana.domain.splitbill.model.SplitBillPayer;
import id.dana.domain.splitbill.model.TransferBankGenerateQr;
import id.dana.domain.splitbill.model.UserBankGenerateQr;
import id.dana.utils.rpc.response.DefaultResponse;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface QrBarcodeRepository {
    Observable<DecodedScan> getDecodedQrBarcode(String str, String str2, boolean z);

    Observable<List<String>> getMerchantQrDomainWhitelist();

    Observable<QrUserResult> getSplitBillQr(List<SplitBillPayer> list, String str);

    Observable<QrUserBankResult> getTransferBankQr(TransferBankGenerateQr transferBankGenerateQr);

    Observable<QrUserResult> getTransferQr(boolean z, String str, String str2, int i);

    Observable<QrUserBankResult> getUserBankQr(UserBankGenerateQr userBankGenerateQr);

    Observable<QrUserResult> getUserQr(boolean z, String str, int i);

    Observable<DefaultResponse> preCreateCashierOrder(PreCreateOrderRequest preCreateOrderRequest);
}
