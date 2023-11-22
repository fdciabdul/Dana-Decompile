package id.dana.promocode.mapper;

import id.dana.domain.promocode.model.PrizeInfoVO;
import id.dana.domain.promoquest.model.PrizeInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/promocode/model/PrizeInfoVO;", "", "p0", "p1", "p2", "Lid/dana/domain/promoquest/model/PrizeInfoEntity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/promocode/model/PrizeInfoVO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/promoquest/model/PrizeInfoEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrizeInfoEntityMapperKt {
    public static final PrizeInfoEntity KClassImpl$Data$declaredNonStaticMembers$2(PrizeInfoVO prizeInfoVO, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(prizeInfoVO, "");
        return new PrizeInfoEntity(str, str2, prizeInfoVO.getPrizeId(), null, prizeInfoVO.getPrizeType(), str3, prizeInfoVO.getPrizeName());
    }
}
