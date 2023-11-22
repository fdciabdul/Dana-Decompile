package id.dana.data.expresspurchase.mapper;

import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyDealsResponse;
import id.dana.domain.expresspurchase.interaction.model.DealsPaymentResult;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyDeals;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyDealsResponse;", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyDeals;", "toQuickBuyDeals", "(Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyDealsResponse;)Lid/dana/domain/expresspurchase/interaction/model/QuickBuyDeals;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QuickBuyDealsResponseMapperKt {
    public static final QuickBuyDeals toQuickBuyDeals(QuickBuyDealsResponse quickBuyDealsResponse) {
        DealsPaymentResult dealsPaymentResult;
        Intrinsics.checkNotNullParameter(quickBuyDealsResponse, "");
        String acquirementId = quickBuyDealsResponse.getAcquirementId();
        DealsPaymentResult[] values = DealsPaymentResult.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                dealsPaymentResult = null;
                break;
            }
            dealsPaymentResult = values[i];
            if (Intrinsics.areEqual(dealsPaymentResult.getValue(), quickBuyDealsResponse.getQuickBuyStatus())) {
                break;
            }
            i++;
        }
        return new QuickBuyDeals(acquirementId, dealsPaymentResult);
    }
}
