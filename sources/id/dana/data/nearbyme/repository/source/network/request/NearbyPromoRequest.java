package id.dana.data.nearbyme.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class NearbyPromoRequest extends BaseRpcRequest implements Serializable {
    public List<NearbyPromoShopEntity> shopInfos;
}
