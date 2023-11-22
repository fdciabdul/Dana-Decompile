package id.dana.richview.statement.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0011\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/richview/statement/model/PointModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "<init>", "(IILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PointModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int PlaceComponentResult;
    public final int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PointModel) {
            PointModel pointModel = (PointModel) p0;
            return this.MyBillsEntityDataFactory == pointModel.MyBillsEntityDataFactory && this.PlaceComponentResult == pointModel.PlaceComponentResult && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, pointModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.MyBillsEntityDataFactory * 31) + this.PlaceComponentResult) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PointModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public PointModel(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.MyBillsEntityDataFactory = i;
        this.PlaceComponentResult = i2;
        this.BuiltInFictitiousFunctionClassFactory = str;
    }
}
