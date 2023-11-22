package id.dana.base;

import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lid/dana/base/ThrottledOnExecuteAction;", "", "()V", "lastActionMap", "", "", "", "execute", "", "actionId", "action", "Lkotlin/Function0;", "interval", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ThrottledOnExecuteAction {
    private final Map<Integer, Long> PlaceComponentResult = new WeakHashMap();

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, Function0<Unit> function0, long j) {
        Intrinsics.checkNotNullParameter(function0, "");
        Long l = this.PlaceComponentResult.get(Integer.valueOf(i));
        long currentTimeMillis = System.currentTimeMillis();
        this.PlaceComponentResult.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        if (l == null || currentTimeMillis - l.longValue() > j) {
            function0.invoke();
        }
    }
}
