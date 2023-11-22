package id.dana.data.qrbarcode.repository.source.network;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/QrBarcodeExpiredException;", "Lid/dana/data/qrbarcode/repository/source/network/QrBarcodeException;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "result", "<init>", "(Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrBarcodeExpiredException extends QrBarcodeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrBarcodeExpiredException(BaseRpcResult baseRpcResult) {
        super(baseRpcResult);
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
    }
}
