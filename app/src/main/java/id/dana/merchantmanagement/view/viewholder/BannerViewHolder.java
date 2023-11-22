package id.dana.merchantmanagement.view.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemListBannerBinding;
import id.dana.merchantmanagement.adapter.LinkedMerchantClickListener;
import id.dana.merchantmanagement.model.LinkedMerchantModel;
import id.dana.model.CdpContentModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/merchantmanagement/view/viewholder/BannerViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/merchantmanagement/model/LinkedMerchantModel;", "Lid/dana/databinding/ItemListBannerBinding;", "Lid/dana/merchantmanagement/adapter/LinkedMerchantClickListener;", "getAuthRequestContext", "Lid/dana/merchantmanagement/adapter/LinkedMerchantClickListener;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/merchantmanagement/adapter/LinkedMerchantClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerViewHolder extends ViewBindingRecyclerViewHolder<LinkedMerchantModel, ItemListBannerBinding> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final LinkedMerchantClickListener BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* bridge */ /* synthetic */ void bindData(Object obj) {
        LinkedMerchantModel linkedMerchantModel = (LinkedMerchantModel) obj;
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemListBannerBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemListBannerBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemListBannerBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BannerViewHolder(android.view.ViewGroup r3, id.dana.merchantmanagement.adapter.LinkedMerchantClickListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559144(0x7f0d02e8, float:1.8743624E38)
            r2.<init>(r1, r0, r3)
            r2.BuiltInFictitiousFunctionClassFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.merchantmanagement.view.viewholder.BannerViewHolder.<init>(android.view.ViewGroup, id.dana.merchantmanagement.adapter.LinkedMerchantClickListener):void");
    }

    public static /* synthetic */ void PlaceComponentResult(BannerViewHolder bannerViewHolder, List list) {
        Intrinsics.checkNotNullParameter(bannerViewHolder, "");
        Intrinsics.checkNotNullParameter(list, "");
        bannerViewHolder.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext((CdpContentModel) CollectionsKt.first(list));
    }
}
