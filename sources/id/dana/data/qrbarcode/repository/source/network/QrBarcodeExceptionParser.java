package id.dana.data.qrbarcode.repository.source.network;

import id.dana.data.qrbarcode.repository.source.network.result.DecodedQrResult;
import id.dana.network.base.ExceptionParser;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public class QrBarcodeExceptionParser extends ExceptionParser<DecodedQrResult> {
    @Override // id.dana.network.base.ExceptionParser, io.reactivex.functions.Function
    public Observable<DecodedQrResult> apply(DecodedQrResult decodedQrResult) throws Exception {
        if (!decodedQrResult.success) {
            return Observable.error(getBarcodeException(decodedQrResult));
        }
        return super.apply((QrBarcodeExceptionParser) decodedQrResult);
    }

    private QrBarcodeException getBarcodeException(DecodedQrResult decodedQrResult) {
        if ("AE15115999000308".equals(decodedQrResult.errorCode)) {
            return new QrBarcodeExpiredException(decodedQrResult);
        }
        return new QrBarcodeException(decodedQrResult);
    }
}
