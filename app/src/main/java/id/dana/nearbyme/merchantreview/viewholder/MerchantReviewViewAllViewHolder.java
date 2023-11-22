package id.dana.nearbyme.merchantreview.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemBtnViewAllBinding;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewViewHolderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/nearbyme/merchantreview/viewholder/MerchantReviewViewAllViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewViewHolderModel;", "Lid/dana/databinding/ItemBtnViewAllBinding;", "Lkotlin/Function0;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewViewAllViewHolder extends ViewBindingRecyclerViewHolder<MerchantConsultReviewViewHolderModel, ItemBtnViewAllBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        MerchantConsultReviewViewHolderModel merchantConsultReviewViewHolderModel = (MerchantConsultReviewViewHolderModel) obj;
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.viewholder.MerchantReviewViewAllViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantReviewViewAllViewHolder.PlaceComponentResult(MerchantReviewViewAllViewHolder.this);
            }
        });
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemBtnViewAllBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemBtnViewAllBinding BuiltInFictitiousFunctionClassFactory = ItemBtnViewAllBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MerchantReviewViewAllViewHolder(android.view.ViewGroup r3, kotlin.jvm.functions.Function0<kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559064(0x7f0d0298, float:1.8743461E38)
            r2.<init>(r1, r0, r3)
            r2.BuiltInFictitiousFunctionClassFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.viewholder.MerchantReviewViewAllViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function0):void");
    }

    public static /* synthetic */ void PlaceComponentResult(MerchantReviewViewAllViewHolder merchantReviewViewAllViewHolder) {
        Intrinsics.checkNotNullParameter(merchantReviewViewAllViewHolder, "");
        merchantReviewViewAllViewHolder.BuiltInFictitiousFunctionClassFactory.invoke();
    }
}
