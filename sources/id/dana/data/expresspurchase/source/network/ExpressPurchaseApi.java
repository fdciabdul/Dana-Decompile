package id.dana.data.expresspurchase.source.network;

import id.dana.data.expresspurchase.source.network.pojo.request.GetExpressPurchaseRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.OrderQueryByConditionRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.QuickBuyDealsRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.QuickBuyGoldRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.QuickBuyInsuranceRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.ValidateProductGoldRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.ValidateProductQuickRequest;
import id.dana.data.expresspurchase.source.network.pojo.request.ValidateProductRequest;
import id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.OrderQueryByConditionResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyDealsResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductQuickResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductResponse;
import id.dana.network.base.ResultResponse;
import id.dana.network.response.expresspurchase.ValidateProductGoldResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 $2\u00020\u0001:\u0001$J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0011H'¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020 H'¢\u0006\u0004\b\"\u0010#ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/expresspurchase/source/network/ExpressPurchaseApi;", "", "Lid/dana/data/expresspurchase/source/network/pojo/request/GetExpressPurchaseRequest;", "request", "Lio/reactivex/Observable;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse;", "getExpressPurchase", "(Lid/dana/data/expresspurchase/source/network/pojo/request/GetExpressPurchaseRequest;)Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/request/QuickBuyDealsRequest;", "Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyDealsResponse;", "getQuickBuyDeals", "(Lid/dana/data/expresspurchase/source/network/pojo/request/QuickBuyDealsRequest;)Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/request/QuickBuyGoldRequest;", "Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyResponse;", "getQuickBuyGold", "(Lid/dana/data/expresspurchase/source/network/pojo/request/QuickBuyGoldRequest;)Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/request/QuickBuyInsuranceRequest;", "getQuickBuyInsurance", "(Lid/dana/data/expresspurchase/source/network/pojo/request/QuickBuyInsuranceRequest;)Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/request/OrderQueryByConditionRequest;", "Lid/dana/data/expresspurchase/source/network/pojo/response/OrderQueryByConditionResponse;", "orderQueryByCondition", "(Lid/dana/data/expresspurchase/source/network/pojo/request/OrderQueryByConditionRequest;)Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/request/ValidateProductRequest;", "Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductResponse;", "validateProduct", "(Lid/dana/data/expresspurchase/source/network/pojo/request/ValidateProductRequest;)Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/request/ValidateProductGoldRequest;", "Lid/dana/network/response/expresspurchase/ValidateProductGoldResponse;", "validateProductGold", "(Lid/dana/data/expresspurchase/source/network/pojo/request/ValidateProductGoldRequest;)Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/request/ValidateProductQuickRequest;", "Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductQuickResponse;", "validateProductQuick", "(Lid/dana/data/expresspurchase/source/network/pojo/request/ValidateProductQuickRequest;)Lio/reactivex/Observable;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExpressPurchaseApi {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String GET_EXPRESS_PURCHASE = "wallet/api/alipayplus.mobilewallet.product.getExpressPurchase.json";
    public static final String ORDER_QUERY_BY_CONDITION = "wallet/api/alipayplus.mobilewallet.order.queryByCondition.json";
    public static final String QUICK_BUY = "wallet/api/alipayplus.mobilewallet.product.quickBuy.json";
    public static final String QUICK_BUY_DEALS = "wallet/api/alipayplus.mobilewallet.product.quickBuy.json";
    public static final String VALIDATE_PRODUCT = "wallet/api/alipayplus.mobilewallet.product.finCenter.validate.json";
    public static final String VALIDATE_PRODUCT_GOLD = "wallet/api/alipayplus.mobilewallet.product.validate.json";
    public static final String VALIDATE_QUICK_PRODUCT = "wallet/api/alipayplus.mobilewallet.product.quick.finCenter.validate.json";

    @POST("/wallet/api/alipayplus.mobilewallet.product.getExpressPurchase.json")
    Observable<ResultResponse<GetExpressPurchaseResponse>> getExpressPurchase(@Body GetExpressPurchaseRequest request);

    @POST("/wallet/api/alipayplus.mobilewallet.product.quickBuy.json")
    Observable<ResultResponse<QuickBuyDealsResponse>> getQuickBuyDeals(@Body QuickBuyDealsRequest request);

    @POST("/wallet/api/alipayplus.mobilewallet.product.quickBuy.json")
    Observable<ResultResponse<QuickBuyResponse>> getQuickBuyGold(@Body QuickBuyGoldRequest request);

    @POST("/wallet/api/alipayplus.mobilewallet.product.quickBuy.json")
    Observable<ResultResponse<QuickBuyResponse>> getQuickBuyInsurance(@Body QuickBuyInsuranceRequest request);

    @POST("/wallet/api/alipayplus.mobilewallet.order.queryByCondition.json")
    Observable<ResultResponse<OrderQueryByConditionResponse>> orderQueryByCondition(@Body OrderQueryByConditionRequest request);

    @POST("/wallet/api/alipayplus.mobilewallet.product.finCenter.validate.json")
    Observable<ResultResponse<ValidateProductResponse>> validateProduct(@Body ValidateProductRequest request);

    @POST("/wallet/api/alipayplus.mobilewallet.product.validate.json")
    Observable<ResultResponse<ValidateProductGoldResponse>> validateProductGold(@Body ValidateProductGoldRequest request);

    @POST("/wallet/api/alipayplus.mobilewallet.product.quick.finCenter.validate.json")
    Observable<ResultResponse<ValidateProductQuickResponse>> validateProductQuick(@Body ValidateProductQuickRequest request);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/data/expresspurchase/source/network/ExpressPurchaseApi$Companion;", "", "", "GET_EXPRESS_PURCHASE", "Ljava/lang/String;", "ORDER_QUERY_BY_CONDITION", "QUICK_BUY", "QUICK_BUY_DEALS", "VALIDATE_PRODUCT", "VALIDATE_PRODUCT_GOLD", "VALIDATE_QUICK_PRODUCT", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String GET_EXPRESS_PURCHASE = "wallet/api/alipayplus.mobilewallet.product.getExpressPurchase.json";
        public static final String ORDER_QUERY_BY_CONDITION = "wallet/api/alipayplus.mobilewallet.order.queryByCondition.json";
        public static final String QUICK_BUY = "wallet/api/alipayplus.mobilewallet.product.quickBuy.json";
        public static final String QUICK_BUY_DEALS = "wallet/api/alipayplus.mobilewallet.product.quickBuy.json";
        public static final String VALIDATE_PRODUCT = "wallet/api/alipayplus.mobilewallet.product.finCenter.validate.json";
        public static final String VALIDATE_PRODUCT_GOLD = "wallet/api/alipayplus.mobilewallet.product.validate.json";
        public static final String VALIDATE_QUICK_PRODUCT = "wallet/api/alipayplus.mobilewallet.product.quick.finCenter.validate.json";

        private Companion() {
        }
    }
}
