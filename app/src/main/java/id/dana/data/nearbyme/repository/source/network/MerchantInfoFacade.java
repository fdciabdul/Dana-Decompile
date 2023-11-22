package id.dana.data.nearbyme.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.nearbyme.repository.source.network.request.ProductOrderRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.BaseMerchantInfoRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantAdditionalInfoRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantDetailInfoRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantImageRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantPromoDanaDealRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantQueryReviewRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantreview.MerchantCreateReviewRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantreview.QueryUserReviewsRequest;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantAdditionalInfoResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantConsultResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantDetailInfoResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantImageResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantPromoDanaDealResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantQueryReviewResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.MerchantReviewSummaryResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantdetail.ProductOrderResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantreview.MerchantCreateReviewResult;
import id.dana.data.nearbyme.repository.source.network.result.merchantreview.QueryUserReviewsResult;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020&H'¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b*\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/nearbyme/repository/source/network/MerchantInfoFacade;", "", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/BaseMerchantInfoRequest;", "request", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantConsultResult;", "consultReview", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/BaseMerchantInfoRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantConsultResult;", "Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/ProductOrderResult;", "createProductOrder", "(Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/ProductOrderResult;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/MerchantCreateReviewRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/MerchantCreateReviewResult;", "createReview", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/MerchantCreateReviewRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/MerchantCreateReviewResult;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantAdditionalInfoRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantAdditionalInfoResult;", "queryAdditionalInfo", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantAdditionalInfoRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantAdditionalInfoResult;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantImageRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "queryImage", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantImageRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantDetailInfoRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantDetailInfoResult;", "queryInfo", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantDetailInfoRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantDetailInfoResult;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantPromoDanaDealRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantPromoDanaDealResult;", "queryPromoDanaDeal", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantPromoDanaDealRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantPromoDanaDealResult;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantQueryReviewRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantQueryReviewResult;", "queryReview", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantQueryReviewRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantQueryReviewResult;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantReviewSummaryResult;", "queryReviewSummary", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantQueryReviewRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantReviewSummaryResult;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;", "Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/QueryUserReviewsResult;", "queryUserReviews", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;)Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/QueryUserReviewsResult;", "updateReview"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface MerchantInfoFacade {
    @OperationType("alipayplus.mobilewallet.merchant.info.consult")
    @SignCheck
    MerchantConsultResult consultReview(BaseMerchantInfoRequest request);

    @OperationType("alipayplus.mobilewallet.product.order")
    ProductOrderResult createProductOrder(ProductOrderRequest request);

    @OperationType("alipayplus.mobilewallet.merchant.info.create.review")
    MerchantCreateReviewResult createReview(MerchantCreateReviewRequest request);

    @OperationType("alipayplus.mobilewallet.merchant.info.additional.information")
    MerchantAdditionalInfoResult queryAdditionalInfo(MerchantAdditionalInfoRequest request);

    @OperationType("alipayplus.mobilewallet.merchant.info.image")
    MerchantImageResult queryImage(MerchantImageRequest request);

    @OperationType(GetMerchantInfo.OPERATION_TYPE)
    @SignCheck
    MerchantDetailInfoResult queryInfo(MerchantDetailInfoRequest request);

    @OperationType("alipayplus.mobilewallet.merchant.info.promo.deal")
    MerchantPromoDanaDealResult queryPromoDanaDeal(MerchantPromoDanaDealRequest request);

    @OperationType("alipayplus.mobilewallet.merchant.info.review.query")
    MerchantQueryReviewResult queryReview(MerchantQueryReviewRequest request);

    @OperationType("alipayplus.mobilewallet.merchant.info.review.summary")
    MerchantReviewSummaryResult queryReviewSummary(MerchantQueryReviewRequest request);

    @OperationType(GetReviewedMerchantsList.GET_REVIEWED_MERCHANT_LIST)
    QueryUserReviewsResult queryUserReviews(QueryUserReviewsRequest request);

    @OperationType("id.dana.discovery.merchant.info.updateReview")
    MerchantCreateReviewResult updateReview(MerchantCreateReviewRequest request);
}
