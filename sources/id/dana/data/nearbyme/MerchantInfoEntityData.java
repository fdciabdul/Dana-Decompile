package id.dana.data.nearbyme;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.data.nearbyme.repository.source.network.request.ProductOrderRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.BaseMerchantInfoRequest;
import id.dana.data.nearbyme.repository.source.network.request.merchantdetail.MerchantAdditionalInfoRequest;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0012H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J1\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ1\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJE\u0010\"\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170%H¦@ø\u0001\u0000¢\u0006\u0002\u0010&J!\u0010'\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u0010)\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020+H¦@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020.2\u0006\u0010\u000e\u001a\u00020/H¦@ø\u0001\u0000¢\u0006\u0002\u00100J9\u00101\u001a\u0002022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u00104J\u0019\u00105\u001a\u0002022\u0006\u00106\u001a\u00020\u0012H¦@ø\u0001\u0000¢\u0006\u0002\u00107J\u0019\u00108\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u00069À\u0006\u0001"}, d2 = {"Lid/dana/data/nearbyme/MerchantInfoEntityData;", "", "consultMerchantReview", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantConsultResult;", "merchantConsultRequest", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/BaseMerchantInfoRequest;", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/BaseMerchantInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createProductOrder", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/ProductOrderResult;", "productOrderRequest", "Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;", "(Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createReview", "Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/MerchantCreateReviewResult;", "request", "Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/MerchantCreateReviewRequest;", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/MerchantCreateReviewRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCoachmarkVisibility", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMerchantImage", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;", "merchantId", "", FeatureParams.SHOP_ID, "pageNum", "", SecurityConstants.KEY_PAGE_SIZE, "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMerchantInfo", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantDetailInfoResult;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMerchantPromoDanaDeal", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantPromoDanaDealResult;", "getMerchantReview", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantQueryReviewResult;", "filterCriteria", "", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMerchantReviewSummary", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantReviewSummaryResult;", "getReviewedMerchantsList", "Lid/dana/data/nearbyme/repository/source/network/result/merchantreview/QueryUserReviewsResult;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantreview/QueryUserReviewsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAdditionalInfo", "Lid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantAdditionalInfoResult;", "Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantAdditionalInfoRequest;", "(Lid/dana/data/nearbyme/repository/source/network/request/merchantdetail/MerchantAdditionalInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMerchantImage", "", "data", "(Ljava/lang/String;Ljava/lang/String;IILid/dana/data/nearbyme/repository/source/network/result/merchantdetail/MerchantImageResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCoachmarkVisibility", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReview", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MerchantInfoEntityData {
    Object consultMerchantReview(BaseMerchantInfoRequest baseMerchantInfoRequest, Continuation<? super MerchantConsultResult> continuation);

    Object createProductOrder(ProductOrderRequest productOrderRequest, Continuation<? super ProductOrderResult> continuation);

    Object createReview(MerchantCreateReviewRequest merchantCreateReviewRequest, Continuation<? super MerchantCreateReviewResult> continuation);

    Object getCoachmarkVisibility(Continuation<? super Boolean> continuation);

    Object getMerchantImage(String str, String str2, int i, int i2, Continuation<? super MerchantImageResult> continuation);

    Object getMerchantInfo(String str, String str2, Continuation<? super MerchantDetailInfoResult> continuation);

    Object getMerchantPromoDanaDeal(String str, String str2, int i, int i2, Continuation<? super MerchantPromoDanaDealResult> continuation);

    Object getMerchantReview(String str, String str2, int i, int i2, List<String> list, Continuation<? super MerchantQueryReviewResult> continuation);

    Object getMerchantReviewSummary(String str, String str2, Continuation<? super MerchantReviewSummaryResult> continuation);

    Object getReviewedMerchantsList(QueryUserReviewsRequest queryUserReviewsRequest, Continuation<? super QueryUserReviewsResult> continuation);

    Object queryAdditionalInfo(MerchantAdditionalInfoRequest merchantAdditionalInfoRequest, Continuation<? super MerchantAdditionalInfoResult> continuation);

    Object saveMerchantImage(String str, String str2, int i, int i2, MerchantImageResult merchantImageResult, Continuation<? super Unit> continuation);

    Object setCoachmarkVisibility(boolean z, Continuation<? super Unit> continuation);

    Object updateReview(MerchantCreateReviewRequest merchantCreateReviewRequest, Continuation<? super MerchantCreateReviewResult> continuation);

    /* renamed from: id.dana.data.nearbyme.MerchantInfoEntityData$-CC */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static Object $default$saveMerchantImage(MerchantInfoEntityData merchantInfoEntityData, String str, String str2, int i, int i2, MerchantImageResult merchantImageResult, Continuation continuation) {
            return saveMerchantImage$suspendImpl(merchantInfoEntityData, str, str2, i, i2, merchantImageResult, continuation);
        }

        public static /* synthetic */ Object getMerchantReview$default(MerchantInfoEntityData merchantInfoEntityData, String str, String str2, int i, int i2, List list, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                int i4 = (i3 & 4) != 0 ? 1 : i;
                int i5 = (i3 & 8) != 0 ? 10 : i2;
                List list2 = list;
                if ((i3 & 16) != 0) {
                    list2 = CollectionsKt.emptyList();
                }
                return merchantInfoEntityData.getMerchantReview(str, str2, i4, i5, list2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMerchantReview");
        }

        public static /* synthetic */ Object saveMerchantImage$suspendImpl(MerchantInfoEntityData merchantInfoEntityData, String str, String str2, int i, int i2, MerchantImageResult merchantImageResult, Continuation continuation) {
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Object consultMerchantReview$suspendImpl(MerchantInfoEntityData merchantInfoEntityData, BaseMerchantInfoRequest baseMerchantInfoRequest, Continuation continuation) {
            return new MerchantConsultResult(null, null, null, null, false, 31, null);
        }
    }
}
