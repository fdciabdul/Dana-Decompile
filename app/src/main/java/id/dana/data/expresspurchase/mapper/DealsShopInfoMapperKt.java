package id.dana.data.expresspurchase.mapper;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.data.expresspurchase.source.network.pojo.response.DealsShopInfoResponse;
import id.dana.domain.expresspurchase.interaction.model.DealsShopInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/DealsShopInfoResponse;", "Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;", "toDealsShopInfo", "(Lid/dana/data/expresspurchase/source/network/pojo/response/DealsShopInfoResponse;)Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DealsShopInfoMapperKt {
    public static final DealsShopInfo toDealsShopInfo(DealsShopInfoResponse dealsShopInfoResponse) {
        Intrinsics.checkNotNullParameter(dealsShopInfoResponse, "");
        String shopId = dealsShopInfoResponse.getShopId();
        if (shopId == null) {
            shopId = "";
        }
        String shopName = dealsShopInfoResponse.getShopName();
        String str = shopName != null ? shopName : "";
        Double distanceInMeter = dealsShopInfoResponse.getDistanceInMeter();
        return new DealsShopInfo(shopId, str, distanceInMeter != null ? distanceInMeter.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }
}
