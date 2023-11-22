package id.dana.base.viewbinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class ViewBindingFragment$binding$2<V> extends FunctionReferenceImpl implements Function1<View, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewBindingFragment$binding$2(Object obj) {
        super(1, obj, ViewBindingFragment.class, "initViewBinding", "initViewBinding(Landroid/view/View;)Landroidx/viewbinding/ViewBinding;", 0);
    }

    /* JADX WARN: Incorrect return type in method signature: (Landroid/view/View;)TV; */
    @Override // kotlin.jvm.functions.Function1
    public final ViewBinding invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        return ((ViewBindingFragment) this.receiver).initViewBinding(view);
    }
}
