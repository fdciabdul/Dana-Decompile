package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Landroidx/core/view/ViewKt$doOnAttach$1;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "p0", "", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes3.dex */
public final class ViewKt$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Function1<View, Unit> KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ View MyBillsEntityDataFactory;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.removeOnAttachStateChangeListener(this);
        this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(p0);
    }
}
