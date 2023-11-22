package id.dana.utils;

import android.os.SystemClock;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/utils/SafeClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "p0", "", "onClick", "(Landroid/view/View;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "J", "getAuthRequestContext", "Lkotlin/Function1;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SafeClickListener implements View.OnClickListener {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<View, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private long getAuthRequestContext;

    @Override // android.view.View.OnClickListener
    public final void onClick(View p0) {
        if (SystemClock.elapsedRealtime() - this.getAuthRequestContext < this.MyBillsEntityDataFactory) {
            return;
        }
        this.getAuthRequestContext = SystemClock.elapsedRealtime();
        if (p0 != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(p0);
        }
    }
}
