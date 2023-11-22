package id.dana.data.qrbarcode.repository.source.network;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.exception.NetworkException;

/* loaded from: classes4.dex */
public class QrBarcodeException extends NetworkException {
    private String errorMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QrBarcodeException(BaseRpcResult baseRpcResult) {
        super(baseRpcResult);
        this.errorMessage = baseRpcResult.errorMessage;
    }

    public String errorMessage() {
        return this.errorMessage;
    }
}
