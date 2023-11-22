package id.dana.savings.model;

import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\f\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\f\u0012\u0006\u0010\u001e\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\u0019¢\u0006\u0004\b#\u0010$J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\r\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0013\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0012\u0010\u0010\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0014X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0011\u0010\u001c\u001a\u00020\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/savings/model/SavingUpdateInitModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "Lid/dana/savings/model/SavingCategoryModel;", "scheduleImpl", "lookAheadTest", "Lid/dana/savings/model/SavingModel;", "getErrorConfigVersion", "Lid/dana/savings/model/SavingModel;", "moveToNextValue", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/util/List;Ljava/util/List;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/savings/model/SavingModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SavingUpdateInitModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<String> getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final MoneyViewModel PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final SavingModel moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final List<SavingCategoryModel> lookAheadTest;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SavingUpdateInitModel) {
            SavingUpdateInitModel savingUpdateInitModel = (SavingUpdateInitModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, savingUpdateInitModel.getAuthRequestContext) && Intrinsics.areEqual(this.lookAheadTest, savingUpdateInitModel.lookAheadTest) && Intrinsics.areEqual(this.PlaceComponentResult, savingUpdateInitModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, savingUpdateInitModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, savingUpdateInitModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, savingUpdateInitModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.moveToNextValue, savingUpdateInitModel.moveToNextValue);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.getAuthRequestContext.hashCode() * 31) + this.lookAheadTest.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.moveToNextValue.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingUpdateInitModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(')');
        return sb.toString();
    }

    public SavingUpdateInitModel(List<String> list, List<SavingCategoryModel> list2, MoneyViewModel moneyViewModel, String str, String str2, String str3, SavingModel savingModel) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(savingModel, "");
        this.getAuthRequestContext = list;
        this.lookAheadTest = list2;
        this.PlaceComponentResult = moneyViewModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.moveToNextValue = savingModel;
    }
}
