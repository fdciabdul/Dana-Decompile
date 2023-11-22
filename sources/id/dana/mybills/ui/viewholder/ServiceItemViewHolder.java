package id.dana.mybills.ui.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import id.dana.mybills.databinding.ItemAllServiceV2Binding;
import id.dana.mybills.ui.model.MyBillsServiceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/mybills/ui/viewholder/ServiceItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/mybills/databinding/ItemAllServiceV2Binding;", "PlaceComponentResult", "Lid/dana/mybills/databinding/ItemAllServiceV2Binding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/ui/viewholder/ServiceItemViewHolder$OnServiceClickCallback;", "getAuthRequestContext", "Lid/dana/mybills/ui/viewholder/ServiceItemViewHolder$OnServiceClickCallback;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/mybills/databinding/ItemAllServiceV2Binding;Lid/dana/mybills/ui/viewholder/ServiceItemViewHolder$OnServiceClickCallback;)V", "OnServiceClickCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ServiceItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ItemAllServiceV2Binding BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final OnServiceClickCallback MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/ui/viewholder/ServiceItemViewHolder$OnServiceClickCallback;", "", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/mybills/ui/model/MyBillsServiceModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface OnServiceClickCallback {
        void getAuthRequestContext(MyBillsServiceModel p0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceItemViewHolder(ItemAllServiceV2Binding itemAllServiceV2Binding, OnServiceClickCallback onServiceClickCallback) {
        super(itemAllServiceV2Binding.BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullParameter(itemAllServiceV2Binding, "");
        Intrinsics.checkNotNullParameter(onServiceClickCallback, "");
        this.BuiltInFictitiousFunctionClassFactory = itemAllServiceV2Binding;
        this.MyBillsEntityDataFactory = onServiceClickCallback;
    }
}
