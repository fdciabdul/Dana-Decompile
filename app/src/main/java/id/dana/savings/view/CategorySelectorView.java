package id.dana.savings.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.common.decoration.VerticalItemDecoration;
import id.dana.core.ui.glide.ImageAttacherFactory;
import id.dana.savings.adapter.CategoryAdapter;
import id.dana.savings.model.SavingCategoryModel;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,B+\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010*\u001a\u00020\u0007\u0012\u0006\u0010-\u001a\u00020\u0007¢\u0006\u0004\b+\u0010.J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010$"}, d2 = {"Lid/dana/savings/view/CategorySelectorView;", "Lid/dana/base/BaseRichView;", "Lid/dana/savings/model/SavingCategoryModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/savings/model/SavingCategoryModel;)Z", "", "getLayout", "()I", "", "getSelectedCategoryCode", "()Ljava/lang/String;", "", "selectCurrentCategory", "()V", "", "categories", "setCategories", "(Ljava/util/List;)V", "setup", "Lid/dana/savings/adapter/CategoryAdapter;", "getAuthRequestContext", "Lid/dana/savings/adapter/CategoryAdapter;", "MyBillsEntityDataFactory", "Lio/reactivex/subjects/PublishSubject;", "categorySavingSelectedSubject", "Lio/reactivex/subjects/PublishSubject;", "getCategorySavingSelectedSubject", "()Lio/reactivex/subjects/PublishSubject;", "setCategorySavingSelectedSubject", "(Lio/reactivex/subjects/PublishSubject;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getCurrentCategory", "setCurrentCategory", "(Ljava/lang/String;)V", "currentCategory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategorySelectorView extends BaseRichView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String currentCategory;
    public Map<Integer, View> _$_findViewCache;
    public PublishSubject<Boolean> categorySavingSelectedSubject;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private CategoryAdapter MyBillsEntityDataFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CategorySelectorView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CategorySelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_category_selector;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategorySelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.currentCategory = "";
    }

    public /* synthetic */ CategorySelectorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategorySelectorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.currentCategory = "";
    }

    @JvmName(name = "getCategorySavingSelectedSubject")
    public final PublishSubject<Boolean> getCategorySavingSelectedSubject() {
        PublishSubject<Boolean> publishSubject = this.categorySavingSelectedSubject;
        if (publishSubject != null) {
            return publishSubject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCategorySavingSelectedSubject")
    public final void setCategorySavingSelectedSubject(PublishSubject<Boolean> publishSubject) {
        Intrinsics.checkNotNullParameter(publishSubject, "");
        this.categorySavingSelectedSubject = publishSubject;
    }

    @JvmName(name = "getCurrentCategory")
    public final String getCurrentCategory() {
        return this.currentCategory;
    }

    @JvmName(name = "setCurrentCategory")
    public final void setCurrentCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.currentCategory = str;
    }

    public final void setCategories(List<SavingCategoryModel> categories) {
        Intrinsics.checkNotNullParameter(categories, "");
        CategoryAdapter categoryAdapter = this.MyBillsEntityDataFactory;
        if (categoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            categoryAdapter = null;
        }
        categoryAdapter.setItems(categories);
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(SavingCategoryModel p0) {
        return !Intrinsics.areEqual(this.currentCategory, p0 != null ? p0.BuiltInFictitiousFunctionClassFactory : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void selectCurrentCategory() {
        if (this.currentCategory.length() == 0) {
            return;
        }
        CategoryAdapter categoryAdapter = this.MyBillsEntityDataFactory;
        SavingCategoryModel savingCategoryModel = null;
        if (categoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            categoryAdapter = null;
        }
        CategoryAdapter categoryAdapter2 = this.MyBillsEntityDataFactory;
        if (categoryAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            categoryAdapter2 = null;
        }
        String str = this.currentCategory;
        Intrinsics.checkNotNullParameter(str, "");
        List<SavingCategoryModel> items = categoryAdapter2.getItems();
        if (items != null) {
            Iterator<T> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((SavingCategoryModel) next).BuiltInFictitiousFunctionClassFactory, str)) {
                    savingCategoryModel = next;
                    break;
                }
            }
            savingCategoryModel = savingCategoryModel;
        }
        if (savingCategoryModel == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.savings.model.SavingCategoryModel");
        }
        categoryAdapter.MyBillsEntityDataFactory.invoke(savingCategoryModel);
        categoryAdapter.getAuthRequestContext = savingCategoryModel;
        categoryAdapter.notifyDataSetChanged();
    }

    public final String getSelectedCategoryCode() {
        CategoryAdapter categoryAdapter = this.MyBillsEntityDataFactory;
        if (categoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            categoryAdapter = null;
        }
        SavingCategoryModel savingCategoryModel = categoryAdapter.getAuthRequestContext;
        String str = savingCategoryModel != null ? savingCategoryModel.BuiltInFictitiousFunctionClassFactory : null;
        return str == null ? "" : str;
    }

    public static /* synthetic */ void $r8$lambda$JqcXIZm6uOm_uM1_c8xvXb3G5N0(Context context, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "");
        new ImageAttacherFactory().KClassImpl$Data$declaredNonStaticMembers$2(context, imageView, str, R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        setCategorySavingSelectedSubject(PlaceComponentResult);
        getCategorySavingSelectedSubject().onNext(Boolean.FALSE);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1144_rxconvertkt_ascompletable_1);
        if (recyclerView != null) {
            CategoryAdapter categoryAdapter = new CategoryAdapter();
            recyclerView.setAdapter(categoryAdapter);
            CategorySelectorView$setupRecyclerView$1$1$1 categorySelectorView$setupRecyclerView$1$1$1 = new CategorySelectorView$setupRecyclerView$1$1$1(this);
            Intrinsics.checkNotNullParameter(categorySelectorView$setupRecyclerView$1$1$1, "");
            categoryAdapter.MyBillsEntityDataFactory = categorySelectorView$setupRecyclerView$1$1$1;
            this.MyBillsEntityDataFactory = categoryAdapter;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new VerticalItemDecoration(16));
        }
    }
}
