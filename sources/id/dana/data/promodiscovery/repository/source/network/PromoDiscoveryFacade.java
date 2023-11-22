package id.dana.data.promodiscovery.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.promodiscovery.repository.source.network.request.PromoDanaDealsRequest;
import id.dana.data.promodiscovery.repository.source.network.request.PromoFourKingsRequest;
import id.dana.data.promodiscovery.repository.source.network.response.ProductInfoResponse;
import id.dana.data.promodiscovery.repository.source.network.response.PromoFourKingsResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/network/PromoDiscoveryFacade;", "", "Lid/dana/data/promodiscovery/repository/source/network/request/PromoFourKingsRequest;", "promoFourKingsRequest", "Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsResponse;", "getPromoCenterPillarByTypeList", "(Lid/dana/data/promodiscovery/repository/source/network/request/PromoFourKingsRequest;)Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsResponse;", "Lid/dana/data/promodiscovery/repository/source/network/request/PromoDanaDealsRequest;", "promoDanaDealsRequest", "Lid/dana/data/promodiscovery/repository/source/network/response/ProductInfoResponse;", "getPromoDanaDeals", "(Lid/dana/data/promodiscovery/repository/source/network/request/PromoDanaDealsRequest;)Lid/dana/data/promodiscovery/repository/source/network/response/ProductInfoResponse;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PromoDiscoveryFacade {
    @OperationType("alipayplus.mobilewallet.promocenterpillar.queryByTypeList")
    @SignCheck
    PromoFourKingsResponse getPromoCenterPillarByTypeList(PromoFourKingsRequest promoFourKingsRequest);

    @OperationType("alipayplus.mobilewallet.product.queryPagination")
    @SignCheck
    ProductInfoResponse getPromoDanaDeals(PromoDanaDealsRequest promoDanaDealsRequest);
}
