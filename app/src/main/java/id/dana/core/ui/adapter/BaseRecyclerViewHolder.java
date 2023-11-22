package id.dana.core.ui.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/core/ui/adapter/BaseRecyclerViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/Object;)V", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    public abstract void MyBillsEntityDataFactory(T p0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRecyclerViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "");
    }
}
