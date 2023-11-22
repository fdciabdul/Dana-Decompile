package id.dana.richview.category.adapter.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.EllipseTextView;
import id.dana.richview.category.model.CategoryModel;
import id.dana.utils.StringWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/richview/category/adapter/viewholder/ChipCategoryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/richview/category/model/CategoryModel;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChipCategoryViewHolder extends BaseRecyclerViewHolder<CategoryModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(CategoryModel categoryModel) {
        CategoryModel categoryModel2 = categoryModel;
        Intrinsics.checkNotNullParameter(categoryModel2, "");
        EllipseTextView ellipseTextView = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity);
        if (ellipseTextView != null) {
            Context context = ellipseTextView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            ellipseTextView.setText(StringWrapperKt.getAuthRequestContext(context, StringWrapperKt.MyBillsEntityDataFactory(categoryModel2.BuiltInFictitiousFunctionClassFactory)));
            if (categoryModel2.getPlaceComponentResult()) {
                EllipseTextView ellipseTextView2 = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity);
                if (ellipseTextView2 != null) {
                    ellipseTextView2.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView2.getContext(), R.color.azure));
                    ellipseTextView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView2.getContext(), R.color.f27072131100488));
                    ellipseTextView2.setStrokeColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView2.getContext(), R.color.azure));
                    return;
                }
                return;
            }
            EllipseTextView ellipseTextView3 = (EllipseTextView) this.itemView.findViewById(R.id.CreateFamilyAccountEntity);
            if (ellipseTextView3 != null) {
                ellipseTextView3.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView3.getContext(), R.color.f27072131100488));
                ellipseTextView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView3.getContext(), R.color.f23042131099779));
                ellipseTextView3.setStrokeColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(ellipseTextView3.getContext(), R.color.f27032131100473));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipCategoryViewHolder(ViewGroup viewGroup, BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        super(viewGroup.getContext(), R.layout.view_ellipse_text, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        setOnItemClickListener(onItemClickListener);
    }
}
