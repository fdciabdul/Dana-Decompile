package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¸\u0006\u0010"}, d2 = {"Landroidx/core/view/ViewKt$doOnNextLayout$1;", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "p0", "", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "androidx/core/view/ViewKt$doOnNextLayout$1"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes3.dex */
public final class ViewKt$doOnLayout$$inlined$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ Function1 MyBillsEntityDataFactory;

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.removeOnLayoutChangeListener(this);
        this.MyBillsEntityDataFactory.invoke(p0);
    }
}
