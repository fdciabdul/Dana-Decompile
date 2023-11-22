package id.dana.richview.category;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.richview.category.adapter.CategoryAdapter;
import id.dana.richview.category.model.CategoryModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class CategoryView extends BaseRichView {
    private CategoryModel BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private CategoryAdapter MyBillsEntityDataFactory;
    private OnClickListener PlaceComponentResult;
    private String getAuthRequestContext;
    @BindView(R.id.f4003res_0x7f0a0d8c_pagingdatatransforms_insertseparators_1)
    LinearLayout llCategory;
    private SkeletonScreen moveToNextValue;
    @BindView(R.id.f4138res_0x7f0a1144_rxconvertkt_ascompletable_1)
    RecyclerView rvCategory;
    @BindView(R.id.view_divider)
    View viewDivider;

    /* loaded from: classes5.dex */
    public interface OnClickListener {
        void PlaceComponentResult(CategoryModel categoryModel, boolean z);
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_category;
    }

    public CategoryView(Context context) {
        super(context);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    public CategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    public CategoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    public void showShimmer() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        SkeletonScreen skeletonScreen = this.moveToNextValue;
        if (skeletonScreen == null) {
            RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.rvCategory);
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_skeleton_ellipse_text;
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 6;
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
            this.moveToNextValue = recyclerViewSkeletonScreen;
            return;
        }
        skeletonScreen.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getOnCLickListener$0$id-dana-richview-category-CategoryView  reason: not valid java name */
    public /* synthetic */ void m2833x9fca2fc5(int i) {
        CategoryAdapter categoryAdapter = this.MyBillsEntityDataFactory;
        List<CategoryModel> items = categoryAdapter.getItems();
        int i2 = i;
        int i3 = 0;
        while (i3 < items.size()) {
            CategoryModel categoryModel = items.get(i3);
            boolean z = i2 == i3;
            if (categoryModel.getPlaceComponentResult() && z && !categoryAdapter.PlaceComponentResult(i2)) {
                items.get(categoryAdapter.MyBillsEntityDataFactory).PlaceComponentResult = true;
                categoryModel.PlaceComponentResult = false;
                i2 = categoryAdapter.MyBillsEntityDataFactory;
            } else {
                categoryModel.PlaceComponentResult = z;
            }
            i3++;
        }
        categoryAdapter.setItems(items);
        categoryAdapter.notifyDataSetChanged();
        if (!this.MyBillsEntityDataFactory.getItem(i).getPlaceComponentResult()) {
            i = 0;
        }
        boolean z2 = i == 0;
        this.rvCategory.smoothScrollToPosition(i);
        this.getAuthRequestContext = this.MyBillsEntityDataFactory.getItem(i).MyBillsEntityDataFactory;
        CategoryModel item = this.MyBillsEntityDataFactory.getItem(i);
        OnClickListener onClickListener = this.PlaceComponentResult;
        if (onClickListener == null || item == null) {
            return;
        }
        onClickListener.PlaceComponentResult(item, z2);
    }

    public boolean isLoading() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setLoading(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    public void setOnCategoryScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        RecyclerView recyclerView = this.rvCategory;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public void setData(List<CategoryModel> list) {
        if (list != null) {
            hideShimmer();
            this.getAuthRequestContext = list.get(0).MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory.setItems(getAuthRequestContext(list));
            this.MyBillsEntityDataFactory.notifyDataSetChanged();
        }
    }

    public void hideShimmer() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        SkeletonScreen skeletonScreen = this.moveToNextValue;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public void setData(List<CategoryModel> list, boolean z) {
        if (list.isEmpty()) {
            return;
        }
        hideShimmer();
        this.getAuthRequestContext = list.get(0).MyBillsEntityDataFactory;
        setupChipsCategory(list, z);
    }

    public void setupChipsCategory(List<CategoryModel> list, boolean z) {
        if (z) {
            list.remove(1);
        }
        this.MyBillsEntityDataFactory.setItems(getAuthRequestContext(list));
        this.MyBillsEntityDataFactory.notifyDataSetChanged();
    }

    public void appendData(CategoryModel categoryModel) {
        this.MyBillsEntityDataFactory.appendItem(categoryModel);
    }

    public void appendData(List<CategoryModel> list) {
        this.MyBillsEntityDataFactory.appendItems(list);
    }

    public void removeItemEquals(CategoryModel categoryModel) {
        this.MyBillsEntityDataFactory.removeItemEquals(categoryModel);
    }

    public int getItemsSize() {
        return this.MyBillsEntityDataFactory.getItems().size();
    }

    public String getSelectedCategoryId() {
        return this.getAuthRequestContext;
    }

    public void setBottomDivider(boolean z) {
        View view = this.viewDivider;
        if (view != null) {
            view.setVisibility(z ? 0 : 4);
        }
    }

    public void setListener(OnClickListener onClickListener) {
        this.PlaceComponentResult = onClickListener;
    }

    public void hide() {
        hideShimmer();
        this.llCategory.setVisibility(8);
    }

    public void show() {
        showShimmer();
        this.llCategory.setVisibility(0);
    }

    public void setCategory(String str) {
        List<CategoryModel> items = this.MyBillsEntityDataFactory.getItems();
        if (TextUtils.isEmpty(str) || items.isEmpty()) {
            return;
        }
        boolean z = false;
        for (CategoryModel categoryModel : items) {
            if (str.equalsIgnoreCase(categoryModel.MyBillsEntityDataFactory)) {
                this.getAuthRequestContext = str;
                this.BuiltInFictitiousFunctionClassFactory = categoryModel;
                categoryModel.PlaceComponentResult = true;
                z = true;
            } else {
                categoryModel.PlaceComponentResult = false;
            }
        }
        if (z) {
            return;
        }
        items.get(0).PlaceComponentResult = true;
    }

    public boolean isDefaultSelected() {
        return this.getAuthRequestContext == null || getAuthRequestContext() == 0;
    }

    public void setDefaultSelected(boolean z) {
        OnClickListener onClickListener;
        int authRequestContext = getAuthRequestContext();
        CategoryModel item = this.MyBillsEntityDataFactory.getItem(authRequestContext);
        if (authRequestContext != 0) {
            item.PlaceComponentResult = false;
            item = this.MyBillsEntityDataFactory.getItem(0);
            item.PlaceComponentResult = true;
            this.MyBillsEntityDataFactory.notifyDataSetChanged();
        }
        if (!z || (onClickListener = this.PlaceComponentResult) == null || item == null) {
            return;
        }
        onClickListener.PlaceComponentResult(item, true);
    }

    private int getAuthRequestContext() {
        List<CategoryModel> items = this.MyBillsEntityDataFactory.getItems();
        for (int i = 0; i < items.size(); i++) {
            if (TextUtils.equals(items.get(i).MyBillsEntityDataFactory, this.getAuthRequestContext)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isHidden() {
        return this.llCategory.getVisibility() != 0;
    }

    public CategoryModel getCategoryFromExtra() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    private static List<CategoryModel> getAuthRequestContext(List<CategoryModel> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPlaceComponentResult()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (arrayList.size() > 1) {
            for (int i2 = 0; i2 < arrayList.size() - 1; i2++) {
                list.get(i2).PlaceComponentResult = false;
            }
        }
        return list;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.rvCategory.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rvCategory.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: id.dana.richview.category.CategoryView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                int dimension = (int) CategoryView.this.getResources().getDimension(R.dimen.f28052131165274);
                rect.left = dimension;
                rect.right = dimension;
            }
        });
        CategoryAdapter categoryAdapter = new CategoryAdapter(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.richview.category.CategoryView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                CategoryView.this.m2833x9fca2fc5(i);
            }
        });
        this.MyBillsEntityDataFactory = categoryAdapter;
        this.rvCategory.setAdapter(categoryAdapter);
        showShimmer();
    }
}
