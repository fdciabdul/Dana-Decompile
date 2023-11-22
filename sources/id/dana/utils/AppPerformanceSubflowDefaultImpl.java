package id.dana.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\tR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\f"}, d2 = {"Lid/dana/utils/AppPerformanceSubflowDefaultImpl;", "Lid/dana/utils/AppPerformanceSubflow;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/Long;", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Ljava/util/Map;", "PlaceComponentResult", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppPerformanceSubflowDefaultImpl implements AppPerformanceSubflow {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Map<String, Long> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Map<String, Long> PlaceComponentResult = new LinkedHashMap();

    public final Long BuiltInFictitiousFunctionClassFactory(String p0) {
        Long l = this.PlaceComponentResult.get(p0);
        if (l != null) {
            long longValue = l.longValue();
            Long l2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0);
            if (l2 != null) {
                return Long.valueOf(longValue - l2.longValue());
            }
            return null;
        }
        return null;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0) == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(p0, Long.valueOf(System.currentTimeMillis()));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.PlaceComponentResult.get(p0) == null) {
            this.PlaceComponentResult.put(p0, Long.valueOf(System.currentTimeMillis()));
            Unit unit = Unit.INSTANCE;
        }
    }
}
