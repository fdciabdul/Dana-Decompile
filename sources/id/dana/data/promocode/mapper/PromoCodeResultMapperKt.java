package id.dana.data.promocode.mapper;

import id.dana.data.promocode.repository.source.network.result.PrizeAwardVOResult;
import id.dana.data.promocode.repository.source.network.result.PrizeInfoVOResult;
import id.dana.data.promocode.repository.source.network.result.PromoCodeResult;
import id.dana.domain.promocode.model.PrizeAwardVO;
import id.dana.domain.promocode.model.PrizeInfoVO;
import id.dana.domain.promocode.model.PromoCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/promocode/repository/source/network/result/PrizeAwardVOResult;", "Lid/dana/domain/promocode/model/PrizeAwardVO;", "toPrizeAwardVO", "(Lid/dana/data/promocode/repository/source/network/result/PrizeAwardVOResult;)Lid/dana/domain/promocode/model/PrizeAwardVO;", "", "toPrizeAwardVOList", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/promocode/repository/source/network/result/PrizeInfoVOResult;", "Lid/dana/domain/promocode/model/PrizeInfoVO;", "toPrizeInfoVO", "(Lid/dana/data/promocode/repository/source/network/result/PrizeInfoVOResult;)Lid/dana/domain/promocode/model/PrizeInfoVO;", "Lid/dana/data/promocode/repository/source/network/result/PromoCodeResult;", "Lid/dana/domain/promocode/model/PromoCode;", "toPromoCode", "(Lid/dana/data/promocode/repository/source/network/result/PromoCodeResult;)Lid/dana/domain/promocode/model/PromoCode;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoCodeResultMapperKt {
    public static final PromoCode toPromoCode(PromoCodeResult promoCodeResult) {
        Intrinsics.checkNotNullParameter(promoCodeResult, "");
        boolean needRetry = promoCodeResult.getNeedRetry();
        List<PrizeAwardVOResult> prizeAward = promoCodeResult.getPrizeAward();
        List<PrizeAwardVO> prizeAwardVOList = prizeAward != null ? toPrizeAwardVOList(prizeAward) : null;
        if (prizeAwardVOList == null) {
            prizeAwardVOList = CollectionsKt.emptyList();
        }
        return new PromoCode(needRetry, prizeAwardVOList);
    }

    public static final List<PrizeAwardVO> toPrizeAwardVOList(List<PrizeAwardVOResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PrizeAwardVOResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toPrizeAwardVO((PrizeAwardVOResult) it.next()));
        }
        return arrayList;
    }

    public static final PrizeAwardVO toPrizeAwardVO(PrizeAwardVOResult prizeAwardVOResult) {
        Intrinsics.checkNotNullParameter(prizeAwardVOResult, "");
        String prizeAwardOrderId = prizeAwardVOResult.getPrizeAwardOrderId();
        String status = prizeAwardVOResult.getStatus();
        String activityId = prizeAwardVOResult.getActivityId();
        String merchantId = prizeAwardVOResult.getMerchantId();
        String userId = prizeAwardVOResult.getUserId();
        String requestId = prizeAwardVOResult.getRequestId();
        String bizNo = prizeAwardVOResult.getBizNo();
        long awardTime = prizeAwardVOResult.getAwardTime();
        PrizeInfoVOResult prizeInfoVO = prizeAwardVOResult.getPrizeInfoVO();
        return new PrizeAwardVO(prizeAwardOrderId, status, activityId, merchantId, userId, requestId, bizNo, awardTime, prizeInfoVO != null ? toPrizeInfoVO(prizeInfoVO) : null, prizeAwardVOResult.getExtendInfo());
    }

    public static final PrizeInfoVO toPrizeInfoVO(PrizeInfoVOResult prizeInfoVOResult) {
        Intrinsics.checkNotNullParameter(prizeInfoVOResult, "");
        return new PrizeInfoVO(prizeInfoVOResult.getPrizeId(), prizeInfoVOResult.getPrizeName(), prizeInfoVOResult.getPrizeType());
    }
}
