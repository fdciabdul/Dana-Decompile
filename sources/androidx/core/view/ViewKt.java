package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/view/View;", "", "p0", "Lkotlin/Function0;", "", "p1", "Ljava/lang/Runnable;", "MyBillsEntityDataFactory", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)Ljava/lang/Runnable;"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewKt {
    public static final Runnable MyBillsEntityDataFactory(View view, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ViewKt.PlaceComponentResult(Function0.this);
            }
        };
        Api16Impl.PlaceComponentResult(view, runnable, 1000L);
        return runnable;
    }

    public static /* synthetic */ void PlaceComponentResult(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
