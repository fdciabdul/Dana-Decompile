package id.dana.data.content.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.cache.CacheKey;
import id.dana.data.content.source.network.request.SpaceRpcRequest;
import id.dana.data.content.source.network.result.SpaceRpcResult;

/* loaded from: classes4.dex */
public interface CdpSpaceFacade {
    @OperationType(CacheKey.CDP)
    @SignCheck
    SpaceRpcResult get(SpaceRpcRequest spaceRpcRequest);
}
