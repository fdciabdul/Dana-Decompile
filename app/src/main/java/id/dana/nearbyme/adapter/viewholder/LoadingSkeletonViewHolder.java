package id.dana.nearbyme.adapter.viewholder;

import android.view.ViewGroup;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.model.MerchantItemWrapper;
import id.dana.utils.ShimmeringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/nearbyme/adapter/viewholder/LoadingSkeletonViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/MerchantItemWrapper;", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/SkeletonScreen;", "MyBillsEntityDataFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoadingSkeletonViewHolder extends BaseRecyclerViewHolder<MerchantItemWrapper> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ViewGroup PlaceComponentResult;
    private SkeletonScreen MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantItemWrapper merchantItemWrapper) {
        super.bindData(merchantItemWrapper);
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = ShimmeringUtil.PlaceComponentResult(this.itemView, R.layout.view_other_store_list_skeleton);
        }
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingSkeletonViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_other_store_list_skeleton, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.PlaceComponentResult = viewGroup;
    }
}
