package id.dana.cardbinding.model;

import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "p0", "Lid/dana/cashier/model/CashierPayMethodModel;", "p1", "p2", "p3", "Lid/dana/cashier/domain/model/CashierPayRequest;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Lid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/CashierPayRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayParamRequestExtKt {
    public static final CashierPayRequest BuiltInFictitiousFunctionClassFactory(String str, CashierPayMethodModel cashierPayMethodModel, String str2, String str3) {
        CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory;
        AssetCardModel assetCardModel;
        CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory2;
        AssetCardModel assetCardModel2;
        CashierPayMethodModel.NewCardData scheduleImpl;
        CashierPayMethodModel.NewCardData scheduleImpl2;
        CashierPayMethodModel.NewCardData scheduleImpl3;
        CashierPayMethodModel.NewCardData scheduleImpl4;
        CashierPayMethodModel.NewCardData scheduleImpl5;
        CashierPayMethodModel.NewCardData scheduleImpl6;
        CashierPayMethodModel.NewCardData scheduleImpl7;
        CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory3;
        AssetCardModel assetCardModel3;
        Intrinsics.checkNotNullParameter(str, "");
        String str4 = null;
        String str5 = (cashierPayMethodModel == null || (MyBillsEntityDataFactory3 = CashierPayMethodModelKt.MyBillsEntityDataFactory(cashierPayMethodModel)) == null || (assetCardModel3 = MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel3.getAuthRequestContext;
        String str6 = (cashierPayMethodModel == null || (scheduleImpl7 = CashierPayMethodModelKt.scheduleImpl(cashierPayMethodModel)) == null) ? null : scheduleImpl7.PlaceComponentResult;
        String str7 = (cashierPayMethodModel == null || (scheduleImpl6 = CashierPayMethodModelKt.scheduleImpl(cashierPayMethodModel)) == null) ? null : scheduleImpl6.getAuthRequestContext;
        String str8 = (cashierPayMethodModel == null || (scheduleImpl5 = CashierPayMethodModelKt.scheduleImpl(cashierPayMethodModel)) == null) ? null : scheduleImpl5.KClassImpl$Data$declaredNonStaticMembers$2;
        String str9 = (cashierPayMethodModel == null || (scheduleImpl4 = CashierPayMethodModelKt.scheduleImpl(cashierPayMethodModel)) == null) ? null : scheduleImpl4.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str10 = (cashierPayMethodModel == null || (scheduleImpl3 = CashierPayMethodModelKt.scheduleImpl(cashierPayMethodModel)) == null) ? null : scheduleImpl3.scheduleImpl;
        String str11 = (cashierPayMethodModel == null || (scheduleImpl2 = CashierPayMethodModelKt.scheduleImpl(cashierPayMethodModel)) == null) ? null : scheduleImpl2.lookAheadTest;
        Boolean valueOf = (cashierPayMethodModel == null || (scheduleImpl = CashierPayMethodModelKt.scheduleImpl(cashierPayMethodModel)) == null) ? null : Boolean.valueOf(scheduleImpl.getMoveToNextValue());
        String str12 = (cashierPayMethodModel == null || (MyBillsEntityDataFactory2 = CashierPayMethodModelKt.MyBillsEntityDataFactory(cashierPayMethodModel)) == null || (assetCardModel2 = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : assetCardModel2.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (cashierPayMethodModel != null && (MyBillsEntityDataFactory = CashierPayMethodModelKt.MyBillsEntityDataFactory(cashierPayMethodModel)) != null && (assetCardModel = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            str4 = assetCardModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }
        return new CashierPayRequest("cashierPay", str11, str, null, str10, str8, str7, str6, valueOf, null, null, null, null, str4, null, str5, null, null, str2, null, null, null, null, null, null, null, str12, null, null, str3, "1.0", null, null, null, null, null, null, null, null, null, str9, null, -1678025208, 767, null);
    }
}
