package id.dana.nearbyme.merchantreview.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemMyReviewBinding;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.merchantreview.MyReviewView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\r\u0010\u000eR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyme/merchantreview/viewholder/MyReviewViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "Lid/dana/databinding/ItemMyReviewBinding;", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyReviewViewHolder extends ViewBindingRecyclerViewHolder<MerchantReviewViewModel, ItemMyReviewBinding> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function1<MerchantReviewModel, Unit> MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        MerchantReviewViewModel merchantReviewViewModel = (MerchantReviewViewModel) obj;
        getBinding().MyBillsEntityDataFactory.setData(merchantReviewViewModel);
        MyReviewView myReviewView = getBinding().MyBillsEntityDataFactory;
        myReviewView.setData(merchantReviewViewModel);
        myReviewView.setEditReviewListener(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemMyReviewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemMyReviewBinding BuiltInFictitiousFunctionClassFactory = ItemMyReviewBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MyReviewViewHolder(android.view.ViewGroup r3, kotlin.jvm.functions.Function1<? super id.dana.nearbyme.merchantdetail.model.MerchantReviewModel, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559186(0x7f0d0312, float:1.8743709E38)
            r2.<init>(r1, r0, r3)
            r2.MyBillsEntityDataFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.viewholder.MyReviewViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function1):void");
    }
}
