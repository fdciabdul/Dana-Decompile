package id.dana.richview.promocenter;

import android.content.Context;
import android.util.AttributeSet;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.common.model.OptionModel;
import id.dana.contract.promocenter.PromoCategoryContract;
import id.dana.contract.promocenter.PromoCategoryModule;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPromoCategoryComponent;
import id.dana.di.component.PromoCategoryComponent;
import id.dana.richview.EndlessOnScrollListener;
import id.dana.richview.category.CategoryView;
import id.dana.richview.category.model.CategoryModel;
import id.dana.utils.StringWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class PromoCategoryView extends CategoryView implements PromoCategoryContract.View {
    private final Map<String, Boolean> BuiltInFictitiousFunctionClassFactory;
    private PromoCategoryComponent KClassImpl$Data$declaredNonStaticMembers$2;
    private SetOnGetCategoriesListener MyBillsEntityDataFactory;
    private long getAuthRequestContext;
    @Inject
    PromoCategoryContract.Presenter promoCategoryPresenter;

    /* loaded from: classes5.dex */
    public interface SetOnGetCategoriesListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult(CategoryModel categoryModel);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    public PromoCategoryView(Context context) {
        super(context);
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
    }

    public PromoCategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
    }

    public PromoCategoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
    }

    @Override // id.dana.richview.category.CategoryView, id.dana.base.BaseRichView
    public void setup() {
        super.setup();
        setBottomDivider(false);
        setOnCategoryScrollListener(new EndlessOnScrollListener() { // from class: id.dana.richview.promocenter.PromoCategoryView.1
            @Override // id.dana.richview.EndlessOnScrollListener
            public final int MyBillsEntityDataFactory() {
                return 4;
            }

            @Override // id.dana.richview.EndlessOnScrollListener
            public final void getAuthRequestContext() {
                PromoCategoryView.this.promoCategoryPresenter.getAuthRequestContext(true);
            }

            @Override // id.dana.richview.EndlessOnScrollListener
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
                return PromoCategoryView.this.getAuthRequestContext > 0 && !PromoCategoryView.this.isLoading() && PromoCategoryView.this.getAuthRequestContext > 20 && PromoCategoryView.this.getAuthRequestContext > ((long) (PromoCategoryView.this.getItemsSize() - 1));
            }
        });
        this.promoCategoryPresenter.getAuthRequestContext(false);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        super.injectComponent(applicationComponent);
        byte b = 0;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            DaggerPromoCategoryComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerPromoCategoryComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (PromoCategoryModule) Preconditions.getAuthRequestContext(new PromoCategoryModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, PromoCategoryModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, ApplicationComponent.class);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new DaggerPromoCategoryComponent.PromoCategoryComponentImpl(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, b);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this);
        registerPresenter(this.promoCategoryPresenter);
    }

    @Override // id.dana.contract.promocenter.PromoCategoryContract.View
    public void onSuccessGetCategories(long j, List<CategoryModel> list) {
        this.getAuthRequestContext = j;
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.MyBillsEntityDataFactory = "promocenter_category_all";
        categoryModel.KClassImpl$Data$declaredNonStaticMembers$2 = getContext().getString(R.string.promo_center_all_promos_category);
        categoryModel.moveToNextValue = new StringWrapper.ResValue(R.string.promo_center_all_promos_category, new ArrayList());
        categoryModel.BuiltInFictitiousFunctionClassFactory = new StringWrapper.ResValue(R.string.promo_center_all_promos_category, new ArrayList());
        categoryModel.PlaceComponentResult = true;
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(arrayList, "");
        categoryModel.getAuthRequestContext = arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            for (CategoryModel categoryModel2 : list) {
                ArrayList arrayList3 = new ArrayList();
                if (categoryModel2 != null && categoryModel2.getErrorConfigVersion != null) {
                    for (OptionModel optionModel : categoryModel2.getErrorConfigVersion) {
                        if (this.BuiltInFictitiousFunctionClassFactory.get(optionModel.getAuthRequestContext) == null || !this.BuiltInFictitiousFunctionClassFactory.get(optionModel.getAuthRequestContext).booleanValue()) {
                            arrayList3.add(optionModel);
                            this.BuiltInFictitiousFunctionClassFactory.put(optionModel.getAuthRequestContext, Boolean.TRUE);
                        }
                    }
                }
                arrayList2.addAll(arrayList3);
            }
        }
        Intrinsics.checkNotNullParameter(arrayList2, "");
        categoryModel.getErrorConfigVersion = arrayList2;
        categoryModel.scheduleImpl = 1;
        list.add(0, categoryModel);
        setData(list);
        SetOnGetCategoriesListener setOnGetCategoriesListener = this.MyBillsEntityDataFactory;
        if (setOnGetCategoriesListener != null) {
            setOnGetCategoriesListener.PlaceComponentResult(categoryModel);
        }
    }

    @Override // id.dana.contract.promocenter.PromoCategoryContract.View
    public void onSuccessLoadMoreCategories(long j, List<CategoryModel> list) {
        this.getAuthRequestContext = j;
        appendData(list);
    }

    @Override // id.dana.contract.promocenter.PromoCategoryContract.View
    public void onFailGetCategories() {
        hide();
        SetOnGetCategoriesListener setOnGetCategoriesListener = this.MyBillsEntityDataFactory;
        if (setOnGetCategoriesListener != null) {
            setOnGetCategoriesListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.contract.promocenter.PromoCategoryContract.View
    public void showShimmerView() {
        setLoading(true);
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.scheduleImpl = 2;
        appendData(categoryModel);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        showShimmer();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        hideShimmer();
    }

    public void retryGetCategories() {
        this.promoCategoryPresenter.getAuthRequestContext(false);
    }

    public void setOnGetCategoriesListener(SetOnGetCategoriesListener setOnGetCategoriesListener) {
        this.MyBillsEntityDataFactory = setOnGetCategoriesListener;
    }

    @Override // id.dana.contract.promocenter.PromoCategoryContract.View
    public void hideShimmerView() {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.scheduleImpl = 2;
        removeItemEquals(categoryModel);
        setLoading(false);
    }
}
