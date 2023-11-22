package id.dana.sendmoney.summary.amountcalculation;

import id.dana.model.CurrencyAmountModel;
import id.dana.utils.CurrencyAmountUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a)\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/model/CurrencyAmountModel;", "p0", "p1", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/model/CurrencyAmountModel;Lid/dana/model/CurrencyAmountModel;Lid/dana/model/CurrencyAmountModel;)Ljava/lang/String;", "getAuthRequestContext", "(Lid/dana/model/CurrencyAmountModel;Lid/dana/model/CurrencyAmountModel;)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AmountCalculationExtKt {
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, CurrencyAmountModel currencyAmountModel3) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        CurrencyAmountUtil currencyAmountUtil = CurrencyAmountUtil.INSTANCE;
        CurrencyAmountModel currencyAmountModel4 = new CurrencyAmountModel(CurrencyAmountUtil.BuiltInFictitiousFunctionClassFactory(currencyAmountModel, currencyAmountModel2));
        CurrencyAmountUtil currencyAmountUtil2 = CurrencyAmountUtil.INSTANCE;
        return CurrencyAmountUtil.MyBillsEntityDataFactory(currencyAmountModel4, currencyAmountModel3);
    }

    public static final String getAuthRequestContext(CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        CurrencyAmountUtil currencyAmountUtil = CurrencyAmountUtil.INSTANCE;
        CurrencyAmountModel currencyAmountModel3 = new CurrencyAmountModel(CurrencyAmountUtil.BuiltInFictitiousFunctionClassFactory(currencyAmountModel, null));
        CurrencyAmountUtil currencyAmountUtil2 = CurrencyAmountUtil.INSTANCE;
        return CurrencyAmountUtil.MyBillsEntityDataFactory(currencyAmountModel3, currencyAmountModel2);
    }
}
