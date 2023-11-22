package id.dana.explore.model;

import id.dana.explore.domain.sku.model.ExploreServiceModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0011\u001a\u00020\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/explore/model/ExploreServiceWrapper;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/explore/domain/sku/model/ExploreServiceModel;", "getAuthRequestContext", "Lid/dana/explore/domain/sku/model/ExploreServiceModel;", "BuiltInFictitiousFunctionClassFactory", "Z", "PlaceComponentResult", "()Z", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "p1", "p2", "<init>", "(ILid/dana/explore/domain/sku/model/ExploreServiceModel;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExploreServiceWrapper {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public ExploreServiceModel BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ExploreServiceWrapper) {
            ExploreServiceWrapper exploreServiceWrapper = (ExploreServiceWrapper) p0;
            return this.PlaceComponentResult == exploreServiceWrapper.PlaceComponentResult && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, exploreServiceWrapper.BuiltInFictitiousFunctionClassFactory) && this.MyBillsEntityDataFactory == exploreServiceWrapper.MyBillsEntityDataFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int i = this.PlaceComponentResult;
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        boolean z = this.MyBillsEntityDataFactory;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (((i * 31) + hashCode) * 31) + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExploreServiceWrapper(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public ExploreServiceWrapper(int i, ExploreServiceModel exploreServiceModel, boolean z) {
        Intrinsics.checkNotNullParameter(exploreServiceModel, "");
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = exploreServiceModel;
        this.MyBillsEntityDataFactory = z;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
