package id.dana.data.expresspurchase.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import id.dana.data.expresspurchase.source.network.pojo.request.DealsQueryShopRequest;
import id.dana.data.expresspurchase.source.network.pojo.response.DealsQueryShopResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/expresspurchase/source/network/DealsExpressPurchaseFacade;", "", "Lid/dana/data/expresspurchase/source/network/pojo/request/DealsQueryShopRequest;", "request", "Lid/dana/data/expresspurchase/source/network/pojo/response/DealsQueryShopResponse;", "dealsQueryShopLocation", "(Lid/dana/data/expresspurchase/source/network/pojo/request/DealsQueryShopRequest;)Lid/dana/data/expresspurchase/source/network/pojo/response/DealsQueryShopResponse;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DealsExpressPurchaseFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DEALS_QUERY_SHOP = "dana.dealsprod.shop.queryShop";

    @OperationType("dana.dealsprod.shop.queryShop")
    DealsQueryShopResponse dealsQueryShopLocation(DealsQueryShopRequest request);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/expresspurchase/source/network/DealsExpressPurchaseFacade$Companion;", "", "", "DEALS_QUERY_SHOP", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String DEALS_QUERY_SHOP = "dana.dealsprod.shop.queryShop";

        private Companion() {
        }
    }
}
