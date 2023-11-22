package id.dana.cashier.data.repository.source.network.result;

import id.dana.cashier.domain.model.ExchangeRate;
import id.dana.cashier.domain.model.IntlOrderInfoDTO;
import id.dana.cashier.domain.model.OriginAmount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/IntlOrderInfoDTOResult;", "Lid/dana/cashier/domain/model/IntlOrderInfoDTO;", "toIntlOrderInfoDTO", "(Lid/dana/cashier/data/repository/source/network/result/IntlOrderInfoDTOResult;)Lid/dana/cashier/domain/model/IntlOrderInfoDTO;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IntlOrderInfoDTOResultKt {
    public static final IntlOrderInfoDTO toIntlOrderInfoDTO(IntlOrderInfoDTOResult intlOrderInfoDTOResult) {
        Intrinsics.checkNotNullParameter(intlOrderInfoDTOResult, "");
        String exchangeDate = intlOrderInfoDTOResult.getExchangeDate();
        ExchangeRateResult exchangeRate = intlOrderInfoDTOResult.getExchangeRate();
        ExchangeRate exchangeRate2 = exchangeRate != null ? ExchangeRateResultKt.toExchangeRate(exchangeRate) : null;
        OriginAmountResult originOrderAmount = intlOrderInfoDTOResult.getOriginOrderAmount();
        OriginAmount originAmount = originOrderAmount != null ? OriginAmountResultKt.toOriginAmount(originOrderAmount) : null;
        OriginAmountResult originConvertAmount = intlOrderInfoDTOResult.getOriginConvertAmount();
        return new IntlOrderInfoDTO(exchangeDate, exchangeRate2, originAmount, originConvertAmount != null ? OriginAmountResultKt.toOriginAmount(originConvertAmount) : null);
    }
}
