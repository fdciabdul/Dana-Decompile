package id.dana.promoquest.extension;

import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.promoquest.model.PrizeInfoEntity;
import id.dana.domain.promoquest.model.PrizeType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrizeInfoEntityExtKt {
    public static /* synthetic */ void PlaceComponentResult(PrizeInfoEntity prizeInfoEntity, DynamicUrlWrapper dynamicUrlWrapper) {
        String format;
        Intrinsics.checkNotNullParameter(prizeInfoEntity, "");
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        String prizeType = prizeInfoEntity.getPrizeType();
        if (Intrinsics.areEqual(prizeType, PrizeType.CHANCETOKEN)) {
            format = "https://m.dana.id/m/tap-win";
        } else if (Intrinsics.areEqual(prizeType, PrizeType.CASHBACK)) {
            String transactionDetailUrl = dynamicUrlWrapper.getTransactionDetailUrl();
            Intrinsics.checkNotNullExpressionValue(transactionDetailUrl, "");
            format = String.format(transactionDetailUrl, Arrays.copyOf(new Object[]{prizeInfoEntity.getPrizeAwardOrderId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
        } else {
            String voucherDetail = dynamicUrlWrapper.getVoucherDetail();
            Intrinsics.checkNotNullExpressionValue(voucherDetail, "");
            format = String.format(voucherDetail, Arrays.copyOf(new Object[]{prizeInfoEntity.getVoucherId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
        }
        DanaH5.startContainerFullUrl(format, null);
    }
}
