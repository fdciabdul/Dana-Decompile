package id.dana.explore.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\r\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/explore/model/ExploreProductWrapper;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/explore/model/ExploreProductModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/explore/model/ExploreProductModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "I", "p1", "<init>", "(ILid/dana/explore/model/ExploreProductModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExploreProductWrapper {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public ExploreProductModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ExploreProductWrapper) {
            ExploreProductWrapper exploreProductWrapper = (ExploreProductWrapper) p0;
            return this.BuiltInFictitiousFunctionClassFactory == exploreProductWrapper.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, exploreProductWrapper.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        return (this.BuiltInFictitiousFunctionClassFactory * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExploreProductWrapper(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public ExploreProductWrapper(int i, ExploreProductModel exploreProductModel) {
        Intrinsics.checkNotNullParameter(exploreProductModel, "");
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = exploreProductModel;
    }
}
