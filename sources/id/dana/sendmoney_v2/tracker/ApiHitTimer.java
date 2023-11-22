package id.dana.sendmoney_v2.tracker;

import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/sendmoney_v2/tracker/ApiHitTimer;", "", "", "BuiltInFictitiousFunctionClassFactory", "()J", "PlaceComponentResult", "J", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApiHitTimer {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public long PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public long getAuthRequestContext;

    @Inject
    public ApiHitTimer() {
    }

    public final long BuiltInFictitiousFunctionClassFactory() {
        long j = this.PlaceComponentResult;
        if (j > 0) {
            long j2 = this.getAuthRequestContext;
            if (j2 > 0) {
                long j3 = j2 - j;
                if (j3 > 0) {
                    return j3;
                }
                return 0L;
            }
            return 0L;
        }
        return 0L;
    }
}
