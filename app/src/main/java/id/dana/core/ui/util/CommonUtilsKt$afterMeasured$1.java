package id.dana.core.ui.util;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX WARN: Incorrect field signature: TT; */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/core/ui/util/CommonUtilsKt$afterMeasured$1;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "()V"}, k = 1, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes4.dex */
public final class CommonUtilsKt$afterMeasured$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ View BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ Function1<T, Unit> PlaceComponentResult;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.BuiltInFictitiousFunctionClassFactory.getMeasuredWidth() <= 0 || this.BuiltInFictitiousFunctionClassFactory.getMeasuredHeight() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.BuiltInFictitiousFunctionClassFactory.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        this.PlaceComponentResult.invoke(this.BuiltInFictitiousFunctionClassFactory);
    }
}
