package id.dana.data.mybills.model.result;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.mybills.model.MyBillPaymentCycleInfoViews;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/mybills/model/result/PaymentCycleInfoViewsResult;", "Lid/dana/domain/mybills/model/MyBillPaymentCycleInfoViews;", "PlaceComponentResult", "(Lid/dana/data/mybills/model/result/PaymentCycleInfoViewsResult;)Lid/dana/domain/mybills/model/MyBillPaymentCycleInfoViews;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaymentCycleInfoViewsResultKt {
    public static final MyBillPaymentCycleInfoViews PlaceComponentResult(PaymentCycleInfoViewsResult paymentCycleInfoViewsResult) {
        Intrinsics.checkNotNullParameter(paymentCycleInfoViewsResult, "");
        boolean kClassImpl$Data$declaredNonStaticMembers$2 = paymentCycleInfoViewsResult.getKClassImpl$Data$declaredNonStaticMembers$2();
        return new MyBillPaymentCycleInfoViews(Boolean.valueOf(kClassImpl$Data$declaredNonStaticMembers$2), paymentCycleInfoViewsResult.PlaceComponentResult, paymentCycleInfoViewsResult.BuiltInFictitiousFunctionClassFactory, paymentCycleInfoViewsResult.MyBillsEntityDataFactory, paymentCycleInfoViewsResult.getAuthRequestContext, MoneyViewEntityMapperKt.toMoneyView(paymentCycleInfoViewsResult.moveToNextValue));
    }
}
