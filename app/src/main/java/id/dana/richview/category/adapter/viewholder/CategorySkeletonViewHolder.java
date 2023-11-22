package id.dana.richview.category.adapter.viewholder;

import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.EllipseTextView;
import id.dana.richview.category.model.CategoryModel;

/* loaded from: classes5.dex */
public class CategorySkeletonViewHolder extends BaseRecyclerViewHolder<CategoryModel> {
    @BindView(R.id.etv_skeleton)
    EllipseTextView etvSkeleton;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(CategoryModel categoryModel) {
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.etvSkeleton);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_skeleton_ellipse_text;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
        new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0).MyBillsEntityDataFactory();
    }

    public CategorySkeletonViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_skeleton_ellipse_text, viewGroup);
    }
}
