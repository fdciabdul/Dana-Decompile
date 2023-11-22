package id.dana.mybills.model;

import id.dana.domain.mybills.model.HighlightTransactionPayRequest;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/model/HighlightTransactionPayRequestModel;", "Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/model/HighlightTransactionPayRequestModel;)Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HighlightTransactionPayRequestModelKt {
    public static final HighlightTransactionPayRequest BuiltInFictitiousFunctionClassFactory(HighlightTransactionPayRequestModel highlightTransactionPayRequestModel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        Intrinsics.checkNotNullParameter(highlightTransactionPayRequestModel, "");
        String str8 = highlightTransactionPayRequestModel.BuiltInFictitiousFunctionClassFactory;
        MoneyView moneyView = new MoneyView(highlightTransactionPayRequestModel.PlaceComponentResult.PlaceComponentResult, highlightTransactionPayRequestModel.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, highlightTransactionPayRequestModel.PlaceComponentResult.getAuthRequestContext);
        String str9 = highlightTransactionPayRequestModel.MyBillsEntityDataFactory;
        MoneyViewModel moneyViewModel = highlightTransactionPayRequestModel.getAuthRequestContext;
        if (moneyViewModel == null || (str = moneyViewModel.PlaceComponentResult) == null) {
            str = "";
        }
        MoneyViewModel moneyViewModel2 = highlightTransactionPayRequestModel.getAuthRequestContext;
        if (moneyViewModel2 == null || (str2 = moneyViewModel2.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            str2 = "";
        }
        MoneyViewModel moneyViewModel3 = highlightTransactionPayRequestModel.getAuthRequestContext;
        if (moneyViewModel3 == null || (str3 = moneyViewModel3.getAuthRequestContext) == null) {
            str3 = "";
        }
        MoneyView moneyView2 = new MoneyView(str, str2, str3);
        MoneyViewModel moneyViewModel4 = highlightTransactionPayRequestModel.KClassImpl$Data$declaredNonStaticMembers$2;
        if (moneyViewModel4 == null || (str4 = moneyViewModel4.PlaceComponentResult) == null) {
            str4 = "";
        }
        MoneyViewModel moneyViewModel5 = highlightTransactionPayRequestModel.KClassImpl$Data$declaredNonStaticMembers$2;
        if (moneyViewModel5 == null || (str5 = moneyViewModel5.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            str5 = "";
        }
        MoneyViewModel moneyViewModel6 = highlightTransactionPayRequestModel.KClassImpl$Data$declaredNonStaticMembers$2;
        if (moneyViewModel6 != null && (str6 = moneyViewModel6.getAuthRequestContext) != null) {
            str7 = str6;
        }
        return new HighlightTransactionPayRequest(str8, moneyView, str9, moneyView2, new MoneyView(str4, str5, str7));
    }
}
