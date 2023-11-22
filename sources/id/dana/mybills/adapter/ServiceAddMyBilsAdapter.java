package id.dana.mybills.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.domain.mybills.model.MyBillsServiceModel;
import id.dana.mybills.viewholder.ItemServiceViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/adapter/ServiceAddMyBilsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/mybills/viewholder/ItemServiceViewHolder;", "Lid/dana/domain/mybills/model/MyBillsServiceModel;", "Lid/dana/mybills/viewholder/ItemServiceViewHolder$OnServiceClickCallback;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/viewholder/ItemServiceViewHolder$OnServiceClickCallback;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceAddMyBilsAdapter extends BaseRecyclerViewAdapter<ItemServiceViewHolder, MyBillsServiceModel> {
    public ItemServiceViewHolder.OnServiceClickCallback BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemServiceViewHolder.OnServiceClickCallback onServiceClickCallback = this.BuiltInFictitiousFunctionClassFactory;
        if (onServiceClickCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onServiceClickCallback = null;
        }
        return new ItemServiceViewHolder(viewGroup, onServiceClickCallback);
    }
}
