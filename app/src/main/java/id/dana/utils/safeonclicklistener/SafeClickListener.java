package id.dana.utils.safeonclicklistener;

import android.os.SystemClock;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0007\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/utils/safeonclicklistener/SafeClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "p0", "", "onClick", "(Landroid/view/View;)V", "", "getAuthRequestContext", "I", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "J", "Lkotlin/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "p1", "<init>", "(ILkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SafeClickListener implements View.OnClickListener {
    private final Function1<View, Unit> KClassImpl$Data$declaredNonStaticMembers$2;
    private long PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* JADX WARN: Multi-variable type inference failed */
    private SafeClickListener(int i, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
    }

    public /* synthetic */ SafeClickListener(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1000 : i, function1);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View p0) {
        if (SystemClock.elapsedRealtime() - this.PlaceComponentResult < this.MyBillsEntityDataFactory) {
            return;
        }
        this.PlaceComponentResult = SystemClock.elapsedRealtime();
        if (p0 != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(p0);
        }
    }
}
