package id.dana.analytics.tracker.performanceduration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u001a\b\u0002\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f\u0012\u001a\b\u0002\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR#\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/analytics/tracker/performanceduration/PerformanceDurationModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "", "", "PlaceComponentResult", "Ljava/util/Map;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Ljava/lang/String;", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PerformanceDurationModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Map<String, Long> BuiltInFictitiousFunctionClassFactory;
    public final String MyBillsEntityDataFactory;
    final Map<String, List<Long>> PlaceComponentResult;
    public final Map<String, List<Long>> getAuthRequestContext;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PerformanceDurationModel) {
            PerformanceDurationModel performanceDurationModel = (PerformanceDurationModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, performanceDurationModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, performanceDurationModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, performanceDurationModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.MyBillsEntityDataFactory.hashCode() * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PerformanceDurationModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    private PerformanceDurationModel(String str, Map<String, List<Long>> map, Map<String, List<Long>> map2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(map2, "");
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = map;
        this.PlaceComponentResult = map2;
        this.BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();
    }

    public /* synthetic */ PerformanceDurationModel(String str, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap, (i & 4) != 0 ? new LinkedHashMap() : linkedHashMap2);
    }
}
