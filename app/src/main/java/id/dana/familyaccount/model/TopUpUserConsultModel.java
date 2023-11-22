package id.dana.familyaccount.model;

import id.dana.domain.payasset.model.PayMethodView;
import id.dana.model.CurrencyAmountModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/familyaccount/model/TopUpUserConsultModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/model/CurrencyAmountModel;", "getAuthRequestContext", "Lid/dana/model/CurrencyAmountModel;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "", "Lid/dana/domain/payasset/model/PayMethodView;", "lookAheadTest", "Ljava/util/List;", "scheduleImpl", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/util/List;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/model/CurrencyAmountModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TopUpUserConsultModel {
    public final MoneyViewModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MoneyViewModel MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MoneyViewModel getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final CurrencyAmountModel PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final List<PayMethodView> scheduleImpl;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TopUpUserConsultModel) {
            TopUpUserConsultModel topUpUserConsultModel = (TopUpUserConsultModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, topUpUserConsultModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, topUpUserConsultModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.scheduleImpl, topUpUserConsultModel.scheduleImpl) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, topUpUserConsultModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, topUpUserConsultModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, topUpUserConsultModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        MoneyViewModel moneyViewModel = this.getAuthRequestContext;
        int hashCode = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        MoneyViewModel moneyViewModel2 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        List<PayMethodView> list = this.scheduleImpl;
        int hashCode3 = list == null ? 0 : list.hashCode();
        MoneyViewModel moneyViewModel3 = this.MyBillsEntityDataFactory;
        int hashCode4 = moneyViewModel3 == null ? 0 : moneyViewModel3.hashCode();
        MoneyViewModel moneyViewModel4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (moneyViewModel4 != null ? moneyViewModel4.hashCode() : 0)) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpUserConsultModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TopUpUserConsultModel(MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, List<? extends PayMethodView> list, MoneyViewModel moneyViewModel3, MoneyViewModel moneyViewModel4, CurrencyAmountModel currencyAmountModel) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        this.getAuthRequestContext = moneyViewModel;
        this.BuiltInFictitiousFunctionClassFactory = moneyViewModel2;
        this.scheduleImpl = list;
        this.MyBillsEntityDataFactory = moneyViewModel3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moneyViewModel4;
        this.PlaceComponentResult = currencyAmountModel;
    }
}
