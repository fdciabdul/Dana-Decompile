package id.dana.domain.nearbyme;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.nearbyme.model.DanaDealsOrderRequest;
import id.dana.domain.nearbyme.model.MerchantAdditionalInfo;
import id.dana.domain.nearbyme.model.MerchantConsult;
import id.dana.domain.nearbyme.model.MerchantImage;
import id.dana.domain.nearbyme.model.MerchantProductInfo;
import id.dana.domain.nearbyme.model.MerchantReviewSummary;
import id.dana.domain.nearbyme.model.MerchantReviews;
import id.dana.domain.nearbyme.model.ProductOrder;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.QueryUserReviews;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.social.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJH\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0016H&J)\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0016H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ'\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00122\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ;\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00122\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010 JE\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H¦@ø\u0001\u0000¢\u0006\u0002\u0010$J!\u0010%\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0011\u0010'\u001a\u00020\u0016H¦@ø\u0001\u0000¢\u0006\u0002\u0010(J!\u0010)\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010,J!\u0010-\u001a\u00020.2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0016H¦@ø\u0001\u0000¢\u0006\u0002\u00103ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u00064À\u0006\u0001"}, d2 = {"Lid/dana/domain/nearbyme/MerchantInfoRepository;", "", "consultMerchantReview", "Lid/dana/domain/nearbyme/model/MerchantConsult;", FeatureParams.SHOP_ID, "", SecurityConstants.KEY_PAGE_SIZE, "", "pageNum", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDanaDealsVoucherOrder", "Lid/dana/domain/nearbyme/model/ProductOrder;", "danaDealsOrderRequest", "Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;", "(Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMerchantImage", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/domain/social/Result;", "", "Lid/dana/domain/nearbyme/model/MerchantImage;", "merchantId", "skipCache", "", "getMerchantInfo", "Lid/dana/domain/nearbyme/model/Shop;", "useNewMerchantCategory", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMerchantPromo", "Lid/dana/domain/nearbyme/model/PromoInfo;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMerchantPromoDanaDeal", "Lid/dana/domain/nearbyme/model/MerchantProductInfo;", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMerchantReview", "Lid/dana/domain/nearbyme/model/MerchantReviews;", "filterCriteria", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMerchantReviewSummary", "Lid/dana/domain/nearbyme/model/MerchantReviewSummary;", "getReviewCoachmark", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviewedMerchantsList", "Lid/dana/domain/nearbyme/model/QueryUserReviews;", ZdocRecordService.PAGE_NUMBER, "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAdditionalInfo", "Lid/dana/domain/nearbyme/model/MerchantAdditionalInfo;", "bizInfo", "setReviewCoachmark", "", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MerchantInfoRepository {
    Object consultMerchantReview(String str, int i, int i2, Continuation<? super MerchantConsult> continuation);

    Object createDanaDealsVoucherOrder(DanaDealsOrderRequest danaDealsOrderRequest, Continuation<? super ProductOrder> continuation);

    Flow<Result<List<MerchantImage>>> getMerchantImage(String merchantId, String shopId, int pageNum, int pageSize, boolean skipCache);

    Object getMerchantInfo(String str, String str2, boolean z, Continuation<? super Shop> continuation);

    Object getMerchantPromo(String str, String str2, Continuation<? super List<PromoInfo>> continuation);

    Object getMerchantPromoDanaDeal(String str, String str2, int i, int i2, Continuation<? super List<MerchantProductInfo>> continuation);

    Object getMerchantReview(String str, String str2, int i, int i2, List<String> list, Continuation<? super MerchantReviews> continuation);

    Object getMerchantReviewSummary(String str, String str2, Continuation<? super MerchantReviewSummary> continuation);

    Object getReviewCoachmark(Continuation<? super Boolean> continuation);

    Object getReviewedMerchantsList(int i, int i2, Continuation<? super QueryUserReviews> continuation);

    Object queryAdditionalInfo(String str, String str2, Continuation<? super MerchantAdditionalInfo> continuation);

    Object setReviewCoachmark(boolean z, Continuation<? super Unit> continuation);

    /* renamed from: id.dana.domain.nearbyme.MerchantInfoRepository$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object getMerchantReview$default(MerchantInfoRepository merchantInfoRepository, String str, String str2, int i, int i2, List list, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                int i4 = (i3 & 4) != 0 ? 1 : i;
                int i5 = (i3 & 8) != 0 ? 10 : i2;
                List list2 = list;
                if ((i3 & 16) != 0) {
                    list2 = CollectionsKt.emptyList();
                }
                return merchantInfoRepository.getMerchantReview(str, str2, i4, i5, list2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMerchantReview");
        }

        public static /* synthetic */ Flow getMerchantImage$default(MerchantInfoRepository merchantInfoRepository, String str, String str2, int i, int i2, boolean z, int i3, Object obj) {
            if (obj == null) {
                return merchantInfoRepository.getMerchantImage(str, str2, (i3 & 4) != 0 ? 1 : i, (i3 & 8) != 0 ? 10 : i2, (i3 & 16) != 0 ? false : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMerchantImage");
        }

        public static /* synthetic */ Object getMerchantPromoDanaDeal$default(MerchantInfoRepository merchantInfoRepository, String str, String str2, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return merchantInfoRepository.getMerchantPromoDanaDeal(str, str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 10 : i2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMerchantPromoDanaDeal");
        }

        public static /* synthetic */ Object consultMerchantReview$default(MerchantInfoRepository merchantInfoRepository, String str, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = "";
                }
                if ((i3 & 2) != 0) {
                    i = 10;
                }
                if ((i3 & 4) != 0) {
                    i2 = 1;
                }
                return merchantInfoRepository.consultMerchantReview(str, i, i2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: consultMerchantReview");
        }
    }
}
