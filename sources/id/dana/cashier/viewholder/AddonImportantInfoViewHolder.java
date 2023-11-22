package id.dana.cashier.viewholder;

import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.AddonImportantInfoModel;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemCashierAddOnImportantInfoBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/viewholder/AddonImportantInfoViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/AddonImportantInfoModel;", "Lid/dana/databinding/ItemCashierAddOnImportantInfoBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddonImportantInfoViewHolder extends ViewBindingRecyclerViewHolder<AddonImportantInfoModel, ItemCashierAddOnImportantInfoBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        AddonImportantInfoModel addonImportantInfoModel = (AddonImportantInfoModel) obj;
        ItemCashierAddOnImportantInfoBinding binding = getBinding();
        if (addonImportantInfoModel != null) {
            binding.getAuthRequestContext.setText(addonImportantInfoModel.PlaceComponentResult);
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(addonImportantInfoModel.MyBillsEntityDataFactory).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_info_blue).PlaceComponentResult((int) R.drawable.ic_info_blue).MyBillsEntityDataFactory((ImageView) binding.MyBillsEntityDataFactory);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemCashierAddOnImportantInfoBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemCashierAddOnImportantInfoBinding PlaceComponentResult = ItemCashierAddOnImportantInfoBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AddonImportantInfoViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559068(0x7f0d029c, float:1.874347E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.AddonImportantInfoViewHolder.<init>(android.view.ViewGroup):void");
    }
}
