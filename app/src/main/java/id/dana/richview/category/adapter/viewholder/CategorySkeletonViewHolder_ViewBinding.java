package id.dana.richview.category.adapter.viewholder;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.EllipseTextView;

/* loaded from: classes9.dex */
public class CategorySkeletonViewHolder_ViewBinding implements Unbinder {
    private CategorySkeletonViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

    public CategorySkeletonViewHolder_ViewBinding(CategorySkeletonViewHolder categorySkeletonViewHolder, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = categorySkeletonViewHolder;
        categorySkeletonViewHolder.etvSkeleton = (EllipseTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.etv_skeleton, "field 'etvSkeleton'", EllipseTextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        CategorySkeletonViewHolder categorySkeletonViewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (categorySkeletonViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        categorySkeletonViewHolder.etvSkeleton = null;
    }
}
