package id.dana.data.nearbyme.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.nearbyme.model.NearbyPromoResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class NearbyShopsPromoResult extends BaseRpcResult implements Serializable {
    private List<NearbyPromoResult> shops = new ArrayList();

    public List<NearbyPromoResult> getShops() {
        return this.shops;
    }

    public void setShops(List<NearbyPromoResult> list) {
        this.shops = list;
    }
}
