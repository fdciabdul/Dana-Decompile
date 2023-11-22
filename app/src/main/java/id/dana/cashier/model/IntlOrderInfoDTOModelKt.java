package id.dana.cashier.model;

import id.dana.cashier.domain.model.ExchangeRate;
import id.dana.cashier.domain.model.IntlOrderInfoDTO;
import id.dana.cashier.domain.model.OriginAmount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/IntlOrderInfoDTO;", "Lid/dana/cashier/model/IntlOrderInfoDTOModel;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/domain/model/IntlOrderInfoDTO;)Lid/dana/cashier/model/IntlOrderInfoDTOModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IntlOrderInfoDTOModelKt {
    public static final IntlOrderInfoDTOModel MyBillsEntityDataFactory(IntlOrderInfoDTO intlOrderInfoDTO) {
        Intrinsics.checkNotNullParameter(intlOrderInfoDTO, "");
        String exchangeDate = intlOrderInfoDTO.getExchangeDate();
        ExchangeRate exchangeRate = intlOrderInfoDTO.getExchangeRate();
        ExchangeRateModel authRequestContext = exchangeRate != null ? ExchangeRateModelKt.getAuthRequestContext(exchangeRate) : null;
        OriginAmount originOrderAmount = intlOrderInfoDTO.getOriginOrderAmount();
        OriginAmountModel PlaceComponentResult = originOrderAmount != null ? OriginAmountModelKt.PlaceComponentResult(originOrderAmount) : null;
        OriginAmount originConvertAmount = intlOrderInfoDTO.getOriginConvertAmount();
        return new IntlOrderInfoDTOModel(exchangeDate, authRequestContext, PlaceComponentResult, originConvertAmount != null ? OriginAmountModelKt.PlaceComponentResult(originConvertAmount) : null);
    }
}
