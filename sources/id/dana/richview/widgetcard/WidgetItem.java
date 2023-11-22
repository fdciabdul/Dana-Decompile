package id.dana.richview.widgetcard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\r"}, d2 = {"Lid/dana/richview/widgetcard/WidgetItem;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "Ljava/lang/Boolean;", "MyBillsEntityDataFactory", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class WidgetItem {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof WidgetItem) {
            WidgetItem widgetItem = (WidgetItem) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, widgetItem.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, widgetItem.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, widgetItem.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, widgetItem.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, widgetItem.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode2 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        String str = this.MyBillsEntityDataFactory;
        int hashCode3 = str == null ? 0 : str.hashCode();
        Boolean bool = this.getAuthRequestContext;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str2 = this.PlaceComponentResult;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WidgetItem(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public WidgetItem(String str, String str2, String str3, Boolean bool, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.MyBillsEntityDataFactory = str3;
        this.getAuthRequestContext = bool;
        this.PlaceComponentResult = str4;
    }
}
