package id.dana.cashier.model;

import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/cashier/model/AdditionalFeeModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "p1", "p2", "<init>", "(Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AdditionalFeeModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MoneyViewModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof AdditionalFeeModel) {
            AdditionalFeeModel additionalFeeModel = (AdditionalFeeModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, additionalFeeModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, additionalFeeModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, additionalFeeModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        MoneyViewModel moneyViewModel = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        String str = this.PlaceComponentResult;
        return (((hashCode * 31) + hashCode2) * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdditionalFeeModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public AdditionalFeeModel(String str, MoneyViewModel moneyViewModel, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = moneyViewModel;
        this.PlaceComponentResult = str2;
    }

    public /* synthetic */ AdditionalFeeModel(String str, MoneyViewModel moneyViewModel, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, moneyViewModel, (i & 4) != 0 ? null : str2);
    }
}
