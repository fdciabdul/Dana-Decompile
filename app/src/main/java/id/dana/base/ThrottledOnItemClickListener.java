package id.dana.base;

import android.os.SystemClock;
import id.dana.base.BaseRecyclerViewHolder;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B,\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0007\u0012\u0019\u0010\u0013\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR'\u0010\f\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/base/ThrottledOnItemClickListener;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "", "p0", "", "onItemClick", "(I)V", "", "MyBillsEntityDataFactory", "J", "KClassImpl$Data$declaredNonStaticMembers$2", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/Map;", "getAuthRequestContext", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "p1", "<init>", "(JLkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ThrottledOnItemClickListener implements BaseRecyclerViewHolder.OnItemClickListener {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Map<Integer, Long> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final long KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<Integer, Unit> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public ThrottledOnItemClickListener(long j, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        this.BuiltInFictitiousFunctionClassFactory = function1;
        this.getAuthRequestContext = new WeakHashMap();
    }

    public /* synthetic */ ThrottledOnItemClickListener(long j, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1000L : j, function1);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
    public final void onItemClick(int p0) {
        Long l = this.getAuthRequestContext.get(Integer.valueOf(p0));
        long uptimeMillis = SystemClock.uptimeMillis();
        this.getAuthRequestContext.put(Integer.valueOf(p0), Long.valueOf(uptimeMillis));
        if (l == null || uptimeMillis - l.longValue() > this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.BuiltInFictitiousFunctionClassFactory.invoke(Integer.valueOf(p0));
        }
    }
}
