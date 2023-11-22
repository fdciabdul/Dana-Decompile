package id.dana.base.viewbinding;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.base.BaseRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B!\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0019J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00028\u00012\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00028\u00018G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "T", "V", "Lid/dana/base/BaseRecyclerViewHolder;", "", "dispose", "()V", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Ljava/lang/Object;", "_binding", "Ljava/lang/Object;", "getBinding", "()Ljava/lang/Object;", "binding", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "resource", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/content/Context;ILandroid/view/ViewGroup;)V", "itemView", "(Landroid/content/Context;Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ViewBindingRecyclerViewHolder<T, V> extends BaseRecyclerViewHolder<T> {
    private V _binding;

    protected abstract V initViewBinding(View view);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewBindingRecyclerViewHolder(Context context, int i, ViewGroup viewGroup) {
        super(context, i, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewBindingRecyclerViewHolder(Context context, View view) {
        super(context, view);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void dispose() {
        super.dispose();
        this._binding = null;
    }

    @JvmName(name = "getBinding")
    public final V getBinding() {
        V v = this._binding;
        if (v != null) {
            return v;
        }
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "");
        V initViewBinding = initViewBinding(view);
        this._binding = initViewBinding;
        return initViewBinding;
    }
}
