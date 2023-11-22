package id.dana.base;

import android.os.SystemClock;
import android.view.View;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B,\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0007\u0012\u0019\u0010\u0013\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR'\u0010\u0012\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u000f\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/base/ThrottledOnClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "p0", "", "onClick", "(Landroid/view/View;)V", "", "MyBillsEntityDataFactory", "J", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/Map;", "PlaceComponentResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(JLkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ThrottledOnClickListener implements View.OnClickListener {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Map<View, Long> PlaceComponentResult;
    private final long MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function1<View, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Multi-variable type inference failed */
    private ThrottledOnClickListener(long j, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = j;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        this.PlaceComponentResult = new WeakHashMap();
    }

    public /* synthetic */ ThrottledOnClickListener(long j, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1000L : j, function1);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Long l = this.PlaceComponentResult.get(p0);
        long uptimeMillis = SystemClock.uptimeMillis();
        this.PlaceComponentResult.put(p0, Long.valueOf(uptimeMillis));
        if (l == null || uptimeMillis - l.longValue() > this.MyBillsEntityDataFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(p0);
        }
    }
}
