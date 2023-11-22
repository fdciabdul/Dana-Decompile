package id.dana.wallet_v3.view.search.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemWalletTitleBinding;
import id.dana.utils.StringWrapperKt;
import id.dana.wallet_v3.model.TitleModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/wallet_v3/view/search/viewholder/TitleViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "Lid/dana/databinding/ItemWalletTitleBinding;", "item", "", "bindData", "(Lid/dana/wallet_v3/model/WalletV3CardModel;)V", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ItemWalletTitleBinding;", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TitleViewHolder extends ViewBindingRecyclerViewHolder<WalletV3CardModel, ItemWalletTitleBinding> {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TitleViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559296(0x7f0d0380, float:1.8743932E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.view.search.viewholder.TitleViewHolder.<init>(android.view.ViewGroup):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final ItemWalletTitleBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemWalletTitleBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemWalletTitleBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(WalletV3CardModel item) {
        super.bindData((TitleViewHolder) item);
        if (item == null || !(item instanceof TitleModel)) {
            return;
        }
        TextView textView = getBinding().BuiltInFictitiousFunctionClassFactory;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        textView.setText(StringWrapperKt.getAuthRequestContext(context, ((TitleModel) item).getTitle()));
    }
}
