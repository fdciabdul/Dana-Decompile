package id.dana.nearbyme;

import id.dana.nearbyme.model.MerchantCategoryModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016J\u001e\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/OnCategoryCheckedListener;", "", "onCategoryClick", "", "selectedCategory", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "onMulitpleCategorySelected", "checkedCategories", "", "checked", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface OnCategoryCheckedListener {

    /* renamed from: id.dana.nearbyme.OnCategoryCheckedListener$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static void BuiltInFictitiousFunctionClassFactory(MerchantCategoryModel merchantCategoryModel) {
            Intrinsics.checkNotNullParameter(merchantCategoryModel, "");
        }

        public static void PlaceComponentResult(List list) {
            Intrinsics.checkNotNullParameter(list, "");
        }
    }

    void onCategoryClick(MerchantCategoryModel selectedCategory);

    void onMulitpleCategorySelected(List<MerchantCategoryModel> checkedCategories);

    void onMulitpleCategorySelected(List<MerchantCategoryModel> checkedCategories, boolean checked);
}
