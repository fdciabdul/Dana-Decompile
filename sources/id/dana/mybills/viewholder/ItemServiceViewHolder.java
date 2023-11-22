package id.dana.mybills.viewholder;

import android.view.View;
import android.widget.ImageView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.databinding.ItemAllServiceBinding;
import id.dana.domain.mybills.model.MyBillsServiceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/viewholder/ItemServiceViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/domain/mybills/model/MyBillsServiceModel;", "Lid/dana/databinding/ItemAllServiceBinding;", "Lid/dana/mybills/viewholder/ItemServiceViewHolder$OnServiceClickCallback;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/viewholder/ItemServiceViewHolder$OnServiceClickCallback;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/mybills/viewholder/ItemServiceViewHolder$OnServiceClickCallback;)V", "OnServiceClickCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ItemServiceViewHolder extends ViewBindingRecyclerViewHolder<MyBillsServiceModel, ItemAllServiceBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final OnServiceClickCallback getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/viewholder/ItemServiceViewHolder$OnServiceClickCallback;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnServiceClickCallback {
        void getAuthRequestContext(String p0);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String str;
        final MyBillsServiceModel myBillsServiceModel = (MyBillsServiceModel) obj;
        getBinding().MyBillsEntityDataFactory.setText(myBillsServiceModel != null ? myBillsServiceModel.getName() : null);
        if (myBillsServiceModel == null || (str = myBillsServiceModel.getIcon()) == null) {
            str = "";
        }
        if (SvgLoader.getAuthRequestContext(str)) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.service_skeleton_circle;
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = getBinding().getAuthRequestContext;
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        } else {
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.service_skeleton_circle).MyBillsEntityDataFactory((ImageView) getBinding().getAuthRequestContext);
        }
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.viewholder.ItemServiceViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemServiceViewHolder.getAuthRequestContext(ItemServiceViewHolder.this, myBillsServiceModel);
            }
        });
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemAllServiceBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemAllServiceBinding authRequestContext = ItemAllServiceBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ItemServiceViewHolder(android.view.ViewGroup r3, id.dana.mybills.viewholder.ItemServiceViewHolder.OnServiceClickCallback r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559041(0x7f0d0281, float:1.8743415E38)
            r2.<init>(r1, r0, r3)
            r2.getAuthRequestContext = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.viewholder.ItemServiceViewHolder.<init>(android.view.ViewGroup, id.dana.mybills.viewholder.ItemServiceViewHolder$OnServiceClickCallback):void");
    }

    public static /* synthetic */ void getAuthRequestContext(ItemServiceViewHolder itemServiceViewHolder, MyBillsServiceModel myBillsServiceModel) {
        Intrinsics.checkNotNullParameter(itemServiceViewHolder, "");
        itemServiceViewHolder.getAuthRequestContext.getAuthRequestContext(myBillsServiceModel != null ? myBillsServiceModel.getLink() : null);
    }
}
