package id.dana.data.qrbarcode.repository.source.network.request;

import id.dana.domain.qrbarcode.PreCreateOrderRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/qrbarcode/PreCreateOrderRequest;", "Lid/dana/data/qrbarcode/repository/source/network/request/PreCreateOrderEntityRequest;", "toPreCreateOrderEntityRequest", "(Lid/dana/domain/qrbarcode/PreCreateOrderRequest;)Lid/dana/data/qrbarcode/repository/source/network/request/PreCreateOrderEntityRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreCreateOrderEntityRequestKt {
    public static final PreCreateOrderEntityRequest toPreCreateOrderEntityRequest(PreCreateOrderRequest preCreateOrderRequest) {
        Intrinsics.checkNotNullParameter(preCreateOrderRequest, "");
        return new PreCreateOrderEntityRequest(preCreateOrderRequest.getQrCode(), preCreateOrderRequest.getAmount(), preCreateOrderRequest.getRequestId(), preCreateOrderRequest.getMerchantId(), preCreateOrderRequest.getTip(), preCreateOrderRequest.getBizType(), preCreateOrderRequest.getCacheKey(), preCreateOrderRequest.getCountryCode(), preCreateOrderRequest.getFirstTime(), preCreateOrderRequest.getUserName());
    }
}
