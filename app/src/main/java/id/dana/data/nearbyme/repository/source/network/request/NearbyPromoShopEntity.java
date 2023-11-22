package id.dana.data.nearbyme.repository.source.network.request;

import id.dana.data.nearbyme.model.NearbyPromoResult;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class NearbyPromoShopEntity implements Serializable {
    public String merchantId;
    public String shopId;

    public boolean isMerchantIdEqual(NearbyPromoResult nearbyPromoResult) {
        return (this.merchantId == null || nearbyPromoResult.getMerchantId() == null || !this.merchantId.equals(nearbyPromoResult.getMerchantId())) ? false : true;
    }

    public boolean isShopIdEqual(NearbyPromoResult nearbyPromoResult) {
        return (this.shopId == null || nearbyPromoResult.getShopId() == null || !this.shopId.equals(nearbyPromoResult.getShopId())) ? false : true;
    }
}
