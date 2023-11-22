package androidx.core.graphics;

import android.graphics.PointF;

/* loaded from: classes6.dex */
public final class PathSegment {
    private final PointF BuiltInFictitiousFunctionClassFactory;
    private final float KClassImpl$Data$declaredNonStaticMembers$2;
    private final float MyBillsEntityDataFactory;
    private final PointF PlaceComponentResult;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PathSegment) {
            PathSegment pathSegment = (PathSegment) obj;
            return Float.compare(this.KClassImpl$Data$declaredNonStaticMembers$2, pathSegment.KClassImpl$Data$declaredNonStaticMembers$2) == 0 && Float.compare(this.MyBillsEntityDataFactory, pathSegment.MyBillsEntityDataFactory) == 0 && this.PlaceComponentResult.equals(pathSegment.PlaceComponentResult) && this.BuiltInFictitiousFunctionClassFactory.equals(pathSegment.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        float f = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int floatToIntBits = f != 0.0f ? Float.floatToIntBits(f) : 0;
        int hashCode2 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        float f2 = this.MyBillsEntityDataFactory;
        return (((((hashCode * 31) + floatToIntBits) * 31) + hashCode2) * 31) + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PathSegment{start=");
        sb.append(this.PlaceComponentResult);
        sb.append(", startFraction=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", end=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", endFraction=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('}');
        return sb.toString();
    }
}
