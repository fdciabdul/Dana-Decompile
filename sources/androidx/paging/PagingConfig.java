package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014BA\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0011\u0010\t\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007"}, d2 = {"Landroidx/paging/PagingConfig;", "", "", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "", "I", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getErrorConfigVersion", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(IIZIII)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingConfig {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int PlaceComponentResult;
    public final int KClassImpl$Data$declaredNonStaticMembers$2;
    public final int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final boolean BuiltInFictitiousFunctionClassFactory;
    public final int getErrorConfigVersion;

    private PagingConfig(int i, int i2, boolean z, int i3, int i4, int i5) {
        this.getAuthRequestContext = i;
        this.getErrorConfigVersion = i2;
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.PlaceComponentResult = i3;
        this.MyBillsEntityDataFactory = i4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
        if (!z && i2 == 0) {
            throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in PagingData, so either placeholders must be enabled, or prefetch distance must be > 0.");
        }
        if (i4 == Integer.MAX_VALUE || i4 >= (i2 * 2) + i) {
            if (!(i5 == Integer.MIN_VALUE || i5 > 0)) {
                throw new IllegalArgumentException("jumpThreshold must be positive to enable jumps or COUNT_UNDEFINED to disable jumping.".toString());
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=");
        sb.append(i);
        sb.append(", prefetchDist=");
        sb.append(i2);
        sb.append(", maxSize=");
        sb.append(i4);
        throw new IllegalArgumentException(sb.toString());
    }

    public /* synthetic */ PagingConfig(int i, int i2, boolean z, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i6 & 2) != 0 ? i : i2, (i6 & 4) != 0 ? true : z, (i6 & 8) != 0 ? i * 3 : i3, (i6 & 16) != 0 ? Integer.MAX_VALUE : i4, (i6 & 32) != 0 ? Integer.MIN_VALUE : i5);
    }
}
