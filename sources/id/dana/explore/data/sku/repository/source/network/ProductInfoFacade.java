package id.dana.explore.data.sku.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import id.dana.data.nearbyme.repository.source.network.request.ProductOrderRequest;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.ProductOrderResult;
import id.dana.explore.data.sku.repository.source.network.request.BizDestinationInquiryRequest;
import id.dana.explore.data.sku.repository.source.network.request.CreateProductOrderRequest;
import id.dana.explore.data.sku.repository.source.network.request.QueryLastSuccessfulTransactionRequest;
import id.dana.explore.data.sku.repository.source.network.response.BizDestinationInquiryResult;
import id.dana.explore.data.sku.repository.source.network.response.CreateProductOrderResult;
import id.dana.explore.data.sku.repository.source.network.response.QueryLastSuccessfulTransactionResponse;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0014H'¢\u0006\u0004\b\t\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/ProductInfoFacade;", "", "", "p0", "Lid/dana/explore/data/sku/repository/source/network/request/BizDestinationInquiryRequest;", "p1", "Lio/reactivex/Observable;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/explore/data/sku/repository/source/network/response/BizDestinationInquiryResult;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/request/BizDestinationInquiryRequest;)Lio/reactivex/Observable;", "Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;", "request", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/ProductOrderResult;", "createProductOrder", "(Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/ProductOrderResult;", "Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest;", "Lid/dana/explore/data/sku/repository/source/network/response/CreateProductOrderResult;", "PlaceComponentResult", "(Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest;)Lio/reactivex/Observable;", "Lid/dana/explore/data/sku/repository/source/network/request/QueryLastSuccessfulTransactionRequest;", "Lid/dana/explore/data/sku/repository/source/network/response/QueryLastSuccessfulTransactionResponse;", "(Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/request/QueryLastSuccessfulTransactionRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ProductInfoFacade {
    @POST("wallet/api/alipayplus.mobilewallet.product.inquire.biz.destination.json")
    Observable<ResultResponse<BizDestinationInquiryResult>> MyBillsEntityDataFactory(@Query("ctoken") String p0, @Body BizDestinationInquiryRequest p1);

    @POST("wallet/api/alipayplus.mobilewallet.product.query.successful.biz.id.json?ctoken=2TBRbGgl6DbfpykG")
    Observable<ResultResponse<QueryLastSuccessfulTransactionResponse>> MyBillsEntityDataFactory(@Query("ctoken") String p0, @Body QueryLastSuccessfulTransactionRequest p1);

    @POST("wallet/api/alipayplus.mobilewallet.product.order.json")
    Observable<ResultResponse<CreateProductOrderResult>> PlaceComponentResult(@Query("ctoken") String p0, @Body CreateProductOrderRequest p1);

    @OperationType("alipayplus.mobilewallet.product.order")
    ProductOrderResult createProductOrder(ProductOrderRequest request);
}
