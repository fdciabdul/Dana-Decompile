package id.dana.savings.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.savings.model.SavingCategoryModel;
import id.dana.savings.viewholder.CategoryViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR%\u0010\u0010\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\u00070\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/savings/adapter/CategoryAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/savings/viewholder/CategoryViewHolder;", "Lid/dana/savings/model/SavingCategoryModel;", "p0", "", "p1", "", "PlaceComponentResult", "(Lid/dana/savings/viewholder/CategoryViewHolder;I)V", "", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/savings/model/SavingCategoryModel;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryAdapter extends BaseRecyclerViewAdapter<CategoryViewHolder, SavingCategoryModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public SavingCategoryModel getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Function1<? super SavingCategoryModel, Unit> MyBillsEntityDataFactory = new Function1<SavingCategoryModel, Unit>() { // from class: id.dana.savings.adapter.CategoryAdapter$onItemSelected$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(SavingCategoryModel savingCategoryModel) {
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(SavingCategoryModel savingCategoryModel) {
            invoke2(savingCategoryModel);
            return Unit.INSTANCE;
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return new CategoryViewHolder(context, viewGroup);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void setItems(List<SavingCategoryModel> p0) {
        super.setItems(p0);
        SavingCategoryModel savingCategoryModel = p0 != null ? (SavingCategoryModel) CollectionsKt.getOrNull(p0, 0) : null;
        this.MyBillsEntityDataFactory.invoke(savingCategoryModel);
        this.getAuthRequestContext = savingCategoryModel;
        notifyDataSetChanged();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    /* renamed from: PlaceComponentResult */
    public void onBindViewHolder(CategoryViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        SavingCategoryModel item = getItem(p1);
        if (item != null) {
            item.moveToNextValue = Intrinsics.areEqual(this.getAuthRequestContext, item);
        }
        p0.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.savings.adapter.CategoryAdapter$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                CategoryAdapter.PlaceComponentResult(CategoryAdapter.this, i);
            }
        });
        super.onBindViewHolder((CategoryAdapter) p0, p1);
    }

    public static /* synthetic */ void PlaceComponentResult(CategoryAdapter categoryAdapter, int i) {
        Intrinsics.checkNotNullParameter(categoryAdapter, "");
        SavingCategoryModel item = categoryAdapter.getItem(i);
        categoryAdapter.MyBillsEntityDataFactory.invoke(item);
        categoryAdapter.getAuthRequestContext = item;
        categoryAdapter.notifyDataSetChanged();
    }
}
