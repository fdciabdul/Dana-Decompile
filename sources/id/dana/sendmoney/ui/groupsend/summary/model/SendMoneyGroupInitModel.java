package id.dana.sendmoney.ui.groupsend.summary.model;

import id.dana.core.ui.model.CurrencyAmountModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\n\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\r"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "", "Lid/dana/core/ui/model/CurrencyAmountModel;", "PlaceComponentResult", "Lid/dana/core/ui/model/CurrencyAmountModel;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "", "Z", "MyBillsEntityDataFactory", "", "Lid/dana/sendmoney/ui/groupsend/summary/model/PayeeUserInfoModel;", "Ljava/util/List;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/util/List;ZLid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendMoneyGroupInitModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final boolean MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final CurrencyAmountModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final CurrencyAmountModel PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final CurrencyAmountModel getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<PayeeUserInfoModel> KClassImpl$Data$declaredNonStaticMembers$2;

    public SendMoneyGroupInitModel(List<PayeeUserInfoModel> list, boolean z, CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, CurrencyAmountModel currencyAmountModel3) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        Intrinsics.checkNotNullParameter(currencyAmountModel2, "");
        Intrinsics.checkNotNullParameter(currencyAmountModel3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.MyBillsEntityDataFactory = z;
        this.BuiltInFictitiousFunctionClassFactory = currencyAmountModel;
        this.getAuthRequestContext = currencyAmountModel2;
        this.PlaceComponentResult = currencyAmountModel3;
    }
}
